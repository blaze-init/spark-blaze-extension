package org.apache.spark.sql.blaze

import java.nio.ByteBuffer
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.locks.ReentrantLock

import scala.annotation.tailrec

import org.apache.commons.collections.buffer.BlockingBuffer
import org.apache.commons.collections.buffer.BoundedFifoBuffer
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.SparkException
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.adaptive.CustomShuffleReaderExec
import org.apache.spark.sql.execution.adaptive.QueryStageExec
import org.apache.spark.TaskContext
import org.apache.spark.sql.execution.metric.SQLMetric
import org.apache.spark.sql.execution.metric.SQLMetrics
import org.apache.spark.SparkContext
import org.apache.spark.internal.Logging
import org.apache.spark.sql.blaze.execution.ArrowReaderIterator
import org.apache.spark.InterruptibleIterator
import org.apache.spark.SparkEnv
import org.blaze.protobuf.PartitionId
import org.blaze.protobuf.PhysicalPlanNode
import org.blaze.protobuf.TaskDefinition
import org.blaze.NioSeekableByteChannel

trait NativeSupports {
  def doExecuteNative(): NativeRDD
}

object NativeSupports extends Logging {
  @tailrec def isNative(plan: SparkPlan): Boolean = plan match {
    case _: NativeSupports => true
    case plan: CustomShuffleReaderExec => isNative(plan.child)
    case plan: QueryStageExec => isNative(plan.plan)
    case _ => false
  }

  @tailrec def executeNative(plan: SparkPlan): NativeRDD = plan match {
    case plan: NativeSupports => plan.doExecuteNative()
    case plan: CustomShuffleReaderExec => executeNative(plan.child)
    case plan: QueryStageExec => executeNative(plan.plan)
    case _ => throw new SparkException(s"Underlying plan is not NativeSupports: ${plan}")
  }

  def executeNativePlan(
      nativePlan: PhysicalPlanNode,
      metrics: MetricNode,
      context: TaskContext): Iterator[InternalRow] = {

    val partitionId = PartitionId
      .newBuilder()
      .setPartitionId(context.partitionId())
      .setStageId(context.stageId())
      .setJobId(context.partitionId().toString)
      .build()

    val taskDefinition = TaskDefinition
      .newBuilder()
      .setTaskId(partitionId)
      .setPlan(nativePlan)
      .build()

    // note: consider passing a ByteBufferOutputStream to blaze-rs to avoid copying
    if (SparkEnv.get.conf.getBoolean("spark.blaze.dumpNativePlanBeforeExecuting", false)) {
      logInfo(s"Start executing native plan: ${taskDefinition.toString}")
    } else {
      logInfo(s"Start executing native plan")
    }

    val nativeMemory = SparkEnv.get.conf
      .getLong("spark.executor.memoryOverhead", Long.MaxValue) * 1024 * 1024
    val memoryFraction = SparkEnv.get.conf.getDouble("spark.blaze.memoryFraction", 0.75)
    val batchSize = SparkEnv.get.conf.getLong("spark.blaze.batchSize", 10240)
    val tokioPoolSize = SparkEnv.get.conf.getLong("spark.blaze.tokioPoolSize", 10)
    val tmpDirs = SparkEnv.get.blockManager.diskBlockManager.localDirsString.mkString(",")

    val batchQueue = new LinkedBlockingQueue[Option[ArrowReaderIterator]](1)
    val thread = new Thread(() => {
      try {
        JniBridge.callNative(
          taskDefinition.toByteArray,
          tokioPoolSize,
          batchSize,
          nativeMemory,
          memoryFraction,
          tmpDirs,
          metrics,
          byteBuffer => {
            val channel = new NioSeekableByteChannel(byteBuffer, 0, byteBuffer.limit())
            val arrowReaderIterator = new ArrowReaderIterator(channel, context)
            batchQueue.put(Some(arrowReaderIterator))
            batchQueue.put(Some(null)) // block until current batch is finished
          })
      } finally {
        batchQueue.put(None) // no more batches
      }
    })
    thread.start()
    context.addTaskCompletionListener[Unit](_ => {
      while (thread.isAlive) {
        batchQueue.clear()
        Thread.sleep(1)
      }
      thread.join()
    })

    new Iterator[InternalRow]() {
      private var currentIterator: Iterator[InternalRow] = Nil.toIterator
      private var finished = false

      override def hasNext: Boolean = {
        while (!finished && !currentIterator.hasNext) {
          if (!nextBatch()) {
            return false
          }
        }
        !finished
      }

      override def next(): InternalRow =
        currentIterator.next()

      private def nextBatch(): Boolean = {
        while (true) {
          batchQueue.take() match {
            case Some(null) =>
            // take away current null node and do nothing
            // this will resume native calling thread providing next batch
            case Some(batch) =>
              currentIterator = batch
              return true
            case None =>
              currentIterator = Nil.toIterator
              finished = true
              return false
          }
        }
        throw new RuntimeException("unreachable")
      }
    }
  }

  def getDefaultNativeMetrics(sparkContext: SparkContext): Map[String, SQLMetric] =
    Map(
      "numOutputRows" -> SQLMetrics.createMetric(sparkContext, "number of output rows"),
      "blazeExecIPCWrittenRows" -> SQLMetrics
        .createMetric(sparkContext, "blaze exec IPC written rows"),
      "blazeExecIPCWrittenBytes" -> SQLMetrics
        .createSizeMetric(sparkContext, "blaze exec IPC written bytes"),
      "blazeExecTime" -> SQLMetrics.createNanoTimingMetric(sparkContext, "blaze exec time"),
      "blazeShuffleWriteExecTime" -> SQLMetrics
        .createNanoTimingMetric(sparkContext, "blaze shuffle write exec time"))
}

case class MetricNode(metrics: Map[String, SQLMetric], children: Seq[MetricNode]) {
  def getChild(i: Int): MetricNode =
    children(i)

  def add(metricName: String, v: Long): Unit =
    metrics.get(metricName).foreach(_.add(v))
}
