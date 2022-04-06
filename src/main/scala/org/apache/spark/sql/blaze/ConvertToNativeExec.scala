package org.apache.spark.sql.blaze

import java.util.UUID

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.catalyst.plans.physical.Partitioning
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.metric.SQLMetric
import org.apache.spark.sql.execution.metric.SQLMetrics
import org.apache.spark.sql.util2.ArrowWriter
import org.apache.spark.SparkEnv
import org.apache.spark.sql.blaze.execution.ArrowWriterIterator
import org.apache.spark.sql.blaze.execution.Converters
import org.apache.spark.sql.internal.SQLConf
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.ShuffleReaderExecNode

case class ConvertToNativeExec(override val child: SparkPlan)
    extends UnaryExecNode
    with NativeSupports {
  override def nodeName: String = "ConvertToNative"
  override def logicalLink: Option[LogicalPlan] = child.logicalLink
  override def output: Seq[Attribute] = child.output
  override def outputPartitioning: Partitioning = child.outputPartitioning

  override lazy val metrics: Map[String, SQLMetric] =
    NativeSupports.getDefaultNativeMetrics(sparkContext)

  override def doExecute(): RDD[InternalRow] = doExecuteNative()
  override def doExecuteNative(): NativeRDD = {
    val inputRDD = child.execute()
    val timeZoneId = SparkEnv.get.conf.get(SQLConf.SESSION_LOCAL_TIMEZONE)
    val nativeMetrics = MetricNode(
      Map(
        "output_rows" -> metrics("numOutputRows"),
        "blaze_output_ipc_rows" -> metrics("blazeExecIPCWrittenRows"),
        "blaze_output_ipc_bytes" -> metrics("blazeExecIPCWrittenBytes"),
        "blaze_exec_time" -> metrics("blazeExecTime")),
      Nil)

    new NativeRDD(
      sparkContext,
      nativeMetrics,
      inputRDD.partitions,
      inputRDD.dependencies,
      (partition, context) => {
        val inputRowIter = inputRDD.compute(partition, context)
        val arrowWriterIterator =
          new ArrowWriterIterator(inputRowIter, schema, timeZoneId, context)
        val resourceId = "ConvertToNativeExec" +
          s":stage=${context.stageId()}" +
          s":partition=${context.partitionId()}" +
          s":taskAttempt=${context.taskAttemptId()}" +
          s":uuid=${UUID.randomUUID().toString}"
        JniBridge.resourcesMap.put(resourceId, arrowWriterIterator)

        PhysicalPlanNode
          .newBuilder()
          .setShuffleReader(
            ShuffleReaderExecNode
              .newBuilder()
              .setSchema(NativeConverters.convertSchema(schema))
              .setNativeShuffleId(resourceId)
              .build())
          .build()
      })
  }
}
