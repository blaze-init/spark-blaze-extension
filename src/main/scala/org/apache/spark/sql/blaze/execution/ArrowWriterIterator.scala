package org.apache.spark.sql.blaze.execution

import java.nio.channels.ByteChannel
import java.nio.channels.Channels

import org.apache.arrow.vector.VectorSchemaRoot
import org.apache.arrow.vector.dictionary.DictionaryProvider.MapDictionaryProvider
import org.apache.arrow.vector.ipc.ArrowFileWriter
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.util2.ArrowUtils2
import org.apache.spark.sql.util2.ArrowWriter
import org.apache.spark.util.ByteBufferOutputStream
import org.apache.spark.util.Utils
import org.apache.spark.TaskContext
import org.blaze.NioSeekableByteChannel

class ArrowWriterIterator(
    rowIter: Iterator[InternalRow],
    schema: StructType,
    timeZoneId: String,
    taskContext: TaskContext,
    recordBatchSize: Int = 10000)
    extends Iterator[NioSeekableByteChannel] {

  private val allocator =
    ArrowUtils2.rootAllocator.newChildAllocator("arrowWriterIterator", 0, Long.MaxValue)
  private val arrowSchema = ArrowUtils2.toArrowSchema(schema, timeZoneId)
  private val root = VectorSchemaRoot.create(arrowSchema, allocator)

  taskContext.addTaskCompletionListener[Unit] { _ =>
    root.close()
    allocator.close()
  }

  override def hasNext: Boolean = rowIter.hasNext
  override def next(): NioSeekableByteChannel = {
    val arrowWriter = ArrowWriter.create(root)
    while (rowIter.hasNext && root.getRowCount < recordBatchSize) {
      arrowWriter.write(rowIter.next())
    }
    arrowWriter.finish()

    val outputStream = new ByteBufferOutputStream()
    Utils.tryWithResource(outputStream) { outputStream =>
      Utils.tryWithResource(Channels.newChannel(outputStream)) { channel =>
        val writer = new ArrowFileWriter(root, new MapDictionaryProvider(), channel)
        writer.start()
        writer.writeBatch()
        writer.end()
        writer.close()
      }
    }
    new NioSeekableByteChannel(outputStream.toByteBuffer, 0, outputStream.size())
  }
}
