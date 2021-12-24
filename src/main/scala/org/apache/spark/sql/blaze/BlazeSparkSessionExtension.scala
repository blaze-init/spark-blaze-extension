package org.apache.spark.sql.blaze

import org.apache.spark.sql.SparkSessionExtensions
import org.apache.spark.SparkEnv
import org.apache.spark.internal.Logging
import org.apache.spark.SparkContext
import org.apache.spark.sql.blaze.execution.ArrowShuffleExchangeExec301
import org.apache.spark.sql.blaze.execution.ArrowShuffleManager301
import org.apache.spark.sql.catalyst.rules.Rule
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.exchange.ShuffleExchangeExec
import org.apache.spark.sql.execution.ColumnarToRowExec
import org.apache.spark.sql.execution.SortExec
import org.apache.spark.sql.internal.SQLConf

class BlazeSparkSessionExtension extends (SparkSessionExtensions => Unit) with Logging {
  override def apply(extensions: SparkSessionExtensions): Unit = {
    SparkEnv.get.conf.set(SQLConf.ADAPTIVE_EXECUTION_ENABLED.key, "true")
    SparkEnv.get.conf.set(SQLConf.ADAPTIVE_EXECUTION_FORCE_APPLY.key, "true")
    SparkEnv.get.conf.set(org.apache.spark.internal.config.SHUFFLE_MANAGER.key, ArrowShuffleManager301.getClass.getCanonicalName)
    SparkEnv.get.conf.set(org.apache.spark.internal.config.SHUFFLE_SERVICE_ENABLED.key, "false")
    logInfo("org.apache.spark.BlazeSparkSessionExtension enabled")

    extensions.injectQueryStagePrepRule(_ => BlazeQueryStagePrepOverrides())
  }
}

case class BlazeQueryStagePrepOverrides() extends Rule[SparkPlan] with Logging {
  override def apply(sparkPlan: SparkPlan): SparkPlan = {
    val sc = SparkContext.getOrCreate()

    val sparkPlanTransformed = sparkPlan.transformUp {
      case ShuffleExchangeExec(outputPartitioning, child, noUserSpecifiedNumPartition) =>
          ArrowShuffleExchangeExec301(outputPartitioning, child, noUserSpecifiedNumPartition)

      case SortExec(sortOrder, global, child, testSpillFrequency) =>
        // SortExec only accepts RDD[UnsafeRow], so add an extra convert exec before sort
        // TODO: only add convert exec for sort after arrow-based shuffle
        child match {
          case convertedChild: ConvertToUnsafeRowExec =>
            SortExec(sortOrder, global, convertedChild, testSpillFrequency)
          case unconvertedChild =>
            SortExec(sortOrder, global, ConvertToUnsafeRowExec(unconvertedChild), testSpillFrequency)
        }

      case otherPlan =>
        otherPlan
    }

    logInfo("Transformed spark plan:")
    logInfo(s"${sparkPlanTransformed.treeString(verbose = true, addSuffix = true, printOperatorId = true)}")
    sparkPlanTransformed
  }
}