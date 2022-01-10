package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.datasources.FileScanRDD
import org.apache.spark.sql.execution.SparkPlan
import org.ballistacompute.protobuf.PhysicalPlanNode

abstract class BaseNativeExec extends SparkPlan {
   def inputFileScanRDD: FileScanRDD
   def toNativePlan: PhysicalPlanNode

   def executeNative: NativeRDD = NativeRDD(inputFileScanRDD, toNativePlan)

   override protected def doExecute(): RDD[InternalRow] = executeNative
}