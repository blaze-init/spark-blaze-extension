package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.UnsafeProjection
import org.apache.spark.sql.catalyst.expressions.UnsafeRow
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.catalyst.plans.physical.Partitioning
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.metric.SQLMetric
import org.apache.spark.sql.execution.metric.SQLMetrics
import org.apache.spark.sql.execution.metric.SQLMetrics

case class ConvertToUnsafeRowExec(override val child: SparkPlan) extends UnaryExecNode {
  override def nodeName: String = "ConvertToUnsafeRow"
  override def logicalLink: Option[LogicalPlan] = child.logicalLink
  override def output: Seq[Attribute] = child.output
  override def outputPartitioning: Partitioning = child.outputPartitioning

  override lazy val metrics: Map[String, SQLMetric] = Map(
    "numConvertedRows" -> SQLMetrics.createMetric(sparkContext, "number of converted rows"),
    "time" -> SQLMetrics.createNanoTimingMetric(sparkContext, "time"),
  )

  override protected def doExecute(): RDD[InternalRow] = {
    val numConvertedRows: SQLMetric = longMetric("numConvertedRows")
    val time: SQLMetric = this.longMetric("time")
    val localOutput = this.output

    NativeSupports.executeNative(child).mapPartitionsInternal { iterator =>
      val startTime = System.nanoTime()
      val toUnsafe = UnsafeProjection.create(localOutput, localOutput)
      val convertedIterator = iterator.map {
        case row: UnsafeRow => row
        case row => {
          numConvertedRows += 1
          toUnsafe(row)
        }
      }
      time.add(System.nanoTime() - startTime)
      convertedIterator
    }
  }
}