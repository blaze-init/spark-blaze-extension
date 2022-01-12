package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.SparkPlan

trait NativeSupports extends SparkPlan {
   override protected def doExecute(): RDD[InternalRow] = doExecuteNative()
   def doExecuteNative(): NativeRDD
}