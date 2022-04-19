package org.apache.spark.sql.blaze.plan

import scala.collection.JavaConverters._

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.MetricNode
import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.SortOrder
import org.apache.spark.sql.catalyst.plans.physical.Partitioning
import org.apache.spark.sql.catalyst.plans.RightOuter
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.metric.SQLMetric
import org.apache.spark.OneToOneDependency
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.plans.JoinType
import org.apache.spark.sql.execution.BinaryExecNode
import org.blaze.protobuf.JoinOn
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.SortMergeJoinExecNode
import org.blaze.protobuf.SortOptions

case class NativeSortMergeJoinExec(
    override val left: SparkPlan,
    override val right: SparkPlan,
    leftKeys: Seq[Expression],
    rightKeys: Seq[Expression],
    override val output: Seq[Attribute],
    override val outputPartitioning: Partitioning,
    override val outputOrdering: Seq[SortOrder],
    joinType: JoinType)
    extends BinaryExecNode
    with NativeSupports {

  override lazy val metrics: Map[String, SQLMetric] =
    NativeSupports.getDefaultNativeMetrics(sparkContext)

  override def doExecute(): RDD[InternalRow] = doExecuteNative()

  override def doExecuteNative(): NativeRDD = {
    val leftRDD = NativeSupports.executeNative(left)
    val rightRDD = NativeSupports.executeNative(right)

    val nativeMetrics = MetricNode(
      Map(
        "output_rows" -> metrics("numOutputRows"),
        "blaze_output_ipc_rows" -> metrics("blazeExecIPCWrittenRows"),
        "blaze_output_ipc_bytes" -> metrics("blazeExecIPCWrittenBytes"),
        "blaze_exec_time" -> metrics("blazeExecTime")),
      Seq(leftRDD.metrics, rightRDD.metrics))

    val partitions = if (joinType != RightOuter) {
      leftRDD.partitions
    } else {
      rightRDD.partitions
    }

    val dependencies = Seq(
      new OneToOneDependency[InternalRow](leftRDD.asInstanceOf[RDD[InternalRow]]),
      new OneToOneDependency[InternalRow](rightRDD.asInstanceOf[RDD[InternalRow]]))
    new NativeRDD(
      sparkContext,
      nativeMetrics,
      partitions,
      dependencies,
      (partition, taskContext) => {
        val leftChild = leftRDD.nativePlan(partition, taskContext)
        val rightChild = rightRDD.nativePlan(partition, taskContext)

        val joinOn = leftKeys.zip(rightKeys).map {
          case (leftKey, rightKey) =>
            val leftColumn = NativeConverters.convertExpr(leftKey).getColumn
            val rightColumn = NativeConverters.convertExpr(rightKey).getColumn
            JoinOn
              .newBuilder()
              .setLeft(leftColumn)
              .setRight(rightColumn)
              .build()
        }
        val sortOptions = joinOn.map(
          _ =>
            SortOptions
              .newBuilder()
              .setAsc(true)
              .setNullsFirst(true)
              .build())

        val sortMergeJoinExec = SortMergeJoinExecNode
          .newBuilder()
          .setLeft(leftChild)
          .setRight(rightChild)
          .setJoinType(NativeConverters.convertJoinType(joinType))
          .addAllOn(joinOn.asJava)
          .addAllSortOptions(sortOptions.asJava)
          .setNullEqualsNull(false)
        PhysicalPlanNode.newBuilder().setSortMergeJoin(sortMergeJoinExec).build()
      })
  }
}
