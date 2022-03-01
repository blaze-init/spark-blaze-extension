package org.apache.spark.sql.blaze

import java.io.ByteArrayInputStream
import java.nio.ByteBuffer

import scala.annotation.tailrec
import scala.collection.JavaConverters._

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
import org.apache.spark.sql.util2.ArrowColumnVector
import org.apache.spark.sql.vectorized.ColumnarBatch
import org.apache.spark.sql.vectorized.ColumnVector
import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.blaze.protobuf.PartitionId
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.TaskDefinition

trait NativeSupports {
   def doExecuteNative(): NativeRDD
}

object NativeSupports extends Logging {
   @tailrec def executeNative(plan: SparkPlan): NativeRDD = plan match {
      case plan: NativeSupports => plan.doExecuteNative()
      case plan: CustomShuffleReaderExec => executeNative(plan.child)
      case plan: QueryStageExec => executeNative(plan.plan)
      case _ => throw new SparkException(s"Underlaying plan is not NativeSupports: ${plan}")
   }

   def executeNativePlan(
     nativePlan: PhysicalPlanNode,
     metrics: MetricNode,
     context: TaskContext,
   ): Iterator[InternalRow] = {

      val partitionId = PartitionId.newBuilder()
        .setPartitionId(context.partitionId())
        .setStageId(context.stageId())
        .setJobId(NativeRDD.getNativeJobId(context))
        .build()

      val taskDefinition = TaskDefinition.newBuilder()
        .setTaskId(partitionId)
        .setPlan(nativePlan)
        .build()

      val taskDefinitionBytes = taskDefinition.toByteArray
      val taskDefinitionByteBuffer = ByteBuffer.allocateDirect(taskDefinitionBytes.length)
      taskDefinitionByteBuffer.put(taskDefinitionBytes)

      // note: consider passing a ByteBufferOutputStream to blaze-rs to avoid copying

      logInfo(s"Start executing native plan: ${taskDefinition.toString}")
      var outputBytes: Array[Byte] = null
      JniBridge.callNative(taskDefinitionByteBuffer, metrics, byteBuffer => {
         if (byteBuffer != null) {
            outputBytes = new Array[Byte](byteBuffer.limit())
            byteBuffer.get(outputBytes)
         }
      })

      if (outputBytes == null) {
         return Nil.toIterator
      }
      toIterator(new ByteArrayInputStream(outputBytes))
   }

   def getDefaultNativeMetrics(sparkContext: SparkContext): Map[String, SQLMetric] = Map(
      "numOutputRows" -> SQLMetrics.createMetric(sparkContext, "number of output rows"),
      "blazeExecIPCWrittenRows" -> SQLMetrics.createMetric(sparkContext, "blaze exec IPC written rows"),
      "blazeExecIPCWrittenBytes" -> SQLMetrics.createSizeMetric(sparkContext, "blaze exec IPC written bytes"),
      "blazeExecTime" -> SQLMetrics.createNanoTimingMetric(sparkContext, "blaze exec time"),
      "blazeShuffleWriteExecTime" -> SQLMetrics.createNanoTimingMetric(sparkContext, "blaze shuffle write exec time"),
   )

   private def toIterator(inputStream: ByteArrayInputStream): Iterator[InternalRow] = {
      val allocator = ArrowUtils2.rootAllocator.newChildAllocator("readNativeRDDBatches", 0, Long.MaxValue)
      val arrowReader = new ArrowStreamReader(inputStream, allocator)
      val root = arrowReader.getVectorSchemaRoot

      new Iterator[InternalRow] {
         private var rowIter: Iterator[InternalRow] = null

         override def hasNext: Boolean = {
            while (rowIter == null || !rowIter.hasNext) {
               if (!loadNextBatch) {
                  return false
               }
            }
            true
         }

         override def next: InternalRow = rowIter.next()

         private def loadNextBatch: Boolean = {
            if (arrowReader.loadNextBatch()) {
               val columns = root.getFieldVectors.asScala.map { vector =>
                  new ArrowColumnVector(vector).asInstanceOf[ColumnVector]
               }.toArray

               val batch = new ColumnarBatch(columns)
               batch.setNumRows(root.getRowCount)
               rowIter = batch.rowIterator().asScala
               true

            } else {
               root.close()
               allocator.close()
               false
            }
         }
      }
   }
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
