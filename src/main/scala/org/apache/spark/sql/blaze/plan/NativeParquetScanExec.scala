package org.apache.spark.sql.blaze.plan

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.execution.FileSourceScanExec
import org.apache.spark.sql.execution.LeafExecNode
import org.apache.spark.sql.execution.datasources.FilePartition
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.apache.spark.Partition
import org.ballistacompute.protobuf.FileGroup
import org.ballistacompute.protobuf.FileScanExecConf
import org.ballistacompute.protobuf.ParquetScanExecNode
import org.ballistacompute.protobuf.PartitionedFile
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.ScanLimit
import org.ballistacompute.protobuf.Statistics

case class NativeParquetScanExec(basedFileScan: FileSourceScanExec) extends LeafExecNode with NativeSupports {

  override def output: Seq[Attribute] = basedFileScan.output

  override def doExecuteNative(): NativeRDD = {
    val inputFileScanRDD = basedFileScan.inputRDD.asInstanceOf[FileScanRDD]
    val partitions = inputFileScanRDD.filePartitions.toArray
    NativeRDD(sparkContext, partitions.asInstanceOf[Array[Partition]], Nil, {
      val nativeParquetScanConfBuilder = FileScanExecConf.newBuilder()
        .setStatistics(Statistics.getDefaultInstance)
        .setSchema(NativeConverters.convertSchema(basedFileScan.requiredSchema))
        .setBatchSize(100)

      partitions.foreach { filePartition =>
        val nativeFileGroupBuilder = FileGroup.newBuilder()
        filePartition.files.foreach { file =>
          nativeFileGroupBuilder.addFiles(PartitionedFile.newBuilder()
            .setPath(file.filePath)
            .setSize(file.length)
            .setLastModifiedNs(0)
            .build())
        }
        nativeParquetScanConfBuilder.addFileGroups(nativeFileGroupBuilder.build())
      }

      val nativeParquetScanExec = ParquetScanExecNode.newBuilder()
        .setBaseConf(nativeParquetScanConfBuilder.build())
        .build()
      PhysicalPlanNode.newBuilder().setParquetScan(nativeParquetScanExec).build()
    })
  }

  override def simpleString(maxFields: Int): String =
    s"$nodeName (${basedFileScan.simpleString(maxFields)})"
}