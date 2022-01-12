package org.apache.spark.sql.blaze

import org.apache.spark.sql.catalyst.expressions.Add
import org.apache.spark.sql.catalyst.expressions.And
import org.apache.spark.sql.catalyst.expressions.AttributeReference
import org.apache.spark.sql.catalyst.expressions.Divide
import org.apache.spark.sql.catalyst.expressions.EqualTo
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.expressions.GreaterThan
import org.apache.spark.sql.catalyst.expressions.GreaterThanOrEqual
import org.apache.spark.sql.catalyst.expressions.IsNotNull
import org.apache.spark.sql.catalyst.expressions.LessThan
import org.apache.spark.sql.catalyst.expressions.LessThanOrEqual
import org.apache.spark.sql.catalyst.expressions.Like
import org.apache.spark.sql.catalyst.expressions.Literal
import org.apache.spark.sql.catalyst.expressions.Multiply
import org.apache.spark.sql.catalyst.expressions.Not
import org.apache.spark.sql.catalyst.expressions.Or
import org.apache.spark.sql.catalyst.expressions.Subtract
import org.apache.spark.sql.types.BinaryType
import org.apache.spark.sql.types.BooleanType
import org.apache.spark.sql.types.ByteType
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.types.FloatType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.LongType
import org.apache.spark.sql.types.ShortType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.TimestampType
import org.ballistacompute.protobuf.ArrowType
import org.ballistacompute.protobuf.EmptyMessage
import org.ballistacompute.protobuf.Field
import org.ballistacompute.protobuf.PhysicalBinaryExprNode
import org.ballistacompute.protobuf.PhysicalColumn
import org.ballistacompute.protobuf.PhysicalExprNode
import org.ballistacompute.protobuf.PhysicalIsNotNull
import org.ballistacompute.protobuf.PhysicalNot
import org.ballistacompute.protobuf.ScalarValue
import org.ballistacompute.protobuf.Schema
import org.ballistacompute.protobuf.Timestamp

object NativeConverters {
  def convertDataType(sparkDataType: DataType): ArrowType = {
    val arrowTypeBuilder = ArrowType.newBuilder()
    sparkDataType match {
      case BooleanType => arrowTypeBuilder.setBOOL(EmptyMessage.getDefaultInstance)
      case ByteType => arrowTypeBuilder.setINT8(EmptyMessage.getDefaultInstance)
      case ShortType => arrowTypeBuilder.setINT16(EmptyMessage.getDefaultInstance)
      case IntegerType => arrowTypeBuilder.setINT32(EmptyMessage.getDefaultInstance)
      case LongType => arrowTypeBuilder.setINT64(EmptyMessage.getDefaultInstance)
      case FloatType => arrowTypeBuilder.setFLOAT32(EmptyMessage.getDefaultInstance)
      case DoubleType => arrowTypeBuilder.setFLOAT64(EmptyMessage.getDefaultInstance)
      case StringType => arrowTypeBuilder.setUTF8(EmptyMessage.getDefaultInstance)
      case BinaryType => arrowTypeBuilder.setBINARY(EmptyMessage.getDefaultInstance)
      case DateType => arrowTypeBuilder.setDATE32(EmptyMessage.getDefaultInstance)
      case TimestampType => arrowTypeBuilder.setTIMESTAMP(Timestamp.getDefaultInstance) // NOTE: microsecond => millisecond

      // TODO: support complex data types
      case _ => throw new NotImplementedError(s"Data type conversion not implemented ${sparkDataType}")
    }
    arrowTypeBuilder.build()
  }

  def convertValue(sparkValue: Any, dataType: DataType): ScalarValue = {
    val scalarValueBuilder = ScalarValue.newBuilder()
    dataType match {
      case BooleanType => scalarValueBuilder.setBoolValue(sparkValue.asInstanceOf[Boolean])
      case ByteType => scalarValueBuilder.setInt8Value(sparkValue.asInstanceOf[Byte])
      case ShortType => scalarValueBuilder.setInt16Value(sparkValue.asInstanceOf[Short])
      case IntegerType => scalarValueBuilder.setInt32Value(sparkValue.asInstanceOf[Int])
      case LongType => scalarValueBuilder.setInt64Value(sparkValue.asInstanceOf[Long])
      case FloatType => scalarValueBuilder.setFloat32Value(sparkValue.asInstanceOf[Float])
      case DoubleType => scalarValueBuilder.setFloat64Value(sparkValue.asInstanceOf[Double])
      case StringType => scalarValueBuilder.setUtf8Value(sparkValue.asInstanceOf[String])
      case BinaryType => throw new NotImplementedError("???")
      case DateType => scalarValueBuilder.setDate32Value(sparkValue.asInstanceOf[Int])
      case TimestampType => scalarValueBuilder.setTimeMicrosecondValue(sparkValue.asInstanceOf[Long])

      // TODO: support complex data types
      case _ => throw new NotImplementedError(s"Value conversion not implemented ${dataType}")
    }

    // TODO: support complex data types
    scalarValueBuilder.build()
  }

  def convertField(sparkField: StructField): Field = {
    Field.newBuilder()
      .setName(sparkField.name)
      .setNullable(sparkField.nullable)
      .setArrowType(convertDataType(sparkField.dataType))
      .build()
  }

  def convertSchema(sparkSchema: StructType): Schema = {
    val schemaBuilder = Schema.newBuilder()
    sparkSchema.foreach(sparkField => schemaBuilder.addColumns(convertField(sparkField)))
    schemaBuilder.build()
  }

  def convertExpr(sparkExpr: Expression): PhysicalExprNode = {
    def buildExprNode(buildFn: (PhysicalExprNode.Builder) => Unit): PhysicalExprNode = {
      val builder = PhysicalExprNode.newBuilder()
      buildFn(builder)
      builder.build()
    }
    def buildBinaryExprNode(lhs: PhysicalExprNode, rhs: PhysicalExprNode, op: String): PhysicalExprNode = {
      buildExprNode(_.setBinaryExpr(PhysicalBinaryExprNode.newBuilder().setL(lhs).setR(rhs).setOp(op).build()))
    }

    sparkExpr match {
      case Literal(value, dataType) => buildExprNode(_.setLiteral(convertValue(value, dataType)).build())
      case AttributeReference(name, _, _, _) => buildExprNode(_.setColumn(PhysicalColumn.newBuilder().setName(name).build()))

      // unary ops
      case IsNotNull(child) => buildExprNode(_.setIsNotNullExpr(PhysicalIsNotNull.newBuilder().setExpr(convertExpr(child)).build()))
      case Not(child) => buildExprNode(_.setNotExpr(PhysicalNot.newBuilder().setExpr(convertExpr(child)).build()))

      // binary ops
      case EqualTo(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Eq")
      case GreaterThan(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Gt")
      case LessThan(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Lt")
      case GreaterThanOrEqual(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "GtEq")
      case LessThanOrEqual(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "LtEq")
      case Add(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Plus")
      case Subtract(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Minus")
      case Multiply(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Multiply")
      case Divide(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Divide")
      case Like(lhs, rhs, '\\') => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Like")
      case And(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "And")
      case Or(lhs, rhs) => buildBinaryExprNode(convertExpr(lhs), convertExpr(rhs), "Or")

      case unsupportedExpression =>
        throw new NotImplementedExpressionConversion(unsupportedExpression)
    }
  }

  class NotImplementedExpressionConversion(expression: Expression) extends Error {
    override def getMessage: String = s"not implemented expression conversion: ${expression.treeString}"
  }
}