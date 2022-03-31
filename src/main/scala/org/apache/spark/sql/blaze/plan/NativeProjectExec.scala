package org.apache.spark.sql.blaze.plan

import java.util.UUID

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.MetricNode
import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.catalyst.analysis.ResolvedStar
import org.apache.spark.sql.catalyst.expressions.Alias
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.expressions.NamedExpression
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Literal
import org.apache.spark.sql.execution.AliasAwareOutputPartitioning
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.metric.SQLMetric
import org.apache.spark.sql.types.DataTypes
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.ProjectionExecNode

case class NativeProjectExec(projectList: Seq[NamedExpression], override val child: SparkPlan)
    extends UnaryExecNode
    with NativeSupports
    with AliasAwareOutputPartitioning {

  override lazy val metrics: Map[String, SQLMetric] =
    NativeSupports.getDefaultNativeMetrics(sparkContext)

  override def outputExpressions: Seq[NamedExpression] = projectList
  override def output: Seq[Attribute] = outputExpressions.map(_.toAttribute)

  override def doExecute(): RDD[InternalRow] = doExecuteNative()

  override def doExecuteNative(): NativeRDD = {
    val inputRDD = NativeSupports.executeNative(child)
    val nativeMetrics = MetricNode(
      Map(
        "output_rows" -> metrics("numOutputRows"),
        "blaze_output_ipc_rows" -> metrics("blazeExecIPCWrittenRows"),
        "blaze_output_ipc_bytes" -> metrics("blazeExecIPCWrittenBytes"),
        "blaze_exec_time" -> metrics("blazeExecTime")),
      Seq(inputRDD.metrics))

    new NativeRDD(
      sparkContext,
      nativeMetrics,
      inputRDD.partitions,
      inputRDD.dependencies,
      (partition, taskContext) => {
        val nativeProjectExecBuilder = ProjectionExecNode.newBuilder()
        nativeProjectExecBuilder.setInput(inputRDD.nativePlan(partition, taskContext))

        def addNamedExpression(namedExpression: NamedExpression): Unit = {
          namedExpression match {
            case star: ResolvedStar =>
              for (expr <- star.expressions) {
                addNamedExpression(expr)
              }

            case alias: Alias =>
              nativeProjectExecBuilder.addExprName(alias.name)
              nativeProjectExecBuilder.addExpr(NativeConverters.convertExpr(alias.child))

            case otherNamedExpression =>
              nativeProjectExecBuilder.addExprName(otherNamedExpression.name)
              nativeProjectExecBuilder.addExpr(NativeConverters.convertExpr(otherNamedExpression))
          }
        }

        if (projectList.nonEmpty) {
          for (projectExpr <- projectList) {
            addNamedExpression(projectExpr)
          }
        } else {
          // add a dummy column when projection schema is empty because
          // native projection requires at least one column
          nativeProjectExecBuilder.addExprName("__dummy_" + UUID.randomUUID().toString)
          nativeProjectExecBuilder.addExpr(
            NativeConverters.convertExpr(Literal.apply(null, DataTypes.BooleanType)))
        }
        PhysicalPlanNode.newBuilder().setProjection(nativeProjectExecBuilder.build()).build()
      })
  }
}
