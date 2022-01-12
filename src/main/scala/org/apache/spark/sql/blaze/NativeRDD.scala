package org.apache.spark.sql.blaze

import java.io.ByteArrayInputStream
import java.nio.ByteBuffer

import scala.collection.JavaConverters._

import org.apache.arrow.vector.ipc.ArrowStreamReader
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.Partition
import org.apache.spark.TaskContext
import org.apache.spark.sql.util.ArrowUtils
import org.apache.spark.sql.vectorized.ArrowColumnVector
import org.apache.spark.sql.vectorized.ColumnarBatch
import org.apache.spark.sql.vectorized.ColumnVector
import org.apache.spark.Dependency
import org.apache.spark.SparkContext
import org.ballistacompute.protobuf.PartitionId
import org.ballistacompute.protobuf.PhysicalHashRepartition
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.TaskDefinition

case class NativeRDD(
  @transient private val rddSparkContext: SparkContext,
  private val rddPartitions: Array[Partition],
  private val rddDependencies: Seq[Dependency[_]],
  nativePlan: PhysicalPlanNode,
) extends RDD[InternalRow](rddSparkContext, rddDependencies) with Logging {

  override protected def getPartitions: Array[Partition] = rddPartitions
  override protected def getDependencies: Seq[Dependency[_]] = rddDependencies

  override def compute(split: Partition, context: TaskContext): Iterator[InternalRow] = {
    val stageId = context.stageId()
    val jobId = split.index

    val partitionId = PartitionId.newBuilder()
      .setPartitionId(split.index)
      .setStageId(stageId)
      .setJobId(jobId.toString)
      .build()
    logInfo(s"NativeRDD.partitionId: ${partitionId}")

    val taskDefinition = TaskDefinition.newBuilder()
      .setTaskId(partitionId)
      .setPlan(nativePlan)
      .build()
      .toByteArray
    val taskDefinitionByteBuffer = ByteBuffer.allocateDirect(taskDefinition.length)
    taskDefinitionByteBuffer.put(taskDefinition)

    // note: consider passing a ByteBufferOutputStream to blaze-rs to avoid copying

    var outputBytes: Array[Byte] = null
    JniBridge.callNative(taskDefinitionByteBuffer, (byteBuffer: ByteBuffer) => {
      logInfo(s"Received bytes from native computing: ${byteBuffer.limit()}")
      outputBytes = new Array[Byte](byteBuffer.limit())
      byteBuffer.get(outputBytes)
    })
    toIterator(new ByteArrayInputStream(outputBytes))
  }

  private def toIterator(inputStream: ByteArrayInputStream): Iterator[InternalRow] = {
    val allocator = ArrowUtils.rootAllocator.newChildAllocator("readNativeRDDBatches", 0, Long.MaxValue)
    val arrowReader = new ArrowStreamReader(inputStream, allocator)
    val root = arrowReader.getVectorSchemaRoot

    new Iterator[InternalRow] {
      private var rowIter: Iterator[InternalRow] = null
      loadNextBatch

      override def hasNext: Boolean = {
        while (!rowIter.hasNext) {
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
