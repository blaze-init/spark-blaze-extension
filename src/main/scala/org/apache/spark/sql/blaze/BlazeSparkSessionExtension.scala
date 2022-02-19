package org.apache.spark.sql.blaze

import org.apache.spark.sql.SparkSessionExtensions
import org.apache.spark.SparkEnv
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.blaze.execution.ArrowShuffleExchangeExec301
import org.apache.spark.sql.blaze.execution.ArrowShuffleManager301
import org.apache.spark.sql.blaze.plan.NativeFilterExec
import org.apache.spark.sql.blaze.plan.NativeParquetScanExec
import org.apache.spark.sql.blaze.plan.NativeProjectExec
import org.apache.spark.sql.blaze.plan.NativeSortExec
import org.apache.spark.sql.catalyst.expressions.Attribute
import org.apache.spark.sql.catalyst.rules.Rule
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.execution.exchange.ShuffleExchangeExec
import org.apache.spark.sql.execution.FileSourceScanExec
import org.apache.spark.sql.execution.SortExec
import org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat
import org.apache.spark.sql.execution.CollectLimitExec
import org.apache.spark.sql.execution.FilterExec
import org.apache.spark.sql.execution.ProjectExec
import org.apache.spark.sql.execution.UnaryExecNode
import org.apache.spark.sql.execution.joins.SortMergeJoinExec
import org.apache.spark.sql.execution.metric.SQLMetric
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
    var sparkPlanTransformed = sparkPlan.transformUp {
      case exec: ShuffleExchangeExec => convertShuffleExchangeExec(exec)
      case exec: FileSourceScanExec => convertFileSourceScanExec(exec)
      case exec: ProjectExec => convertProjectExec(exec)
      case exec: FilterExec => convertFilterExec(exec)
      case exec: SortExec => convertSortExec(exec)
      case otherPlan =>
        logInfo(s"Ignore unsupported plan: ${otherPlan.simpleStringWithNodeId}")
        addUnsafeRowConverionIfNecessary(otherPlan)
    }

    // wrap with ConvertUnsafeRowExec if top exec is native
    if (sparkPlanTransformed.isInstanceOf[NativeSupports]) {
      sparkPlanTransformed = convertToUnsafeRow(sparkPlanTransformed)
    }

    logInfo(s"Transformed spark plan:\n${sparkPlanTransformed.treeString(verbose = true, addSuffix = true, printOperatorId = true)}")
    sparkPlanTransformed
  }

  private def convertShuffleExchangeExec(exec: ShuffleExchangeExec): SparkPlan = {
    val ShuffleExchangeExec(outputPartitioning, child, noUserSpecifiedNumPartition) = exec
    logInfo(s"Converting ShuffleExchangeExec: ${exec.simpleStringWithNodeId}")

    val childWithWholeStageCodegen = child match {
      case child: NativeSupports => WholeStageCodegenForBlazeNativeExec(child)
      case child => child
    }
    ArrowShuffleExchangeExec301(outputPartitioning, childWithWholeStageCodegen, noUserSpecifiedNumPartition)
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
    if (relation.fileFormat.isInstanceOf[ParquetFileFormat]) {
      return NativeParquetScanExec(exec) // note: supports exec.dataFilters for better performance?
    }
    exec
  }

  private def convertProjectExec(exec: ProjectExec): SparkPlan = {
    logInfo(s"Converting ProjectExec: ${exec.simpleStringWithNodeId()}")
    for (projectExpr <- exec.projectList) {
      logInfo(s"  projectExpr: ${projectExpr}")
    }

    exec match {
      case ProjectExec(projectList, child: NativeSupports) => NativeProjectExec(projectList, child)
      case projectExec => projectExec
    }
  }
  private def convertFilterExec(exec: FilterExec): SparkPlan = {
    logInfo(s"Converting FilterExec: ${exec.simpleStringWithNodeId()}")
    logInfo(s"  condition: ${exec.condition}")
    exec match {
      case FilterExec(condition, child: NativeSupports) => NativeFilterExec(condition, child)
      case filterExec => filterExec
    }
  }

  def convertSortExec(exec: SortExec): SparkPlan = {
    logInfo(s"Converting SortExec: ${exec.simpleStringWithNodeId()}")
    exec.sortOrder.foreach(s => logInfo(s"  sortOrder: ${s}"))
    exec match {
      case SortExec(sortOrder, global, child, _) => NativeSortExec(sortOrder, global, child)
      case sortExec => sortExec
    }
  }

  private def convertToUnsafeRow(exec: SparkPlan): SparkPlan = {
    exec match {
      case exec: NativeSupports => ConvertToUnsafeRowExec(WholeStageCodegenForBlazeNativeExec(exec))
      case exec => exec
    }
  }

  private def addUnsafeRowConverionIfNecessary(exec: SparkPlan): SparkPlan = {
    exec match {
      case exec: SortExec =>
        exec.copy(child = convertToUnsafeRow(exec.child))
      case exec: CollectLimitExec =>
        exec.copy(child = convertToUnsafeRow(exec.child))
      case exec: SortMergeJoinExec =>
        exec.copy(left = convertToUnsafeRow(exec.left), right = convertToUnsafeRow(exec.right))
      case otherPlan =>
        otherPlan
    }
  }
}

case class WholeStageCodegenForBlazeNativeExec(
  override val child: SparkPlan with NativeSupports
) extends UnaryExecNode with NativeSupports {

  override def nodeName: String = "WholeStageCodegen for Blaze Native Execution"
  override def logicalLink: Option[LogicalPlan] = child.logicalLink
  override def output: Seq[Attribute] = child.output
  override def metrics: Map[String, SQLMetric] = child.metrics

  override def doExecuteNative(): NativeRDD = NativeSupports.executeNative(child)
  override protected def doExecute(): RDD[InternalRow] = child.execute()
}