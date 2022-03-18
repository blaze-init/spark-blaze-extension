package org.apache.spark.sql.blaze

import java.io.ByteArrayInputStream
import java.nio.ByteBuffer

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

import org.apache.arrow.vector.ipc.ArrowStreamReader
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.SparkException
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.adaptive.CustomShuffleReaderExec
import org.apache.spark.sql.execution.adaptive.QueryStageExec
import org.apache.spark.TaskContext
import org.apache.spark.sql.execution.metric.SQLMetric
import org.apache.spark.sql.execution.metric.SQLMetrics
import org.apache.spark.sql.util2.ArrowUtils2
import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.sql.blaze.execution.ArrowReaderIterator
import org.apache.spark.SparkEnv
import org.blaze.protobuf.PartitionId
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.TaskDefinition

trait NativeSupports {
   def doExecuteNative(): NativeRDD
}

object NativeSupports extends Logging {
   @tailrec def isNative(plan: SparkPlan): Boolean = plan match {
      case _: NativeSupports => true
      case plan: CustomShuffleReaderExec => isNative(plan.child)
      case plan: QueryStageExec => isNative(plan.plan)
      case _ => false
   }

   @tailrec def executeNative(plan: SparkPlan): NativeRDD = plan match {
      case plan: NativeSupports => plan.doExecuteNative()
      case plan: CustomShuffleReaderExec => executeNative(plan.child)
      case plan: QueryStageExec => executeNative(plan.plan)
      case _ => throw new SparkException(s"Underlying plan is not NativeSupports: ${plan}")
   }

   def executeNativePlan(
     nativePlan: PhysicalPlanNode,
     metrics: MetricNode,
     context: TaskContext,
   ): Iterator[InternalRow] = {

      val partitionId = PartitionId.newBuilder()
        .setPartitionId(context.partitionId())
        .setStageId(context.stageId())
        .setJobId(context.partitionId().toString)
        .build()

      val taskDefinition = TaskDefinition.newBuilder()
        .setTaskId(partitionId)
        .setPlan(nativePlan)
        .build()

      // note: consider passing a ByteBufferOutputStream to blaze-rs to avoid copying
      if (SparkEnv.get.conf.getBoolean("spark.kwai.blaze.dumpNativePlanBeforeExecuting", defaultValue = false)) {
         logInfo(s"Start executing native plan: ${taskDefinition.toString}")
      } else {
         logInfo(s"Start executing native plan")
      }

      val outputBytesBatches: ArrayBuffer[Array[Byte]] = ArrayBuffer()
      JniBridge.callNative(taskDefinition.toByteArray, metrics, byteBuffer => {
         val outputBytes = new Array[Byte](byteBuffer.limit())
         byteBuffer.get(outputBytes)
         outputBytesBatches.append(outputBytes)
      })

      outputBytesBatches.map(outputBytes => {
         val arrowBytesInputStream = new ByteArrayInputStream(outputBytes)
         val allocator = ArrowUtils2.rootAllocator.newChildAllocator("readNativeRDDBatches", 0, Long.MaxValue)
         val arrowReader = new ArrowStreamReader(arrowBytesInputStream, allocator)

         context.addTaskCompletionListener[Unit] { _ =>
            arrowReader.close()
            allocator.close()
            arrowBytesInputStream.close()
         }
         new ArrowReaderIterator(arrowReader)
      }).foldLeft(Iterator[InternalRow]())(_ ++ _)
   }

   def getDefaultNativeMetrics(sparkContext: SparkContext): Map[String, SQLMetric] = Map(
      "numOutputRows" -> SQLMetrics.createMetric(sparkContext, "number of output rows"),
      "blazeExecIPCWrittenRows" -> SQLMetrics.createMetric(sparkContext, "blaze exec IPC written rows"),
      "blazeExecIPCWrittenBytes" -> SQLMetrics.createSizeMetric(sparkContext, "blaze exec IPC written bytes"),
      "blazeExecTime" -> SQLMetrics.createNanoTimingMetric(sparkContext, "blaze exec time"),
      "blazeShuffleWriteExecTime" -> SQLMetrics.createNanoTimingMetric(sparkContext, "blaze shuffle write exec time"),
   )
}

case class MetricNode(
  metrics: Map[String, SQLMetric],
  children: Seq[MetricNode],
) {
   def getChild(i: Int): MetricNode =
      children(i)

   def add(metricName: String, v: Long): Unit =
      metrics.get(metricName).foreach(_.add(v))
}
