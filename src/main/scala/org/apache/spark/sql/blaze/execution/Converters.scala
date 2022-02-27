package org.apache.spark.sql.blaze.execution

import java.io.OutputStream
import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.channels.Channels
import java.nio.channels.SeekableByteChannel
import java.nio.ByteOrder

import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

import com.kwai.FileSegmentSeekableByteChannel
import com.kwai.NioSeekableByteChannel
import org.apache.arrow.vector._
import org.apache.arrow.vector.dictionary.DictionaryProvider.MapDictionaryProvider
import org.apache.arrow.vector.ipc.ArrowFileReader
import org.apache.arrow.vector.ipc.ArrowFileWriter
import org.apache.spark.TaskContext
import org.apache.spark.internal.Logging
import org.apache.spark.network.buffer.FileSegmentManagedBuffer
import org.apache.spark.network.buffer.ManagedBuffer
import org.apache.spark.network.buffer.NettyManagedBuffer
import org.apache.spark.network.buffer.NioManagedBuffer
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.types._
import org.apache.spark.sql.util2.ArrowUtils2
import org.apache.spark.sql.util2.ArrowWriter
import org.apache.spark.sql.util2.ArrowColumnVector
import org.apache.spark.sql.vectorized.ColumnVector
import org.apache.spark.sql.vectorized.ColumnarBatch
import org.apache.spark.util.Utils

object Converters extends Logging {

  /**
   * Parse ManagedBuffer from shuffle reader into record iterator.
   * Each ManagedBuffer may be composed of one or more IPC entities.
   */
  def readManagedBuffer(data: ManagedBuffer, context: TaskContext): Iterator[InternalRow] = {
    val segmentSeekableByteChannels = readManagedBufferToSegmentByteChannels(data)
    segmentSeekableByteChannels.toIterator.flatMap(readBatches(_, context))
  }

  def readManagedBufferToSegmentByteChannelsAsJava(data: ManagedBuffer): java.util.List[SeekableByteChannel] = {
    readManagedBufferToSegmentByteChannels(data).asJava
  }

  def readManagedBufferToSegmentByteChannels(data: ManagedBuffer): Seq[SeekableByteChannel] = {
    val result: ArrayBuffer[SeekableByteChannel] = ArrayBuffer()
    data match {
      case f: FileSegmentManagedBuffer =>
        val file = f.getFile
        val lengthReader = new RandomAccessFile(file, "r")
        var curEnd = f.getOffset + f.getLength

        while (curEnd > f.getOffset) {
          val lenBuf = new Array[Byte](8)
          lengthReader.seek(curEnd - 8)
          lengthReader.read(lenBuf)
          val len = ByteBuffer.wrap(lenBuf).order(ByteOrder.LITTLE_ENDIAN).getLong.toInt
          val curStart = curEnd - 8 - len
          val fsc = new FileSegmentSeekableByteChannel(file, curStart, len)
          result += fsc
          curEnd = curStart
        }

      case _: NettyManagedBuffer | _: NioManagedBuffer =>
        val all = data.nioByteBuffer()
        val lenBuf = ByteBuffer.allocate(8)
        var curEnd = all.limit()

        while (curEnd > 0) {
          lenBuf.putLong(all.getLong(curEnd - 8))
          val len = lenBuf.order(ByteOrder.LITTLE_ENDIAN).getLong(0).toInt
          val curStart = curEnd - 8 - len

          val sc = new NioSeekableByteChannel(all, curStart, len)
          result += sc
          curEnd = curStart
        }
      case mb =>
        throw new UnsupportedOperationException(s"ManagedBuffer of $mb not supported")
    }
    result
  }

  /**
   * Read batches from one IPC entity. [IPC-header] [IPC-record-batches] [IPC-footer]
   */
  def readBatches(
    channel: SeekableByteChannel,
    context: TaskContext): Iterator[InternalRow] = {

    val allocator =
      ArrowUtils2.rootAllocator.newChildAllocator("readBatchesFromManagedBuffer", 0, Long.MaxValue)
    val arrowReader = new ArrowFileReader(channel, allocator)//, CommonsCompressionFactory.INSTANCE)
    val root = arrowReader.getVectorSchemaRoot()
    val first = arrowReader.loadNextBatch()

    new Iterator[InternalRow] {
      private var rowIter = if (first) nextBatch() else Iterator.empty

      context.addTaskCompletionListener[Unit] { _ =>
        root.close()
        allocator.close()
        arrowReader.close()
        channel.close()
      }

      override def hasNext: Boolean = rowIter.hasNext || {
        if (arrowReader.loadNextBatch()) {
          rowIter = nextBatch()
          true
        } else {
          root.close()
          allocator.close()
          false
        }
      }

      override def next(): InternalRow = rowIter.next()

      private def nextBatch(): Iterator[InternalRow] = {
        val columns = root.getFieldVectors.asScala.map { vector =>
          new ArrowColumnVector(vector).asInstanceOf[ColumnVector]
        }.toArray

        val batch = new ColumnarBatch(columns)
        batch.setNumRows(root.getRowCount)
        batch.rowIterator().asScala
      }
    }
  }

  /**
   * Maps Iterator from InternalRow to serialized ArrowRecordBatches. Limit ArrowRecordBatch size
   * in a batch by setting maxRecordsPerBatch or use 0 to fully consume rowIter.
   */
  private[sql] def toBatchIterator(
    rowIter: Iterator[InternalRow],
    schema: StructType,
    maxRecordsPerBatch: Int,
    timeZoneId: String,
    context: TaskContext,
    out: OutputStream): Unit = {

    val arrowSchema = ArrowUtils2.toArrowSchema(schema, timeZoneId)
    val allocator =
      ArrowUtils2.rootAllocator.newChildAllocator("toBatchIterator", 0, Long.MaxValue)

    val root = VectorSchemaRoot.create(arrowSchema, allocator)
    val arrowWriter = ArrowWriter.create(root)

    context.addTaskCompletionListener[Unit] { _ =>
      root.close()
      allocator.close()
    }

    val batches = new Iterator[VectorSchemaRoot] {

      override def hasNext: Boolean = rowIter.hasNext || {
        root.close()
        allocator.close()
        false
      }

      override def next(): VectorSchemaRoot = {
        Utils.tryWithSafeFinally {
          var rowCount = 0
          while (rowIter.hasNext && (maxRecordsPerBatch <= 0 || rowCount < maxRecordsPerBatch)) {
            val row = rowIter.next()
            arrowWriter.write(row)
            rowCount += 1
          }
          arrowWriter.finish()
        } {
          arrowWriter.reset()
        }

        root
      }
    }

    val writer = new ArrowFileWriter(root, new MapDictionaryProvider(), Channels.newChannel(out))
    writer.start()
    while (batches.hasNext) {
      batches.next()
      writer.writeBatch()
    }
    writer.end()
  }
}
