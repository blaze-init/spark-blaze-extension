package org.apache.spark.sql.blaze

import java.nio.ByteBuffer

import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.Partition
import org.apache.spark.SparkEnv
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
    val executorId = SparkEnv.get.executorId
    val stageId = context.stageId()
    val jobId = context.getLocalProperty("job.id")
    val writeDir = context.getLocalProperty("write.dir")
    val writeFile = context.getLocalProperty("write.file")

    val partitionId = PartitionId.newBuilder()
      .setPartitionId(split.index)
      .setStageId(stageId)
      .setJobId(jobId)
      .build()
    logInfo(s"NativeRDD.partitionId: ${partitionId}")

    val taskDefinition = TaskDefinition.newBuilder()
      .setTaskId(partitionId)
      .setPlan(nativePlan)
      .build()
      .toByteArray

    BlazeBridge.callNative(ByteBuffer.wrap(taskDefinition), executorId, writeDir, writeFile)

    new Iterator[InternalRow] {
      override def hasNext: Boolean = throw new RuntimeException("hasNext called!")
      override def next(): InternalRow = null
    }
  }
}
