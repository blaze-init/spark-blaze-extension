package org.apache.spark.sql.blaze.plan

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Ascending
import org.apache.spark.sql.catalyst.expressions.NullsFirst
import org.apache.spark.sql.catalyst.expressions.SortOrder
import org.apache.spark.sql.catalyst.plans.physical.Distribution
import org.apache.spark.sql.catalyst.plans.physical.OrderedDistribution
import org.apache.spark.sql.catalyst.plans.physical.Partitioning
import org.apache.spark.sql.catalyst.plans.physical.UnspecifiedDistribution
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.ballistacompute.protobuf.PhysicalExprNode
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.PhysicalSortExprNode
import org.ballistacompute.protobuf.SortExecNode

case class NativeSortExec(
  sortOrder: Seq[SortOrder],
  global: Boolean,
  override val child: SparkPlan,
) extends UnaryExecNode with NativeSupports {

  override def output: Seq[Attribute] = child.output

  override def outputOrdering: Seq[SortOrder] = sortOrder

  override def outputPartitioning: Partitioning = child.outputPartitioning

  override def requiredChildDistribution: Seq[Distribution] = if (global) {
    OrderedDistribution(sortOrder) :: Nil
  } else {
    UnspecifiedDistribution :: Nil
  }

  override def doExecute(): RDD[InternalRow] = doExecuteNative()

  override def doExecuteNative(): NativeRDD = {
    val inputRDD = NativeSupports.executeNative(child)
    new NativeRDD(sparkContext, inputRDD.partitions, inputRDD.dependencies, {
      val nativeSortExecBuilder = SortExecNode.newBuilder().setInput(inputRDD.nativePlan)

      sortOrder.foreach { s =>
        nativeSortExecBuilder.addExpr(PhysicalExprNode.newBuilder()
          .setSort(PhysicalSortExprNode.newBuilder()
            .setExpr(NativeConverters.convertExpr(s.child))
            .setAsc(s.direction == Ascending)
            .setNullsFirst(s.nullOrdering == NullsFirst)
            .build()
          ).build()
        )
      }
      PhysicalPlanNode.newBuilder()
        .setSort(nativeSortExecBuilder.build())
        .build()
    }, inputRDD.precompute)
  }
}