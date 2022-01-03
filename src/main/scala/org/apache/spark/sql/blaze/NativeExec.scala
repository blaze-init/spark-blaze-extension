package org.apache.spark.sql.blaze

import org.ballistacompute.protobuf.PhysicalPlanNode

trait NativeExec {
  def convertToNativePlan(): PhysicalPlanNode
}
