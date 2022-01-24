package org.apache.spark.sql.blaze

import scala.annotation.tailrec

import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.SparkException
import org.apache.spark.sql.execution.adaptive.CustomShuffleReaderExec
import org.apache.spark.sql.execution.adaptive.QueryStageExec

trait NativeSupports {
   def doExecuteNative(): NativeRDD
}

object NativeSupports {
   @tailrec def executeNative(plan: SparkPlan): NativeRDD = plan match {
      case plan: NativeSupports => plan.doExecuteNative()
      case plan: CustomShuffleReaderExec => executeNative(plan.child)
      case plan: QueryStageExec => executeNative(plan.plan)
      case _ => throw new SparkException(s"Underlaying plan is not NativeSupports: ${plan}")
   }
}
