package org.apache.spark.sql.blaze

import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.ballistacompute.protobuf.PhysicalPlanNode

trait NativeUnaryExecNode extends UnaryExecNode {
   def inputFileScanRDD: FileScanRDD
   def toNativePlan: PhysicalPlanNode

   def executeNative: NativeRDD = NativeRDD(inputFileScanRDD, toNativePlan)
}