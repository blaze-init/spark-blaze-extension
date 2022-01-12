package org.apache.spark.sql.blaze.plan

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.NativeSupports
import org.apache.spark.sql.blaze.NativeConverters
import org.apache.spark.sql.blaze.NativeRDD
import org.apache.spark.sql.catalyst.expressions.NamedExpression
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.analysis.ResolvedStar
import org.apache.spark.sql.catalyst.expressions.Alias
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.apache.spark.sql.execution.AliasAwareOutputPartitioning
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.UnaryExecNode
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.ProjectionExecNode

case class NativeProjectExec(
  projectList: Seq[NamedExpression],
  override val child: SparkPlan with NativeSupports,
) extends UnaryExecNode with NativeSupports with AliasAwareOutputPartitioning {

  override def outputExpressions: Seq[NamedExpression] = projectList

  override def output: Seq[Attribute] = outputExpressions.map(_.toAttribute)

  override def doExecuteNative(): NativeRDD = {
    val inputRDD = child.doExecuteNative()
    NativeRDD(sparkContext, inputRDD.partitions, inputRDD.dependencies, {
      val nativeProjectExecBuilder = ProjectionExecNode.newBuilder()
      nativeProjectExecBuilder.setInput(inputRDD.nativePlan)

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
            NativeConverters.convertExpr(otherNamedExpression)
        }
      }
      for (projectExpr <- projectList) {
        addNamedExpression(projectExpr)
      }
      PhysicalPlanNode.newBuilder().setProjection(nativeProjectExecBuilder.build()).build()
    })
  }
}