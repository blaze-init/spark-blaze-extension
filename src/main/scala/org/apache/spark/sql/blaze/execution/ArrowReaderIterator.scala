package org.apache.spark.sql.blaze.execution

import scala.collection.JavaConverters._

import org.apache.arrow.vector.ipc.ArrowReader
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.util2.ArrowColumnVector
import org.apache.spark.sql.vectorized.ColumnarBatch
import org.apache.spark.sql.vectorized.ColumnVector

class ArrowReaderIterator(arrowReader: ArrowReader) extends Iterator[InternalRow] {

  private val root = arrowReader.getVectorSchemaRoot
  private var rowIter = getCurrentBatchIter

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

  override def next: InternalRow = {
    rowIter.next()
  }

  private def getCurrentBatchIter: Iterator[InternalRow] = {
    val columns = root.getFieldVectors.asScala.map(new ArrowColumnVector(_).asInstanceOf[ColumnVector])
    val batch = new ColumnarBatch(columns.toArray)
    batch.setNumRows(root.getRowCount)
    batch.rowIterator().asScala
  }
}