package org.apache.spark.sql.blaze

import scala.collection.JavaConverters._
import scala.reflect.ClassTag.Nothing

import com.univocity.parsers.annotations.Trim
import org.apache.spark.sql.catalyst.expressions.Abs
import org.apache.spark.sql.catalyst.expressions.Acos
import org.apache.spark.sql.catalyst.expressions.Add
import org.apache.spark.sql.catalyst.expressions.And
import org.apache.spark.sql.catalyst.expressions.Asin
import org.apache.spark.sql.catalyst.expressions.Atan
import org.apache.spark.sql.catalyst.expressions.AttributeReference
import org.apache.spark.sql.catalyst.expressions.Cast
import org.apache.spark.sql.catalyst.expressions.Ceil
import org.apache.spark.sql.catalyst.expressions.Concat
import org.apache.spark.sql.catalyst.expressions.Cos
import org.apache.spark.sql.catalyst.expressions.DatePart
import org.apache.spark.sql.catalyst.expressions.Divide
import org.apache.spark.sql.catalyst.expressions.EqualTo
import org.apache.spark.sql.catalyst.expressions.Exp
import org.apache.spark.sql.catalyst.expressions.Expression
import org.apache.spark.sql.catalyst.expressions.Floor
import org.apache.spark.sql.catalyst.expressions.GreaterThan
import org.apache.spark.sql.catalyst.expressions.GreaterThanOrEqual
import org.apache.spark.sql.catalyst.expressions.IsNotNull
import org.apache.spark.sql.catalyst.expressions.LessThan
import org.apache.spark.sql.catalyst.expressions.LessThanOrEqual
import org.apache.spark.sql.catalyst.expressions.Like
import org.apache.spark.sql.catalyst.expressions.Literal
import org.apache.spark.sql.catalyst.expressions.Log
import org.apache.spark.sql.catalyst.expressions.Log10
import org.apache.spark.sql.catalyst.expressions.Log2
import org.apache.spark.sql.catalyst.expressions.Lower
import org.apache.spark.sql.catalyst.expressions.Md5
import org.apache.spark.sql.catalyst.expressions.Multiply
import org.apache.spark.sql.catalyst.expressions.Not
import org.apache.spark.sql.catalyst.expressions.NullIf
import org.apache.spark.sql.catalyst.expressions.OctetLength
import org.apache.spark.sql.catalyst.expressions.Or
import org.apache.spark.sql.catalyst.expressions.Round
import org.apache.spark.sql.catalyst.expressions.Sha2
import org.apache.spark.sql.catalyst.expressions.Signum
import org.apache.spark.sql.catalyst.expressions.Sin
import org.apache.spark.sql.catalyst.expressions.Sqrt
import org.apache.spark.sql.catalyst.expressions.StringTrim
import org.apache.spark.sql.catalyst.expressions.StringTrimLeft
import org.apache.spark.sql.catalyst.expressions.StringTrimRight
import org.apache.spark.sql.catalyst.expressions.Subtract
import org.apache.spark.sql.catalyst.expressions.Tan
import org.apache.spark.sql.catalyst.expressions.TruncDate
import org.apache.spark.sql.catalyst.expressions.Upper
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
import org.ballistacompute.protobuf.PhysicalCastNode
import org.ballistacompute.protobuf.PhysicalColumn
import org.ballistacompute.protobuf.PhysicalExprNode
import org.ballistacompute.protobuf.PhysicalIsNotNull
import org.ballistacompute.protobuf.PhysicalNot
import org.ballistacompute.protobuf.PhysicalScalarFunctionNode
import org.ballistacompute.protobuf.ScalarFunction
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
    def buildExprNode(buildFn: (PhysicalExprNode.Builder) => PhysicalExprNode.Builder): PhysicalExprNode =
      buildFn(PhysicalExprNode.newBuilder()).build()

    def buildBinaryExprNode(left: Expression, right: Expression, op: String): PhysicalExprNode = buildExprNode {
      _.setBinaryExpr(PhysicalBinaryExprNode.newBuilder()
        .setL(convertExpr(left))
        .setR(convertExpr(right))
        .setOp(op)
        .build())
    }

    def buildScalarFunction(fn: ScalarFunction, args: Seq[Expression], dataType: DataType): PhysicalExprNode = buildExprNode {
      _.setScalarFunction(PhysicalScalarFunctionNode.newBuilder()
        .setName(fn.name())
        .setFun(fn)
        .addAllArgs(args.map(convertExpr).asJava)
        .setReturnType(convertDataType(dataType))
        .build())
    }

    sparkExpr match {
      case Literal(value, dataType) => buildExprNode {
        _.setLiteral(convertValue(value, dataType))
      }
      case AttributeReference(name, _, _, _) => buildExprNode {
        _.setColumn(PhysicalColumn.newBuilder().setName(name).build())
      }

      // cast
      case Cast(child, dataType, _) => buildExprNode {
        _.setCast(PhysicalCastNode.newBuilder()
          .setExpr(convertExpr(child))
          .setArrowType(convertDataType(dataType))
          .build())
      }

      // unary ops
      case IsNotNull(child) => buildExprNode {
        _.setIsNotNullExpr(PhysicalIsNotNull.newBuilder().setExpr(convertExpr(child)).build())
      }
      case Not(child) => buildExprNode {
        _.setNotExpr(PhysicalNot.newBuilder().setExpr(convertExpr(child)).build())
      }

      // binary ops
      case EqualTo(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Eq")
      case GreaterThan(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Gt")
      case LessThan(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Lt")
      case GreaterThanOrEqual(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "GtEq")
      case LessThanOrEqual(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "LtEq")
      case Add(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Plus")
      case Subtract(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Minus")
      case Multiply(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Multiply")
      case Divide(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Divide")
      case Like(lhs, rhs, '\\') => buildBinaryExprNode(lhs, rhs, "Like")
      case And(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "And")
      case Or(lhs, rhs) => buildBinaryExprNode(lhs, rhs, "Or")

      // builtin scalar functions
      case e: Sqrt => buildScalarFunction(ScalarFunction.SQRT, e.children, e.dataType)
      case e: Sin => buildScalarFunction(ScalarFunction.SIN, e.children, e.dataType)
      case e: Cos => buildScalarFunction(ScalarFunction.COS, e.children, e.dataType)
      case e: Tan => buildScalarFunction(ScalarFunction.TAN, e.children, e.dataType)
      case e: Asin => buildScalarFunction(ScalarFunction.ASIN, e.children, e.dataType)
      case e: Acos => buildScalarFunction(ScalarFunction.ACOS, e.children, e.dataType)
      case e: Atan => buildScalarFunction(ScalarFunction.ATAN, e.children, e.dataType)
      case e: Exp => buildScalarFunction(ScalarFunction.EXP, e.children, e.dataType)
      // case Nothing => buildScalarFunction(ScalarFunction.LOG, Nil)
      case e: Log2 => buildScalarFunction(ScalarFunction.LOG2, e.children, e.dataType)
      case e: Log10 => buildScalarFunction(ScalarFunction.LOG10, e.children, e.dataType)
      case e: Floor => buildScalarFunction(ScalarFunction.FLOOR, e.children, e.dataType)
      case e: Ceil => buildScalarFunction(ScalarFunction.CEIL, e.children, e.dataType)
      case Round(_1, Literal(0, _)) => buildScalarFunction(ScalarFunction.ROUND, Seq(_1), _1.dataType)
      // case Nothing => buildScalarFunction(ScalarFunction.TRUNC, Nil)
      case e: Abs => buildScalarFunction(ScalarFunction.ABS, e.children, e.dataType)
      case e: Signum => buildScalarFunction(ScalarFunction.SIGNUM, e.children, e.dataType)
      case e: OctetLength => buildScalarFunction(ScalarFunction.OCTETLENGTH, e.children, e.dataType)
      case e: Concat => buildScalarFunction(ScalarFunction.CONCAT, e.children, e.dataType)
      case e: Lower => buildScalarFunction(ScalarFunction.LOWER, e.children, e.dataType)
      case e: Upper => buildScalarFunction(ScalarFunction.UPPER, e.children, e.dataType)
      case e: StringTrim => buildScalarFunction(ScalarFunction.TRIM, e.srcStr +: e.trimStr.toSeq, e.dataType)
      case e: StringTrimLeft => buildScalarFunction(ScalarFunction.LTRIM, e.srcStr +: e.trimStr.toSeq, e.dataType)
      case e: StringTrimRight => buildScalarFunction(ScalarFunction.RTRIM, e.srcStr +: e.trimStr.toSeq, e.dataType)
      // case Nothing => buildScalarFunction(ScalarFunction.TOTIMESTAMP, Nil)
      // case Nothing => buildScalarFunction(ScalarFunction.ARRAY, Nil)
      case e: NullIf => buildScalarFunction(ScalarFunction.NULLIF, e.children, e.dataType)
      case e: DatePart => buildScalarFunction(ScalarFunction.DATEPART, e.children, e.dataType)
      case e: TruncDate => buildScalarFunction(ScalarFunction.DATEPART, e.children, e.dataType)
      case Md5(_1) => buildScalarFunction(ScalarFunction.MD5, Seq(_1), StringType)
      case Sha2(_1, Literal(224, _)) => buildScalarFunction(ScalarFunction.SHA224, Seq(_1), StringType)
      case Sha2(_1, Literal(  0, _)) => buildScalarFunction(ScalarFunction.SHA256, Seq(_1), StringType)
      case Sha2(_1, Literal(256, _)) => buildScalarFunction(ScalarFunction.SHA256, Seq(_1), StringType)
      case Sha2(_1, Literal(384, _)) => buildScalarFunction(ScalarFunction.SHA384, Seq(_1), StringType)
      case Sha2(_1, Literal(512, _)) => buildScalarFunction(ScalarFunction.SHA512, Seq(_1), StringType)
      case e: Log => buildScalarFunction(ScalarFunction.LN, e.children, e.dataType)
      // case Nothing => buildScalarFunction(ScalarFunction.TOTIMESTAMPMILLIS, Nil)

      case unsupportedExpression =>
        throw new NotImplementedExpressionConversion(unsupportedExpression)
    }
  }

  class NotImplementedExpressionConversion(expression: Expression) extends Error {
    override def getMessage: String = s"not implemented expression conversion: ${expression.treeString}"
  }
}