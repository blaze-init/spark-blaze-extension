// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

/**
 * Protobuf type {@code plan.protobuf.CastNode}
 */
public final class CastNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:plan.protobuf.CastNode)
    CastNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CastNode.newBuilder() to construct.
  private CastNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CastNode() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CastNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CastNode(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            org.blaze.protobuf.LogicalExprNode.Builder subBuilder = null;
            if (expr_ != null) {
              subBuilder = expr_.toBuilder();
            }
            expr_ = input.readMessage(org.blaze.protobuf.LogicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(expr_);
              expr_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            org.blaze.protobuf.ArrowType.Builder subBuilder = null;
            if (arrowType_ != null) {
              subBuilder = arrowType_.toBuilder();
            }
            arrowType_ = input.readMessage(org.blaze.protobuf.ArrowType.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(arrowType_);
              arrowType_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_CastNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_CastNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.blaze.protobuf.CastNode.class, org.blaze.protobuf.CastNode.Builder.class);
  }

  public static final int EXPR_FIELD_NUMBER = 1;
  private org.blaze.protobuf.LogicalExprNode expr_;
  /**
   * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
   * @return Whether the expr field is set.
   */
  @java.lang.Override
  public boolean hasExpr() {
    return expr_ != null;
  }
  /**
   * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
   * @return The expr.
   */
  @java.lang.Override
  public org.blaze.protobuf.LogicalExprNode getExpr() {
    return expr_ == null ? org.blaze.protobuf.LogicalExprNode.getDefaultInstance() : expr_;
  }
  /**
   * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
   */
  @java.lang.Override
  public org.blaze.protobuf.LogicalExprNodeOrBuilder getExprOrBuilder() {
    return getExpr();
  }

  public static final int ARROW_TYPE_FIELD_NUMBER = 2;
  private org.blaze.protobuf.ArrowType arrowType_;
  /**
   * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
   * @return Whether the arrowType field is set.
   */
  @java.lang.Override
  public boolean hasArrowType() {
    return arrowType_ != null;
  }
  /**
   * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
   * @return The arrowType.
   */
  @java.lang.Override
  public org.blaze.protobuf.ArrowType getArrowType() {
    return arrowType_ == null ? org.blaze.protobuf.ArrowType.getDefaultInstance() : arrowType_;
  }
  /**
   * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
   */
  @java.lang.Override
  public org.blaze.protobuf.ArrowTypeOrBuilder getArrowTypeOrBuilder() {
    return getArrowType();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (expr_ != null) {
      output.writeMessage(1, getExpr());
    }
    if (arrowType_ != null) {
      output.writeMessage(2, getArrowType());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (expr_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getExpr());
    }
    if (arrowType_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getArrowType());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.blaze.protobuf.CastNode)) {
      return super.equals(obj);
    }
    org.blaze.protobuf.CastNode other = (org.blaze.protobuf.CastNode) obj;

    if (hasExpr() != other.hasExpr()) return false;
    if (hasExpr()) {
      if (!getExpr()
          .equals(other.getExpr())) return false;
    }
    if (hasArrowType() != other.hasArrowType()) return false;
    if (hasArrowType()) {
      if (!getArrowType()
          .equals(other.getArrowType())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasExpr()) {
      hash = (37 * hash) + EXPR_FIELD_NUMBER;
      hash = (53 * hash) + getExpr().hashCode();
    }
    if (hasArrowType()) {
      hash = (37 * hash) + ARROW_TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getArrowType().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.blaze.protobuf.CastNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.CastNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.CastNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.CastNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.CastNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.CastNode parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.blaze.protobuf.CastNode prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code plan.protobuf.CastNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:plan.protobuf.CastNode)
      org.blaze.protobuf.CastNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_CastNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_CastNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.blaze.protobuf.CastNode.class, org.blaze.protobuf.CastNode.Builder.class);
    }

    // Construct using org.blaze.protobuf.CastNode.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (exprBuilder_ == null) {
        expr_ = null;
      } else {
        expr_ = null;
        exprBuilder_ = null;
      }
      if (arrowTypeBuilder_ == null) {
        arrowType_ = null;
      } else {
        arrowType_ = null;
        arrowTypeBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_CastNode_descriptor;
    }

    @java.lang.Override
    public org.blaze.protobuf.CastNode getDefaultInstanceForType() {
      return org.blaze.protobuf.CastNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.blaze.protobuf.CastNode build() {
      org.blaze.protobuf.CastNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.blaze.protobuf.CastNode buildPartial() {
      org.blaze.protobuf.CastNode result = new org.blaze.protobuf.CastNode(this);
      if (exprBuilder_ == null) {
        result.expr_ = expr_;
      } else {
        result.expr_ = exprBuilder_.build();
      }
      if (arrowTypeBuilder_ == null) {
        result.arrowType_ = arrowType_;
      } else {
        result.arrowType_ = arrowTypeBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.blaze.protobuf.CastNode) {
        return mergeFrom((org.blaze.protobuf.CastNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.blaze.protobuf.CastNode other) {
      if (other == org.blaze.protobuf.CastNode.getDefaultInstance()) return this;
      if (other.hasExpr()) {
        mergeExpr(other.getExpr());
      }
      if (other.hasArrowType()) {
        mergeArrowType(other.getArrowType());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.blaze.protobuf.CastNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.blaze.protobuf.CastNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.blaze.protobuf.LogicalExprNode expr_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.LogicalExprNode, org.blaze.protobuf.LogicalExprNode.Builder, org.blaze.protobuf.LogicalExprNodeOrBuilder> exprBuilder_;
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     * @return Whether the expr field is set.
     */
    public boolean hasExpr() {
      return exprBuilder_ != null || expr_ != null;
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     * @return The expr.
     */
    public org.blaze.protobuf.LogicalExprNode getExpr() {
      if (exprBuilder_ == null) {
        return expr_ == null ? org.blaze.protobuf.LogicalExprNode.getDefaultInstance() : expr_;
      } else {
        return exprBuilder_.getMessage();
      }
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    public Builder setExpr(org.blaze.protobuf.LogicalExprNode value) {
      if (exprBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        expr_ = value;
        onChanged();
      } else {
        exprBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    public Builder setExpr(
        org.blaze.protobuf.LogicalExprNode.Builder builderForValue) {
      if (exprBuilder_ == null) {
        expr_ = builderForValue.build();
        onChanged();
      } else {
        exprBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    public Builder mergeExpr(org.blaze.protobuf.LogicalExprNode value) {
      if (exprBuilder_ == null) {
        if (expr_ != null) {
          expr_ =
            org.blaze.protobuf.LogicalExprNode.newBuilder(expr_).mergeFrom(value).buildPartial();
        } else {
          expr_ = value;
        }
        onChanged();
      } else {
        exprBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    public Builder clearExpr() {
      if (exprBuilder_ == null) {
        expr_ = null;
        onChanged();
      } else {
        expr_ = null;
        exprBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    public org.blaze.protobuf.LogicalExprNode.Builder getExprBuilder() {
      
      onChanged();
      return getExprFieldBuilder().getBuilder();
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    public org.blaze.protobuf.LogicalExprNodeOrBuilder getExprOrBuilder() {
      if (exprBuilder_ != null) {
        return exprBuilder_.getMessageOrBuilder();
      } else {
        return expr_ == null ?
            org.blaze.protobuf.LogicalExprNode.getDefaultInstance() : expr_;
      }
    }
    /**
     * <code>.plan.protobuf.LogicalExprNode expr = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.LogicalExprNode, org.blaze.protobuf.LogicalExprNode.Builder, org.blaze.protobuf.LogicalExprNodeOrBuilder> 
        getExprFieldBuilder() {
      if (exprBuilder_ == null) {
        exprBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.blaze.protobuf.LogicalExprNode, org.blaze.protobuf.LogicalExprNode.Builder, org.blaze.protobuf.LogicalExprNodeOrBuilder>(
                getExpr(),
                getParentForChildren(),
                isClean());
        expr_ = null;
      }
      return exprBuilder_;
    }

    private org.blaze.protobuf.ArrowType arrowType_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.ArrowType, org.blaze.protobuf.ArrowType.Builder, org.blaze.protobuf.ArrowTypeOrBuilder> arrowTypeBuilder_;
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     * @return Whether the arrowType field is set.
     */
    public boolean hasArrowType() {
      return arrowTypeBuilder_ != null || arrowType_ != null;
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     * @return The arrowType.
     */
    public org.blaze.protobuf.ArrowType getArrowType() {
      if (arrowTypeBuilder_ == null) {
        return arrowType_ == null ? org.blaze.protobuf.ArrowType.getDefaultInstance() : arrowType_;
      } else {
        return arrowTypeBuilder_.getMessage();
      }
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder setArrowType(org.blaze.protobuf.ArrowType value) {
      if (arrowTypeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        arrowType_ = value;
        onChanged();
      } else {
        arrowTypeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder setArrowType(
        org.blaze.protobuf.ArrowType.Builder builderForValue) {
      if (arrowTypeBuilder_ == null) {
        arrowType_ = builderForValue.build();
        onChanged();
      } else {
        arrowTypeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder mergeArrowType(org.blaze.protobuf.ArrowType value) {
      if (arrowTypeBuilder_ == null) {
        if (arrowType_ != null) {
          arrowType_ =
            org.blaze.protobuf.ArrowType.newBuilder(arrowType_).mergeFrom(value).buildPartial();
        } else {
          arrowType_ = value;
        }
        onChanged();
      } else {
        arrowTypeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder clearArrowType() {
      if (arrowTypeBuilder_ == null) {
        arrowType_ = null;
        onChanged();
      } else {
        arrowType_ = null;
        arrowTypeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    public org.blaze.protobuf.ArrowType.Builder getArrowTypeBuilder() {
      
      onChanged();
      return getArrowTypeFieldBuilder().getBuilder();
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    public org.blaze.protobuf.ArrowTypeOrBuilder getArrowTypeOrBuilder() {
      if (arrowTypeBuilder_ != null) {
        return arrowTypeBuilder_.getMessageOrBuilder();
      } else {
        return arrowType_ == null ?
            org.blaze.protobuf.ArrowType.getDefaultInstance() : arrowType_;
      }
    }
    /**
     * <code>.plan.protobuf.ArrowType arrow_type = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.ArrowType, org.blaze.protobuf.ArrowType.Builder, org.blaze.protobuf.ArrowTypeOrBuilder> 
        getArrowTypeFieldBuilder() {
      if (arrowTypeBuilder_ == null) {
        arrowTypeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.blaze.protobuf.ArrowType, org.blaze.protobuf.ArrowType.Builder, org.blaze.protobuf.ArrowTypeOrBuilder>(
                getArrowType(),
                getParentForChildren(),
                isClean());
        arrowType_ = null;
      }
      return arrowTypeBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:plan.protobuf.CastNode)
  }

  // @@protoc_insertion_point(class_scope:plan.protobuf.CastNode)
  private static final org.blaze.protobuf.CastNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.blaze.protobuf.CastNode();
  }

  public static org.blaze.protobuf.CastNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CastNode>
      PARSER = new com.google.protobuf.AbstractParser<CastNode>() {
    @java.lang.Override
    public CastNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CastNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CastNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CastNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.blaze.protobuf.CastNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

