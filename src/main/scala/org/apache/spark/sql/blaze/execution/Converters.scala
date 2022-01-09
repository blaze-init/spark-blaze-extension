package org.apache.spark.sql.blaze.execution

import com.kwai.{FileSegmentSeekableByteChannel, NioSeekableByteChannel}
import org.apache.arrow.vector._
import org.apache.arrow.vector.dictionary.DictionaryProvider.MapDictionaryProvider
import org.apache.arrow.vector.ipc.{ArrowFileReader, ArrowFileWriter}
import org.apache.spark.TaskContext
import org.apache.spark.network.buffer.{FileSegmentManagedBuffer, ManagedBuffer, NettyManagedBuffer, NioManagedBuffer}
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.arrow.ArrowWriter
import org.apache.spark.sql.types._
import org.apache.spark.sql.util.ArrowUtils
import org.apache.spark.sql.vectorized.{ArrowColumnVector, ColumnarBatch, ColumnVector}
import org.apache.spark.util.Utils
import java.io.{OutputStream, RandomAccessFile}
import java.nio.ByteBuffer
import java.nio.channels.{Channels, SeekableByteChannel}
import java.nio.ByteOrder

import scala.collection.JavaConverters._

import org.apache.arrow.vector.ipc.ArrowStreamReader

object Converters {

  /**
   * Parse ManagedBuffer from shuffle reader into record iterator.
   * Each ManagedBuffer may be composed of one or more IPC entities.
   */
  def readManagedBuffer(
    data: ManagedBuffer,
    context: TaskContext
  ): Iterator[InternalRow] = {
    var result: Iterator[InternalRow] = Iterator.empty
    data match {
      case f: FileSegmentManagedBuffer =>
        val file = f.getFile
        val lengthReader = new RandomAccessFile(file, "r")

        var curEnd = f.getOffset + f.getLength
        while (curEnd > 0) {
          val lenBuf = new Array[Byte](8)
          lengthReader.seek(curEnd - 8)
          lengthReader.read(lenBuf)
          val len = ByteBuffer.wrap(lenBuf).order(ByteOrder.LITTLE_ENDIAN).getInt
          val curStart = curEnd - 8 - len

          val fsc = new FileSegmentSeekableByteChannel(file, curStart, len)
          result ++= readBatches(fsc, context)
          curEnd = curStart
        }

      case _: NettyManagedBuffer | _: NioManagedBuffer =>
        val all = data.nioByteBuffer()
        var curStart = 0
        var curEnd = all.limit()

        do {
          val lenCopy = all.duplicate()
          lenCopy.position(curEnd - 8)
          lenCopy.limit(curEnd)
          val lenBuf = ByteBuffer.allocate(8)
          lenBuf.put(lenCopy)
          val len = lenBuf.order(ByteOrder.LITTLE_ENDIAN).getInt

          val cur = all.duplicate()
          curEnd -= 8
          curStart = curEnd - len
          cur.position(curStart)
          cur.limit(curEnd)
          val sc = new NioSeekableByteChannel(cur, curStart, len)
          result ++= readBatches(sc, context)
        } while (curStart > 0)
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
      ArrowUtils.rootAllocator.newChildAllocator("readBatchesFromManagedBuffer", 0, Long.MaxValue)
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

    val arrowSchema = ArrowUtils.toArrowSchema(schema, timeZoneId)
    val allocator =
      ArrowUtils.rootAllocator.newChildAllocator("toBatchIterator", 0, Long.MaxValue)

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
