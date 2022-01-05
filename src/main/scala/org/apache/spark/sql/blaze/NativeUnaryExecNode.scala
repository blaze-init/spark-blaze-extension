package org.apache.spark.sql.blaze

import org.apache.spark.sql.execution.UnaryExecNode
import org.ballistacompute.protobuf.PhysicalPlanNode

trait NativeUnaryExecNode extends UnaryExecNode {
   def toNativePlan: PhysicalPlanNode
}