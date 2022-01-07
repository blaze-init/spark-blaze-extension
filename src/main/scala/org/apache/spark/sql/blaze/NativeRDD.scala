package org.apache.spark.sql.blaze

import java.io.ByteArrayInputStream
import java.nio.ByteBuffer

import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConverters._

import org.apache.arrow.memory.RootAllocator
import org.apache.arrow.vector.ipc.ArrowStreamReader
import org.apache.arrow.vector.FieldVector
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.Partition
import org.apache.spark.TaskContext
import org.ballistacompute.protobuf.PartitionId
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.TaskDefinition

case class NativeRDD(
  @transient val inner: RDD[InternalRow],
  nativePlan: PhysicalPlanNode,
) extends RDD[InternalRow](inner.sparkContext, Nil) with Logging {

  override protected def getPartitions: Array[Partition] = inner.partitions

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

    val records: ArrayBuffer[FieldVector] = ArrayBuffer()
    BlazeBridge.callNative(taskDefinitionByteBuffer, (byteBuffer: ByteBuffer) => {
      val inputStream = new ByteArrayInputStream(byteBuffer.array())
      val arrowStreamReader  = new ArrowStreamReader(inputStream, new RootAllocator)
      while (arrowStreamReader.loadNextBatch()) {
        records.appendAll(arrowStreamReader.getVectorSchemaRoot.getFieldVectors.asScala)
      }
    })

    println(records(0))
    new Iterator[InternalRow] {
      override def hasNext: Boolean = throw new RuntimeException("hasNext called!")
      override def next(): InternalRow = null
    }
  }
}
