package org.apache.spark.sql.blaze

import org.apache.spark.sql.catalyst.analysis.ResolvedStar
import org.apache.spark.sql.catalyst.analysis.Star
import org.apache.spark.sql.catalyst.expressions.Alias
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.expressions.NamedExpression
import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.ballistacompute.protobuf.FilterExecNode
import org.ballistacompute.protobuf.PhysicalPlanNode
import org.ballistacompute.protobuf.ProjectionExecNode

case class NativeProjectExec(
  projectList: Seq[NamedExpression],
  override val child: BaseNativeExec,
) extends BaseNativeExec with UnaryExecNode {

  override def output: Seq[Attribute] = child.output

  override def inputFileScanRDD: FileScanRDD = child.inputFileScanRDD

  override def toNativePlan: PhysicalPlanNode = {
    val nativeProjectExecBuilder = ProjectionExecNode.newBuilder()
    nativeProjectExecBuilder.setInput(child.toNativePlan)

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
  }
}
