package org.apache.spark.sql.blaze.plan

import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.ballistacompute.protobuf.FilterExecNode
import org.ballistacompute.protobuf.PhysicalPlanNode

case class NativeFilterExec(
  condition: Expression,
  override val child: SparkPlan with NativeSupports,
) extends UnaryExecNode with NativeSupports {

  override def output: Seq[Attribute] = child.output

  override def doExecuteNative(): NativeRDD = {
    val inputRDD = child.doExecuteNative()
    NativeRDD(sparkContext, inputRDD.partitions, inputRDD.dependencies, {
      val nativeFilterExec = FilterExecNode.newBuilder()
        .setExpr(NativeConverters.convertExpr(condition))
        .setInput(inputRDD.nativePlan)
        .build()
      PhysicalPlanNode.newBuilder().setFilter(nativeFilterExec).build()
    })
  }
}