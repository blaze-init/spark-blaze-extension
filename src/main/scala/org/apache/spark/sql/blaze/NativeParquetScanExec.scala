package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.FileSourceScanExec
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.apache.spark.sql.execution.LeafExecNode
import org.ballistacompute.protobuf.FileGroup
import org.ballistacompute.protobuf.FileScanExecConf
import org.ballistacompute.protobuf.ParquetScanExecNode
import org.ballistacompute.protobuf.PartitionedFile
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.ScanLimit
import org.ballistacompute.protobuf.Statistics

case class NativeParquetScanExec(basedFileScan: FileSourceScanExec) extends BaseNativeExec with LeafExecNode {

  override def output: Seq[Attribute] = basedFileScan.output

  override def inputFileScanRDD: FileScanRDD = basedFileScan.inputRDD.asInstanceOf[FileScanRDD]

  override def toNativePlan: PhysicalPlanNode = {
    val nativeFileGroupBuilder = FileGroup.newBuilder()
    inputFileScanRDD.filePartitions.foreach { filePartition =>
      val singleFilePartition = filePartition.files(0) // parquet scan always generate single file partition
      val partitionedFile = PartitionedFile.newBuilder()
        .setPath(singleFilePartition.filePath)
        .setSize(singleFilePartition.length)
        .setLastModifiedNs(0)
        .build()
      nativeFileGroupBuilder.addFiles(partitionedFile)
    }
    val nativeFileGroup = nativeFileGroupBuilder.build()

    val nativeParquetScanConf = FileScanExecConf.newBuilder()
      .setStatistics(Statistics.getDefaultInstance)
      .setLimit(ScanLimit.getDefaultInstance)
      .setSchema(NativeConverters.convertSchema(basedFileScan.requiredSchema))
      .addFileGroups(nativeFileGroup)
      .setBatchSize(100)
      .build()

    val nativeParquetScanExec = ParquetScanExecNode.newBuilder()
      .setBaseConf(nativeParquetScanConf)
      .build()

    PhysicalPlanNode.newBuilder().setParquetScan(nativeParquetScanExec).build()
  }

  override def simpleString(maxFields: Int): String =
    s"$nodeName (${basedFileScan.simpleString(maxFields)})"
}
