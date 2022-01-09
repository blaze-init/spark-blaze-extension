package org.apache.spark.sql.blaze

import org.apache.spark.sql.SparkSessionExtensions
import org.apache.spark.SparkEnv
import org.apache.spark.internal.Logging
import org.apache.spark.sql.blaze.execution.ArrowShuffleExchangeExec301
import org.apache.spark.sql.blaze.execution.ArrowShuffleManager301
import org.apache.spark.sql.catalyst.rules.Rule
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.exchange.ShuffleExchangeExec
import org.apache.spark.sql.execution.FileSourceScanExec
import org.apache.spark.sql.execution.SortExec
import org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat
import org.apache.spark.sql.execution.CollectLimitExec
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
    val sparkPlanTransformed = sparkPlan.transformUp {
      case exec: ShuffleExchangeExec => convertShuffleExchangeExec(exec)
      case exec: FileSourceScanExec => convertFileSourceScanExec(exec)
      case exec: SortExec => convertSortExec(exec)
      case exec: CollectLimitExec => convertCollectLimitExec(exec)
      case otherPlan =>
        logInfo(s"Ignore unsupported plan: ${otherPlan.simpleStringWithNodeId}")
        otherPlan
    }

    logInfo(s"Transformed spark plan:\n${sparkPlanTransformed.treeString(verbose = true, addSuffix = true, printOperatorId = true)}")
    sparkPlanTransformed
  }

  private def convertShuffleExchangeExec(exec: ShuffleExchangeExec): SparkPlan = {
    val ShuffleExchangeExec(outputPartitioning, child, noUserSpecifiedNumPartition) = exec
    logInfo(s"Converting ShuffleExchangeExec: ${exec.simpleStringWithNodeId}")

    ArrowShuffleExchangeExec301(
      outputPartitioning,
      child,
      noUserSpecifiedNumPartition,
    )
  }

  private def convertFileSourceScanExec(exec: FileSourceScanExec): SparkPlan = {
    val FileSourceScanExec(relation, output, requiredSchema, partitionFilters, optionalBucketSet, dataFilters, tableIdentifier) = exec
    logInfo(s"Converting FileSourceScanExec: ${exec.simpleStringWithNodeId}")
    logInfo(s"  relation: ${relation}")
    logInfo(s"  relation.location: ${relation.location}")
    logInfo(s"  output: ${output}")
    logInfo(s"  requiredSchema: ${requiredSchema}")
    logInfo(s"  partitionFilters: ${partitionFilters}")
    logInfo(s"  optionalBucketSet: ${optionalBucketSet}")
    logInfo(s"  dataFilters: ${dataFilters}")
    logInfo(s"  tableIdentifier: ${tableIdentifier}")
    if (relation.fileFormat.isInstanceOf[ParquetFileFormat] && partitionFilters.isEmpty && optionalBucketSet.isEmpty && dataFilters.isEmpty) {
      return NativeParquetScanExec(exec)
    }
    exec
  }

  private def convertSortExec(exec: SortExec): SparkPlan = {
    logInfo(s"Converting SortExec: ${exec.simpleStringWithNodeId}")
    val SortExec(sortOrder, global, child, testSpillFrequency) = exec
    SortExec(sortOrder, global, convertToUnsafeRow(child), testSpillFrequency)
  }

  private def convertCollectLimitExec(exec: CollectLimitExec): SparkPlan = {
    logInfo(s"Converting CollectLimitExec: ${exec.simpleStringWithNodeId}")
    val CollectLimitExec(limit, child) = exec
    CollectLimitExec(limit, convertToUnsafeRow(child))
  }

  private def convertToUnsafeRow(exec: SparkPlan): SparkPlan = {
    exec match {
      case convertedExec: ConvertToUnsafeRowExec => convertedExec
      case exec => ConvertToUnsafeRowExec(exec)
    }
  }
}