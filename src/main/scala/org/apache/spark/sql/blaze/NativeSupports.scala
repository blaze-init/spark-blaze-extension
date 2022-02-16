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
import org.apache.spark.sql.util.ArrowUtils
import org.apache.spark.sql.vectorized.ArrowColumnVector
import org.apache.spark.sql.vectorized.ColumnarBatch
import org.apache.spark.sql.vectorized.ColumnVector
import org.blaze.protobuf.PartitionId
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.TaskDefinition

trait NativeSupports {
   def doExecuteNative(): NativeRDD
}

object NativeSupports {
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
        .setStageId(0)
        .setJobId(NativeRDD.getNativeJobId(context))
        .build()

      val taskDefinition = TaskDefinition.newBuilder()
        .setTaskId(partitionId)
        .setPlan(nativePlan)
        .build()
        .toByteArray
      val taskDefinitionByteBuffer = ByteBuffer.allocateDirect(taskDefinition.length)
      taskDefinitionByteBuffer.put(taskDefinition)

      // note: consider passing a ByteBufferOutputStream to blaze-rs to avoid copying

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


   private def toIterator(inputStream: ByteArrayInputStream): Iterator[InternalRow] = {
      val allocator = ArrowUtils.rootAllocator.newChildAllocator("readNativeRDDBatches", 0, Long.MaxValue)
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
