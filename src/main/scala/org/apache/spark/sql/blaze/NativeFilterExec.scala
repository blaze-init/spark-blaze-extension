package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.ballistacompute.protobuf.FilterExecNode
import org.ballistacompute.protobuf.PhysicalPlanNode

case class NativeFilterExec(
  condition: Expression,
  override val child: SparkPlan with BaseNativeExec,
) extends UnaryExecNode with BaseNativeExec {

  override def output: Seq[Attribute] = child.output

  override def doExecute(): RDD[InternalRow] = executeNative

  override def inputFileScanRDD: FileScanRDD = child.inputFileScanRDD

  override def toNativePlan: PhysicalPlanNode = {
    val nativeFilterExec = FilterExecNode.newBuilder()
      .setExpr(NativeConverters.convertExpr(condition))
      .setInput(child.toNativePlan)
      .build()
    PhysicalPlanNode.newBuilder().setFilter(nativeFilterExec).build()
  }
}
