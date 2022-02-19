package org.apache.spark.sql.blaze.plan

import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.execution.FileSourceScanExec
import org.apache.spark.sql.execution.LeafExecNode
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.apache.spark.Partition
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.MetricNode
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.metric.SQLMetric
import org.blaze.protobuf.FileGroup
import org.blaze.protobuf.FileScanExecConf
import org.blaze.protobuf.ParquetScanExecNode
import org.blaze.protobuf.PartitionedFile
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.Statistics

case class NativeParquetScanExec(basedFileScan: FileSourceScanExec) extends LeafExecNode with NativeSupports {

  override lazy val metrics: Map[String, SQLMetric] = NativeSupports.getDefaultNativeMetrics(sparkContext)

  override def output: Seq[Attribute] = basedFileScan.output

  override def doExecute(): RDD[InternalRow] = doExecuteNative()

  override def doExecuteNative(): NativeRDD = {
    val inputFileScanRDD = basedFileScan.inputRDD.asInstanceOf[FileScanRDD]
    val partitions = inputFileScanRDD.filePartitions.toArray
    val nativeMetrics = MetricNode(Map(
      "output_rows" -> metrics("numOutputRows"),
      "blaze_output_ipc_rows" -> metrics("blazeExecIPCWrittenRows"),
      "blaze_output_ipc_bytes" -> metrics("blazeExecIPCWrittenBytes"),
      "blaze_exec_time" -> metrics("blazeExecTime"),
    ), Nil)

    new NativeRDD(sparkContext, nativeMetrics, partitions.asInstanceOf[Array[Partition]], Nil, {
      val nativeParquetScanConfBuilder = FileScanExecConf.newBuilder()
        .setStatistics(Statistics.getDefaultInstance)
        .setSchema(NativeConverters.convertSchema(basedFileScan.requiredSchema))

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

  override val nodeName: String =
    s"NativeParquetScan ${basedFileScan.tableIdentifier.map(_.unquotedString).getOrElse("")}"

  override def simpleString(maxFields: Int): String =
    s"$nodeName (${basedFileScan.simpleString(maxFields)})"
}