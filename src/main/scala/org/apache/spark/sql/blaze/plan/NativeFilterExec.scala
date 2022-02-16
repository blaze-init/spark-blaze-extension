package org.apache.spark.sql.blaze.plan

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.MetricNode
import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.metric.SQLMetrics
import org.blaze.protobuf.FilterExecNode
import org.blaze.protobuf.PhysicalPlanNode

case class NativeFilterExec(
  condition: Expression,
  override val child: SparkPlan,
) extends UnaryExecNode with NativeSupports {

  override def output: Seq[Attribute] = child.output

  override def doExecute(): RDD[InternalRow] = doExecuteNative()

  override lazy val metrics = Map(
    "numOutputRows" -> SQLMetrics.createMetric(sparkContext, "number of output rows"),
    "numBlazeOutputIpcRows" -> SQLMetrics.createMetric(sparkContext, "number of blaze output ipc rows"),
    "numBlazeOutputIpcBytes" -> SQLMetrics.createSizeMetric(sparkContext, "number of blaze output ipc bytes"),
    "blazeExecTime" -> SQLMetrics.createNanoTimingMetric(sparkContext, "blaze exec time"),
  )

  override def doExecuteNative(): NativeRDD = {
    val inputRDD = NativeSupports.executeNative(child)
    val nativeMetrics = MetricNode(Map(
      "output_rows" -> metrics("numOutputRows"),
      "blaze_output_ipc_rows" -> metrics("numBlazeOutputIpcRows"),
      "blaze_output_ipc_bytes" -> metrics("numBlazeOutputIpcBytes"),
      "blaze_exec_time" -> metrics("blazeExecTime"),
    ), Seq(inputRDD.metrics))

    new NativeRDD(sparkContext, nativeMetrics, inputRDD.partitions, inputRDD.dependencies, {
      val nativeFilterExec = FilterExecNode.newBuilder()
        .setExpr(NativeConverters.convertExpr(condition))
        .setInput(inputRDD.nativePlan)
        .build()
      PhysicalPlanNode.newBuilder().setFilter(nativeFilterExec).build()
    }, inputRDD.precompute)
  }
}