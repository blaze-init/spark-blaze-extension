/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.storage

import java.io.IOException

import org.apache.spark.internal.Logging
import org.apache.spark.network.buffer.{FileSegmentManagedBuffer, ManagedBuffer}
import org.apache.spark.network.shuffle._
import org.apache.spark.network.util.TransportConf
import org.apache.spark.shuffle.{FetchFailedException, ShuffleReadMetricsReporter}
import org.apache.spark.util.{CompletionIterator, Utils}
import org.apache.spark.{SparkException, TaskContext}
import java.nio.channels.ClosedByInterruptException
import java.util.concurrent.{LinkedBlockingQueue, TimeUnit}
import javax.annotation.concurrent.GuardedBy

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, HashMap, HashSet, LinkedHashMap, Queue}
import scala.util.{Failure, Success}

import org.apache.spark.util.TaskCompletionListener

/**
 * An iterator that fetches multiple blocks. For local blocks, it fetches from the local block
 * manager. For remote blocks, it fetches them using the provided BlockTransferService.
 *
 * This creates an iterator of (BlockID, InputStream) tuples so the caller can handle blocks
 * in a pipelined fashion as they are received.
 *
 * The implementation throttles the remote fetches so they don't exceed maxBytesInFlight to avoid
 * using too much memory.
 *
 * @param context                     [[TaskContext]], used for metrics update
 * @param shuffleClient               [[BlockStoreClient]] for fetching remote blocks
 * @param blockManager                [[BlockManager]] for reading local blocks
 * @param blocksByAddress             list of blocks to fetch grouped by the [[BlockManagerId]].
 *                                    For each block we also require two info: 1. the size (in bytes as a long
 *                                    field) in order to throttle the memory usage; 2. the mapIndex for this
 *                                    block, which indicate the index in the map stage.
 *                                    Note that zero-sized blocks are already excluded, which happened in
 *                                    [[org.apache.spark.MapOutputTracker.convertMapStatuses]].
 * @param streamWrapper               A function to wrap the returned input stream.
 * @param maxBytesInFlight            max size (in bytes) of remote blocks to fetch at any given point.
 * @param maxReqsInFlight             max number of remote requests to fetch blocks at any given point.
 * @param maxBlocksInFlightPerAddress max number of shuffle blocks being fetched at any given point
 *                                    for a given remote host:port.
 * @param maxReqSizeShuffleToMem      max size (in bytes) of a request that can be shuffled to memory.
 * @param detectCorrupt               whether to detect any corruption in fetched blocks.
 * @param shuffleMetrics              used to report shuffle metrics.
 * @param doBatchFetch                fetch continuous shuffle blocks from same executor in batch if the server
 *                                    side supports.
 */
