package org.apache.spark.sql.blaze

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.adaptive.ShuffleQueryStageExec
import org.apache.spark.SparkException

trait NativeSupports extends SparkPlan {
   override protected def doExecute(): RDD[InternalRow] = doExecuteNative()
   def doExecuteNative(): NativeRDD
}

object NativeSupports {
   def executeNative(plan: SparkPlan): NativeRDD = plan match {
      case plan: NativeSupports => plan.doExecuteNative()
      case ShuffleQueryStageExec(_, plan: NativeSupports) => plan.doExecuteNative()
      case _ =>
         throw new SparkException(s"Underlaying plan is not NativeSupports: ${plan}")
   }
}