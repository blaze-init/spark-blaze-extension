package org.apache.spark.sql.blaze.execution

import java.nio.channels.ByteChannel
import java.nio.channels.SeekableByteChannel

import scala.collection.JavaConverters._

import org.apache.arrow.vector.ipc.ArrowFileReader
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.util2.ArrowColumnVector
import org.apache.spark.sql.vectorized.ColumnarBatch
import org.apache.spark.sql.vectorized.ColumnVector
import org.apache.spark.TaskContext
import org.apache.spark.sql.util2.ArrowUtils2

class ArrowReaderIterator(channel: SeekableByteChannel, taskContext: TaskContext)
    extends Iterator[InternalRow] {

  private val allocator =
    ArrowUtils2.rootAllocator.newChildAllocator("arrowReaderIterator", 0, Long.MaxValue)
  private val arrowReader = new ArrowFileReader(channel, allocator)
  private val root = arrowReader.getVectorSchemaRoot
  private var rowIter = getCurrentBatchIter

  taskContext.addTaskCompletionListener[Unit] { _ =>
    root.close()
    arrowReader.close()
    allocator.close()
  }

  override def next: InternalRow = rowIter.next()
  override def hasNext: Boolean = {
    var hasNextRecord = rowIter.hasNext
    var hasNextBatch = true

    while (!hasNextRecord && hasNextBatch) {
      if (arrowReader.loadNextBatch()) {
        rowIter = getCurrentBatchIter
        hasNextBatch = true
        hasNextRecord = rowIter.hasNext
      } else {
        hasNextBatch = false
        hasNextRecord = false
      }
    }
    hasNextRecord
  }

  private def getCurrentBatchIter: Iterator[InternalRow] = {
    val columns = root.getFieldVectors.asScala.map {
      new ArrowColumnVector(_).asInstanceOf[ColumnVector]
    }
    val batch = new ColumnarBatch(columns.toArray)
    batch.setNumRows(root.getRowCount)
    batch.rowIterator().asScala
  }
}