private[spark]
final class ShuffleBlockFetcherIterator301(
  context: TaskContext,
  shuffleClient: BlockStoreClient,
  blockManager: BlockManager,
  blocksByAddress: Iterator[(BlockManagerId, Seq[(BlockId, Long, Int)])],
  maxBytesInFlight: Long,
  maxReqsInFlight: Int,
  maxBlocksInFlightPerAddress: Int,
  maxReqSizeShuffleToMem: Long,
  detectCorrupt: Boolean,
  detectCorruptUseExtraMemory: Boolean,
  shuffleMetrics: ShuffleReadMetricsReporter,
  doBatchFetch: Boolean)
  extends Iterator[(BlockId, ManagedBuffer)] with DownloadFileManager with Logging {

  import ShuffleBlockFetcherIterator._

  // Make remote requests at most maxBytesInFlight / 5 in length; the reason to keep them
  // smaller than maxBytesInFlight is to allow multiple, parallel fetches from up to 5
  // nodes, rather than blocking on reading output from one node.
  private val targetRemoteRequestSize = math.max(maxBytesInFlight / 5, 1L)
  private[this] val startTimeNs = System.nanoTime()
  /** Local blocks to fetch, excluding zero-sized blocks. */
  private[this] val localBlocks = scala.collection.mutable.LinkedHashSet[(BlockId, Int)]()
  /** Host local blockIds to fetch by executors, excluding zero-sized blocks. */
  private[this] val hostLocalBlocksByExecutor =
    LinkedHashMap[BlockManagerId, Seq[(BlockId, Long, Int)]]()
  /** Host local blocks to fetch, excluding zero-sized blocks. */
  private[this] val hostLocalBlocks = scala.collection.mutable.LinkedHashSet[(BlockId, Int)]()
  /**
   * A queue to hold our results. This turns the asynchronous model provided by
   * [[org.apache.spark.network.BlockTransferService]] into a synchronous model (iterator).
   */
  private[this] val results = new LinkedBlockingQueue[FetchResult]
  /**
   * Queue of fetch requests to issue; we'll pull requests off this gradually to make sure that
   * the number of bytes in flight is limited to maxBytesInFlight.
   */
  private[this] val fetchRequests = new Queue[FetchRequest]
  /**
   * Queue of fetch requests which could not be issued the first time they were dequeued. These
   * requests are tried again when the fetch constraints are satisfied.
   */
  private[this] val deferredFetchRequests = new HashMap[BlockManagerId, Queue[FetchRequest]]()
  /** Current number of blocks in flight per host:port */
  private[this] val numBlocksInFlightPerAddress = new HashMap[BlockManagerId, Int]()
  /**
   * The blocks that can't be decompressed successfully, it is used to guarantee that we retry
   * at most once for those corrupted blocks.
   */
  private[this] val corruptedBlocks = mutable.HashSet[BlockId]()
  /**
   * A set to store the files used for shuffling remote huge blocks. Files in this set will be
   * deleted when cleanup. This is a layer of defensiveness against disk file leaks.
   */
  @GuardedBy("this")
  private[this] val shuffleFilesSet = mutable.HashSet[DownloadFile]()
  private[this] val onCompleteCallback = new ArrowShuffleFetchCompletionListener(this)
  /**
   * Total number of blocks to fetch.
   */
  private[this] var numBlocksToFetch = 0
  /**
   * The number of blocks processed by the caller. The iterator is exhausted when
   * [[numBlocksProcessed]] == [[numBlocksToFetch]].
   */
  private[this] var numBlocksProcessed = 0
  /**
   * Current [[FetchResult]] being processed. We track this so we can release the current buffer
   * in case of a runtime exception when processing the current buffer.
   */
  @volatile private[this] var currentResult: SuccessFetchResult = null
  /** Current bytes in flight from our requests */
  private[this] var bytesInFlight = 0L
  /** Current number of requests in flight */
  private[this] var reqsInFlight = 0
  /**
   * Whether the iterator is still active. If isZombie is true, the callback interface will no
   * longer place fetched blocks into [[results]].
   */
  @GuardedBy("this")
  private[this] var isZombie = false

  initialize()

  override def createTempFile(transportConf: TransportConf): DownloadFile = {
    // we never need to do any encryption or decryption here, regardless of configs, because that
    // is handled at another layer in the code.  When encryption is enabled, shuffle data is written
    // to disk encrypted in the first place, and sent over the network still encrypted.
    new SimpleDownloadFile(
      blockManager.diskBlockManager.createTempLocalBlock()._2, transportConf)
  }

  override def registerTempFileToClean(file: DownloadFile): Boolean = synchronized {
    if (isZombie) {
      false
    } else {
      shuffleFilesSet += file
      true
    }
  }

  /**
   * Fetches the next (BlockId, InputStream). If a task fails, the ManagedBuffers
   * underlying each InputStream will be freed by the cleanup() method registered with the
   * TaskCompletionListener. However, callers should close() these InputStreams
   * as soon as they are no longer needed, in order to release memory as early as possible.
   *
   * Throws a FetchFailedException if the next block could not be fetched.
   */
  override def next(): (BlockId, ManagedBuffer) = {
    if (!hasNext) {
      throw new NoSuchElementException()
    }

    numBlocksProcessed += 1

    var result: FetchResult = null
    var input: ManagedBuffer = null
    // Take the next fetched result and try to decompress it to detect data corruption,
    // then fetch it one more time if it's corrupt, throw FailureFetchResult if the second fetch
    // is also corrupt, so the previous stage could be retried.
    // For local shuffle block, throw FailureFetchResult for the first IOException.
    while (result == null) {
      val startFetchWait = System.nanoTime()
      result = results.take()
      val fetchWaitTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startFetchWait)
      shuffleMetrics.incFetchWaitTime(fetchWaitTime)

      result match {
        case r@SuccessFetchResult(blockId, mapIndex, address, size, buf, isNetworkReqDone) =>
          if (address != blockManager.blockManagerId) {
            if (hostLocalBlocks.contains(blockId -> mapIndex)) {
              shuffleMetrics.incLocalBlocksFetched(1)
              shuffleMetrics.incLocalBytesRead(buf.size)
            } else {
              numBlocksInFlightPerAddress(address) = numBlocksInFlightPerAddress(address) - 1
              shuffleMetrics.incRemoteBytesRead(buf.size)
              if (buf.isInstanceOf[FileSegmentManagedBuffer]) {
                shuffleMetrics.incRemoteBytesReadToDisk(buf.size)
              }
              shuffleMetrics.incRemoteBlocksFetched(1)
              bytesInFlight -= size
            }
          }
          if (isNetworkReqDone) {
            reqsInFlight -= 1
            logDebug("Number of requests in flight " + reqsInFlight)
          }

          if (buf.size == 0) {
            // We will never legitimately receive a zero-size block. All blocks with zero records
            // have zero size and all zero-size blocks have no records (and hence should never
            // have been requested in the first place). This statement relies on behaviors of the
            // shuffle writers, which are guaranteed by the following test cases:
            //
            // - BypassMergeSortShuffleWriterSuite: "write with some empty partitions"
            // - UnsafeShuffleWriterSuite: "writeEmptyIterator"
            // - DiskBlockObjectWriterSuite: "commit() and close() without ever opening or writing"
            //
            // There is not an explicit test for SortShuffleWriter but the underlying APIs that
            // uses are shared by the UnsafeShuffleWriter (both writers use DiskBlockObjectWriter
            // which returns a zero-size from commitAndGet() in case no records were written
            // since the last call.
            val msg = s"Received a zero-size buffer for block $blockId from $address " +
              s"(expectedApproxSize = $size, isNetworkReqDone=$isNetworkReqDone)"
            throwFetchFailedException(blockId, mapIndex, address, new IOException(msg))
          }

          input = buf

        case FailureFetchResult(blockId, mapIndex, address, e) =>
          throwFetchFailedException(blockId, mapIndex, address, e)
      }

      // Send fetch requests up to maxBytesInFlight
      fetchUpToMaxBytes()
    }

    currentResult = result.asInstanceOf[SuccessFetchResult]
    (currentResult.blockId, input)
  }

  override def hasNext: Boolean = numBlocksProcessed < numBlocksToFetch

  private def fetchUpToMaxBytes(): Unit = {
    // Send fetch requests up to maxBytesInFlight. If you cannot fetch from a remote host
    // immediately, defer the request until the next time it can be processed.

    // Process any outstanding deferred fetch requests if possible.
    if (deferredFetchRequests.nonEmpty) {
      for ((remoteAddress, defReqQueue) <- deferredFetchRequests) {
        while (isRemoteBlockFetchable(defReqQueue) &&
          !isRemoteAddressMaxedOut(remoteAddress, defReqQueue.front)) {
          val request = defReqQueue.dequeue()
          logDebug(s"Processing deferred fetch request for $remoteAddress with "
            + s"${request.blocks.length} blocks")
          send(remoteAddress, request)
          if (defReqQueue.isEmpty) {
            deferredFetchRequests -= remoteAddress
          }
        }
      }
    }

    // Process any regular fetch requests if possible.
    while (isRemoteBlockFetchable(fetchRequests)) {
      val request = fetchRequests.dequeue()
      val remoteAddress = request.address
      if (isRemoteAddressMaxedOut(remoteAddress, request)) {
        logDebug(s"Deferring fetch request for $remoteAddress with ${request.blocks.size} blocks")
        val defReqQueue = deferredFetchRequests.getOrElse(remoteAddress, new Queue[FetchRequest]())
        defReqQueue.enqueue(request)
        deferredFetchRequests(remoteAddress) = defReqQueue
      } else {
        send(remoteAddress, request)
      }
    }

    def send(remoteAddress: BlockManagerId, request: FetchRequest): Unit = {
      sendRequest(request)
      numBlocksInFlightPerAddress(remoteAddress) =
        numBlocksInFlightPerAddress.getOrElse(remoteAddress, 0) + request.blocks.size
    }

    def isRemoteBlockFetchable(fetchReqQueue: Queue[FetchRequest]): Boolean = {
      fetchReqQueue.nonEmpty &&
        (bytesInFlight == 0 ||
          (reqsInFlight + 1 <= maxReqsInFlight &&
            bytesInFlight + fetchReqQueue.front.size <= maxBytesInFlight))
    }

    // Checks if sending a new fetch request will exceed the max no. of blocks being fetched from a
    // given remote address.
    def isRemoteAddressMaxedOut(remoteAddress: BlockManagerId, request: FetchRequest): Boolean = {
      numBlocksInFlightPerAddress.getOrElse(remoteAddress, 0) + request.blocks.size >
        maxBlocksInFlightPerAddress
    }
  }

  private[this] def sendRequest(req: FetchRequest): Unit = {
    logDebug("Sending request for %d blocks (%s) from %s".format(
      req.blocks.size, Utils.bytesToString(req.size), req.address.hostPort))
    bytesInFlight += req.size
    reqsInFlight += 1

    // so we can look up the block info of each blockID
    val infoMap = req.blocks.map {
      case FetchBlockInfo(blockId, size, mapIndex) => (blockId.toString, (size, mapIndex))
    }.toMap
    val remainingBlocks = new HashSet[String]() ++= infoMap.keys
    val blockIds = req.blocks.map(_.blockId.toString)
    val address = req.address

    val blockFetchingListener = new BlockFetchingListener {
      override def onBlockFetchSuccess(blockId: String, buf: ManagedBuffer): Unit = {
        // Only add the buffer to results queue if the iterator is not zombie,
        // i.e. cleanup() has not been called yet.
        ShuffleBlockFetcherIterator301.this.synchronized {
          if (!isZombie) {
            // Increment the ref count because we need to pass this to a different thread.
            // This needs to be released after use.
            buf.retain()
            remainingBlocks -= blockId
            results.put(new SuccessFetchResult(BlockId(blockId), infoMap(blockId)._2,
              address, infoMap(blockId)._1, buf, remainingBlocks.isEmpty))
            logDebug("remainingBlocks: " + remainingBlocks)
          }
        }
        logTrace(s"Got remote block $blockId after ${Utils.getUsedTimeNs(startTimeNs)}")
      }

      override def onBlockFetchFailure(blockId: String, e: Throwable): Unit = {
        logError(s"Failed to get block(s) from ${req.address.host}:${req.address.port}", e)
        results.put(new FailureFetchResult(BlockId(blockId), infoMap(blockId)._2, address, e))
      }
    }

    // Fetch remote shuffle blocks to disk when the request is too large. Since the shuffle data is
    // already encrypted and compressed over the wire(w.r.t. the related configs), we can just fetch
    // the data and write it to file directly.
    if (req.size > maxReqSizeShuffleToMem) {
      shuffleClient.fetchBlocks(address.host, address.port, address.executorId, blockIds.toArray,
        blockFetchingListener, this)
    } else {
      shuffleClient.fetchBlocks(address.host, address.port, address.executorId, blockIds.toArray,
        blockFetchingListener, null)
    }
  }

  private[storage] def throwFetchFailedException(
    blockId: BlockId,
    mapIndex: Int,
    address: BlockManagerId,
    e: Throwable) = {
    blockId match {
      case ShuffleBlockId(shufId, mapId, reduceId) =>
        throw new FetchFailedException(address, shufId, mapId, mapIndex, reduceId, e)
      case ShuffleBlockBatchId(shuffleId, mapId, startReduceId, _) =>
        throw new FetchFailedException(address, shuffleId, mapId, mapIndex, startReduceId, e)
      case _ =>
        throw new SparkException(
          "Failed to get block " + blockId + ", which is not a shuffle block", e)
    }
  }

  def toCompletionIterator: Iterator[(BlockId, ManagedBuffer)] = {
    CompletionIterator[(BlockId, ManagedBuffer), this.type](this,
      onCompleteCallback.onComplete(context))
  }

  /**
   * Mark the iterator as zombie, and release all buffers that haven't been deserialized yet.
   */
  private[storage] def cleanup(): Unit = {
    synchronized {
      isZombie = true
    }
    releaseCurrentResultBuffer()
    // Release buffers in the results queue
    val iter = results.iterator()
    while (iter.hasNext) {
      val result = iter.next()
      result match {
        case SuccessFetchResult(_, _, address, _, buf, _) =>
          if (address != blockManager.blockManagerId) {
            shuffleMetrics.incRemoteBytesRead(buf.size)
            if (buf.isInstanceOf[FileSegmentManagedBuffer]) {
              shuffleMetrics.incRemoteBytesReadToDisk(buf.size)
            }
            shuffleMetrics.incRemoteBlocksFetched(1)
          }
          buf.release()
        case _ =>
      }
    }
    shuffleFilesSet.foreach { file =>
      if (!file.delete()) {
        logWarning("Failed to cleanup shuffle fetch temp file " + file.path())
      }
    }
  }

  // Decrements the buffer reference count.
  // The currentResult is set to null to prevent releasing the buffer again on cleanup()
  private[storage] def releaseCurrentResultBuffer(): Unit = {
    // Release the current buffer if necessary
    if (currentResult != null) {
      currentResult.buf.release()
    }
    currentResult = null
  }

  private[this] def initialize(): Unit = {
    // Add a task completion callback (called in both success case and failure case) to cleanup.
    context.addTaskCompletionListener(onCompleteCallback)

    // Partition blocks by the different fetch modes: local, host-local and remote blocks.
    val remoteRequests = partitionBlocksByFetchMode()
    // Add the remote requests into our queue in a random order
    fetchRequests ++= Utils.randomize(remoteRequests)
    assert((0 == reqsInFlight) == (0 == bytesInFlight),
      "expected reqsInFlight = 0 but found reqsInFlight = " + reqsInFlight +
        ", expected bytesInFlight = 0 but found bytesInFlight = " + bytesInFlight)

    // Send out initial requests for blocks, up to our maxBytesInFlight
    fetchUpToMaxBytes()

    val numFetches = remoteRequests.size - fetchRequests.size
    logInfo(s"Started $numFetches remote fetches in ${Utils.getUsedTimeNs(startTimeNs)}")

    // Get Local Blocks
    fetchLocalBlocks()
    logDebug(s"Got local blocks in ${Utils.getUsedTimeNs(startTimeNs)}")

    if (hostLocalBlocks.nonEmpty) {
      blockManager.hostLocalDirManager.foreach(fetchHostLocalBlocks)
    }
  }

  private[this] def partitionBlocksByFetchMode(): ArrayBuffer[FetchRequest] = {
    logDebug(s"maxBytesInFlight: $maxBytesInFlight, targetRemoteRequestSize: "
      + s"$targetRemoteRequestSize, maxBlocksInFlightPerAddress: $maxBlocksInFlightPerAddress")

    // Partition to local, host-local and remote blocks. Remote blocks are further split into
    // FetchRequests of size at most maxBytesInFlight in order to limit the amount of data in flight
    val collectedRemoteRequests = new ArrayBuffer[FetchRequest]
    var localBlockBytes = 0L
    var hostLocalBlockBytes = 0L
    var remoteBlockBytes = 0L

    val hostLocalDirReadingEnabled =
      blockManager.hostLocalDirManager != null && blockManager.hostLocalDirManager.isDefined

    for ((address, blockInfos) <- blocksByAddress) {
      if (address.executorId == blockManager.blockManagerId.executorId) {
        checkBlockSizes(blockInfos)
        val mergedBlockInfos = mergeContinuousShuffleBlockIdsIfNeeded(
          blockInfos.map(info => FetchBlockInfo(info._1, info._2, info._3)), doBatchFetch)
        numBlocksToFetch += mergedBlockInfos.size
        localBlocks ++= mergedBlockInfos.map(info => (info.blockId, info.mapIndex))
        localBlockBytes += mergedBlockInfos.map(_.size).sum
      } else if (hostLocalDirReadingEnabled && address.host == blockManager.blockManagerId.host) {
        checkBlockSizes(blockInfos)
        val mergedBlockInfos = mergeContinuousShuffleBlockIdsIfNeeded(
          blockInfos.map(info => FetchBlockInfo(info._1, info._2, info._3)), doBatchFetch)
        numBlocksToFetch += mergedBlockInfos.size
        val blocksForAddress =
          mergedBlockInfos.map(info => (info.blockId, info.size, info.mapIndex))
        hostLocalBlocksByExecutor += address -> blocksForAddress
        hostLocalBlocks ++= blocksForAddress.map(info => (info._1, info._3))
        hostLocalBlockBytes += mergedBlockInfos.map(_.size).sum
      } else {
        remoteBlockBytes += blockInfos.map(_._2).sum
        collectFetchRequests(address, blockInfos, collectedRemoteRequests)
      }
    }
    val numRemoteBlocks = collectedRemoteRequests.map(_.blocks.size).sum
    val totalBytes = localBlockBytes + remoteBlockBytes + hostLocalBlockBytes
    assert(numBlocksToFetch == localBlocks.size + hostLocalBlocks.size + numRemoteBlocks,
      s"The number of non-empty blocks $numBlocksToFetch doesn't equal to the number of local " +
        s"blocks ${localBlocks.size} + the number of host-local blocks ${hostLocalBlocks.size} " +
        s"+ the number of remote blocks ${numRemoteBlocks}.")
    logInfo(s"Getting $numBlocksToFetch (${Utils.bytesToString(totalBytes)}) non-empty blocks " +
      s"including ${localBlocks.size} (${Utils.bytesToString(localBlockBytes)}) local and " +
      s"${hostLocalBlocks.size} (${Utils.bytesToString(hostLocalBlockBytes)}) " +
      s"host-local and $numRemoteBlocks (${Utils.bytesToString(remoteBlockBytes)}) remote blocks")
    collectedRemoteRequests
  }

  private def collectFetchRequests(
    address: BlockManagerId,
    blockInfos: Seq[(BlockId, Long, Int)],
    collectedRemoteRequests: ArrayBuffer[FetchRequest]): Unit = {
    val iterator = blockInfos.iterator
    var curRequestSize = 0L
    var curBlocks = new ArrayBuffer[FetchBlockInfo]

    while (iterator.hasNext) {
      val (blockId, size, mapIndex) = iterator.next()
      assertPositiveBlockSize(blockId, size)
      curBlocks += FetchBlockInfo(blockId, size, mapIndex)
      curRequestSize += size
      // For batch fetch, the actual block in flight should count for merged block.
      val mayExceedsMaxBlocks = !doBatchFetch && curBlocks.size >= maxBlocksInFlightPerAddress
      if (curRequestSize >= targetRemoteRequestSize || mayExceedsMaxBlocks) {
        curBlocks = createFetchRequests(curBlocks, address, isLast = false,
          collectedRemoteRequests).to[ArrayBuffer]
        curRequestSize = curBlocks.map(_.size).sum
      }
    }
    // Add in the final request
    if (curBlocks.nonEmpty) {
      curBlocks = createFetchRequests(curBlocks, address, isLast = true,
        collectedRemoteRequests).to[ArrayBuffer]
      curRequestSize = curBlocks.map(_.size).sum
    }
  }

  private def createFetchRequests(
    curBlocks: Seq[FetchBlockInfo],
    address: BlockManagerId,
    isLast: Boolean,
    collectedRemoteRequests: ArrayBuffer[FetchRequest]): Seq[FetchBlockInfo] = {
    val mergedBlocks = mergeContinuousShuffleBlockIdsIfNeeded(curBlocks, doBatchFetch)
    numBlocksToFetch += mergedBlocks.size
    var retBlocks = Seq.empty[FetchBlockInfo]
    if (mergedBlocks.length <= maxBlocksInFlightPerAddress) {
      collectedRemoteRequests += createFetchRequest(mergedBlocks, address)
    } else {
      mergedBlocks.grouped(maxBlocksInFlightPerAddress).foreach { blocks =>
        if (blocks.length == maxBlocksInFlightPerAddress || isLast) {
          collectedRemoteRequests += createFetchRequest(blocks, address)
        } else {
          // The last group does not exceed `maxBlocksInFlightPerAddress`. Put it back
          // to `curBlocks`.
          retBlocks = blocks
          numBlocksToFetch -= blocks.size
        }
      }
    }
    retBlocks
  }

  private def createFetchRequest(
    blocks: Seq[FetchBlockInfo],
    address: BlockManagerId): FetchRequest = {
    logDebug(s"Creating fetch request of ${blocks.map(_.size).sum} at $address "
      + s"with ${blocks.size} blocks")
    FetchRequest(address, blocks)
  }

  private def assertPositiveBlockSize(blockId: BlockId, blockSize: Long): Unit = {
    if (blockSize < 0) {
      throw BlockException(blockId, "Negative block size " + size)
    } else if (blockSize == 0) {
      throw BlockException(blockId, "Zero-sized blocks should be excluded.")
    }
  }

  private def checkBlockSizes(blockInfos: Seq[(BlockId, Long, Int)]): Unit = {
    blockInfos.foreach { case (blockId, size, _) => assertPositiveBlockSize(blockId, size) }
  }

  /**
   * Fetch the local blocks while we are fetching remote blocks. This is ok because
   * `ManagedBuffer`'s memory is allocated lazily when we create the input stream, so all we
   * track in-memory are the ManagedBuffer references themselves.
   */
  private[this] def fetchLocalBlocks(): Unit = {
    logDebug(s"Start fetching local blocks: ${localBlocks.mkString(", ")}")
    val iter = localBlocks.iterator
    while (iter.hasNext) {
      val (blockId, mapIndex) = iter.next()
      try {
        val buf = blockManager.getLocalBlockData(blockId)
        shuffleMetrics.incLocalBlocksFetched(1)
        shuffleMetrics.incLocalBytesRead(buf.size)
        buf.retain()
        results.put(new SuccessFetchResult(blockId, mapIndex, blockManager.blockManagerId,
          buf.size(), buf, false))
      } catch {
        // If we see an exception, stop immediately.
        case e: Exception =>
          e match {
            // ClosedByInterruptException is an excepted exception when kill task,
            // don't log the exception stack trace to avoid confusing users.
            // See: SPARK-28340
            case ce: ClosedByInterruptException =>
              logError("Error occurred while fetching local blocks, " + ce.getMessage)
            case ex: Exception => logError("Error occurred while fetching local blocks", ex)
          }
          results.put(new FailureFetchResult(blockId, mapIndex, blockManager.blockManagerId, e))
          return
      }
    }
  }

  /**
   * Fetch the host-local blocks while we are fetching remote blocks. This is ok because
   * `ManagedBuffer`'s memory is allocated lazily when we create the input stream, so all we
   * track in-memory are the ManagedBuffer references themselves.
   */
  private[this] def fetchHostLocalBlocks(hostLocalDirManager: HostLocalDirManager): Unit = {
    val cachedDirsByExec = hostLocalDirManager.getCachedHostLocalDirs()
    val (hostLocalBlocksWithCachedDirs, hostLocalBlocksWithMissingDirs) =
      hostLocalBlocksByExecutor
        .map { case (hostLocalBmId, bmInfos) =>
          (hostLocalBmId, bmInfos, cachedDirsByExec.get(hostLocalBmId.executorId))
        }.partition(_._3.isDefined)
    val bmId = blockManager.blockManagerId
    val immutableHostLocalBlocksWithoutDirs =
      hostLocalBlocksWithMissingDirs.map { case (hostLocalBmId, bmInfos, _) =>
        hostLocalBmId -> bmInfos
      }.toMap
    if (immutableHostLocalBlocksWithoutDirs.nonEmpty) {
      logDebug(s"Asynchronous fetching host-local blocks without cached executors' dir: " +
        s"${immutableHostLocalBlocksWithoutDirs.mkString(", ")}")
      val execIdsWithoutDirs = immutableHostLocalBlocksWithoutDirs.keys.map(_.executorId).toArray
      hostLocalDirManager.getHostLocalDirs(execIdsWithoutDirs) {
        case Success(dirs) =>
          immutableHostLocalBlocksWithoutDirs.foreach { case (hostLocalBmId, blockInfos) =>
            blockInfos.takeWhile { case (blockId, _, mapIndex) =>
              fetchHostLocalBlock(
                blockId,
                mapIndex,
                dirs.get(hostLocalBmId.executorId),
                hostLocalBmId)
            }
          }
          logDebug(s"Got host-local blocks (without cached executors' dir) in " +
            s"${Utils.getUsedTimeNs(startTimeNs)}")

        case Failure(throwable) =>
          logError(s"Error occurred while fetching host local blocks", throwable)
          val (hostLocalBmId, blockInfoSeq) = immutableHostLocalBlocksWithoutDirs.head
          val (blockId, _, mapIndex) = blockInfoSeq.head
          results.put(FailureFetchResult(blockId, mapIndex, hostLocalBmId, throwable))
      }
    }
    if (hostLocalBlocksWithCachedDirs.nonEmpty) {
      logDebug(s"Synchronous fetching host-local blocks with cached executors' dir: " +
        s"${hostLocalBlocksWithCachedDirs.mkString(", ")}")
      hostLocalBlocksWithCachedDirs.foreach { case (_, blockInfos, localDirs) =>
        blockInfos.foreach { case (blockId, _, mapIndex) =>
          if (!fetchHostLocalBlock(blockId, mapIndex, localDirs.get, bmId)) {
            return
          }
        }
      }
      logDebug(s"Got host-local blocks (with cached executors' dir) in " +
        s"${Utils.getUsedTimeNs(startTimeNs)}")
    }
  }

  private[this] def fetchHostLocalBlock(
    blockId: BlockId,
    mapIndex: Int,
    localDirs: Array[String],
    blockManagerId: BlockManagerId): Boolean = {
    try {
      val buf = blockManager.getHostLocalShuffleData(blockId, localDirs)
      buf.retain()
      results.put(SuccessFetchResult(blockId, mapIndex, blockManagerId, buf.size(), buf,
        isNetworkReqDone = false))
      true
    } catch {
      case e: Exception =>
        // If we see an exception, stop immediately.
        logError(s"Error occurred while fetching local blocks", e)
        results.put(FailureFetchResult(blockId, mapIndex, blockManagerId, e))
        false
    }
  }
}

/**
 * A listener to be called at the completion of the ShuffleBlockFetcherIterator
 *
 * @param data the ShuffleBlockFetcherIterator to process
 */
class ArrowShuffleFetchCompletionListener(var data: ShuffleBlockFetcherIterator301)
  extends TaskCompletionListener {

  // Just an alias for onTaskCompletion to avoid confusing
  def onComplete(context: TaskContext): Unit = this.onTaskCompletion(context)

  override def onTaskCompletion(context: TaskContext): Unit = {
    if (data != null) {
      data.cleanup()
      // Null out the referent here to make sure we don't keep a reference to this
      // ShuffleBlockFetcherIterator, after we're done reading from it, to let it be
      // collected during GC. Otherwise we can hold metadata on block locations(blocksByAddress)
      data = null
    }
  }
}
