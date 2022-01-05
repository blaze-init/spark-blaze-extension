package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.FileSourceScanExec
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.ballistacompute.protobuf.FileGroup
import org.ballistacompute.protobuf.FileScanExecConf
import org.ballistacompute.protobuf.ParquetScanExecNode
import org.ballistacompute.protobuf.PartitionedFile
import org.ballistacompute.protobuf.PhysicalPlanNode

case class NativeParquetScanExec(override val child: FileSourceScanExec) extends NativeUnaryExecNode {

  override def output: Seq[Attribute] = child.output

  private def inputFileScanRDD: FileScanRDD = child.inputRDD.asInstanceOf[FileScanRDD]

  override protected def doExecute(): RDD[InternalRow] =
    NativeRDD(inputFileScanRDD, toNativePlan)

  override def toNativePlan: PhysicalPlanNode = {
    val nativeFileGroupBuilder = FileGroup.newBuilder()
    inputFileScanRDD.filePartitions.foreach { filePartition =>
      val singleFilePartition = filePartition.files(0) // parquet scan always generate single file partition
      val partitionedFile = PartitionedFile.newBuilder()
        .setPath(singleFilePartition.filePath)
        .setSize(singleFilePartition.length)
        .build()
      nativeFileGroupBuilder.addFiles(partitionedFile)
    }
    val nativeFileGroup = nativeFileGroupBuilder.build()

    val nativeParquetScanConf = FileScanExecConf.newBuilder()
      .setSchema(NativeConverters.convertSchema(child.requiredSchema))
      .addFileGroups(nativeFileGroup)
      .build()

    val nativeParquetScanExec = ParquetScanExecNode.newBuilder()
      .setBaseConf(nativeParquetScanConf)
      .build()

    PhysicalPlanNode.newBuilder().setParquetScan(nativeParquetScanExec).build()
  }
}
