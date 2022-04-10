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
  private var rowIter: Iterator[InternalRow] = Nil.toIterator
  private var batch: Option[ColumnarBatch] = None
  private var hasNextBatch = true
  private var closed = false

  taskContext.addTaskCompletionListener[Unit] { _ =>
    close()
  }

  override def next: InternalRow = {
    rowIter.next().copy() // copy to avoid dangling after batch is closed
  }

  override def hasNext: Boolean = {
    while (hasNextBatch && !rowIter.hasNext) {
      nextBatch()
    }
    if (!rowIter.hasNext) {
      close() // free resources once the iterator is completed
    }
    rowIter.hasNext
  }

  private def nextBatch(): Unit = if (hasNextBatch) {
    if (arrowReader.loadNextBatch()) {
      rowIter = getCurrentBatchIter
    } else {
      rowIter = Nil.toIterator
      hasNextBatch = false
    }
  }

  private def getCurrentBatchIter: Iterator[InternalRow] = {
    val columns = root.getFieldVectors.asScala.map {
      new ArrowColumnVector(_).asInstanceOf[ColumnVector]
    }
    batch.foreach(_.close())
    batch = Some(new ColumnarBatch(columns.toArray, root.getRowCount))
    batch.get.rowIterator().asScala
  }

  private def close(): Unit = {
    this.synchronized {
      if (!closed) {
        batch.foreach(_.close())
        root.close()
        arrowReader.close()
        allocator.close()
        closed = true
      }
    }
  }
}