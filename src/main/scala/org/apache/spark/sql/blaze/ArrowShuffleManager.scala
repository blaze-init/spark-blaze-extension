package org.apache.spark.sql.blaze

import org.apache.spark.internal.Logging
import org.apache.spark.shuffle._
import org.apache.spark.{ShuffleDependency, SparkConf, TaskContext}

class ArrowShuffleManager(
    conf: SparkConf,
    val isDriver: Boolean) extends ShuffleManager with Logging {
  override def registerShuffle[K, V, C](
    shuffleId: Int, dependency: ShuffleDependency[K, V, C]): ShuffleHandle = ???

  override def getWriter[K, V](
    handle: ShuffleHandle,
    mapId: Long,
    context: TaskContext,
    metrics: ShuffleWriteMetricsReporter): ShuffleWriter[K, V] = ???

  override def getReader[K, C](
    handle: ShuffleHandle,
    startPartition: Int,
    endPartition: Int,
    context: TaskContext,
    metrics: ShuffleReadMetricsReporter): ShuffleReader[K, C] = ???

  override def getReaderForRange[K, C](
    handle: ShuffleHandle,
    startMapIndex: Int,
    endMapIndex: Int,
    startPartition: Int,
    endPartition: Int,
    context: TaskContext,
    metrics: ShuffleReadMetricsReporter): ShuffleReader[K, C] = ???

  override def unregisterShuffle(shuffleId: Int): Boolean = ???

  override def shuffleBlockResolver: ShuffleBlockResolver = ???

  override def stop(): Unit = ???
}
