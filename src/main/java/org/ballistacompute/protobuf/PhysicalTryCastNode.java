// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.PhysicalTryCastNode}
 */
public final class PhysicalTryCastNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.PhysicalTryCastNode)
    PhysicalTryCastNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PhysicalTryCastNode.newBuilder() to construct.
  private PhysicalTryCastNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PhysicalTryCastNode() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PhysicalTryCastNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PhysicalTryCastNode(
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
            org.ballistacompute.protobuf.PhysicalExprNode.Builder subBuilder = null;
            if (expr_ != null) {
              subBuilder = expr_.toBuilder();
            }
            expr_ = input.readMessage(org.ballistacompute.protobuf.PhysicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(expr_);
              expr_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            org.ballistacompute.protobuf.ArrowType.Builder subBuilder = null;
            if (arrowType_ != null) {
              subBuilder = arrowType_.toBuilder();
            }
            arrowType_ = input.readMessage(org.ballistacompute.protobuf.ArrowType.parser(), extensionRegistry);
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalTryCastNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalTryCastNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.PhysicalTryCastNode.class, org.ballistacompute.protobuf.PhysicalTryCastNode.Builder.class);
  }

  public static final int EXPR_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.PhysicalExprNode expr_;
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
   * @return Whether the expr field is set.
   */
  @java.lang.Override
  public boolean hasExpr() {
    return expr_ != null;
  }
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
   * @return The expr.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalExprNode getExpr() {
    return expr_ == null ? org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance() : expr_;
  }
  /**
   * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder() {
    return getExpr();
  }

  public static final int ARROW_TYPE_FIELD_NUMBER = 2;
  private org.ballistacompute.protobuf.ArrowType arrowType_;
  /**
   * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
   * @return Whether the arrowType field is set.
   */
  @java.lang.Override
  public boolean hasArrowType() {
    return arrowType_ != null;
  }
  /**
   * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
   * @return The arrowType.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ArrowType getArrowType() {
    return arrowType_ == null ? org.ballistacompute.protobuf.ArrowType.getDefaultInstance() : arrowType_;
  }
  /**
   * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.ArrowTypeOrBuilder getArrowTypeOrBuilder() {
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
    if (!(obj instanceof org.ballistacompute.protobuf.PhysicalTryCastNode)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.PhysicalTryCastNode other = (org.ballistacompute.protobuf.PhysicalTryCastNode) obj;

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

  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalTryCastNode parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.PhysicalTryCastNode prototype) {
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
   * Protobuf type {@code ballista.protobuf.PhysicalTryCastNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.PhysicalTryCastNode)
      org.ballistacompute.protobuf.PhysicalTryCastNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalTryCastNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalTryCastNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.PhysicalTryCastNode.class, org.ballistacompute.protobuf.PhysicalTryCastNode.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.PhysicalTryCastNode.newBuilder()
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
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalTryCastNode_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalTryCastNode getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.PhysicalTryCastNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalTryCastNode build() {
      org.ballistacompute.protobuf.PhysicalTryCastNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalTryCastNode buildPartial() {
      org.ballistacompute.protobuf.PhysicalTryCastNode result = new org.ballistacompute.protobuf.PhysicalTryCastNode(this);
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
      if (other instanceof org.ballistacompute.protobuf.PhysicalTryCastNode) {
        return mergeFrom((org.ballistacompute.protobuf.PhysicalTryCastNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.PhysicalTryCastNode other) {
      if (other == org.ballistacompute.protobuf.PhysicalTryCastNode.getDefaultInstance()) return this;
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
      org.ballistacompute.protobuf.PhysicalTryCastNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.PhysicalTryCastNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.ballistacompute.protobuf.PhysicalExprNode expr_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> exprBuilder_;
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     * @return Whether the expr field is set.
     */
    public boolean hasExpr() {
      return exprBuilder_ != null || expr_ != null;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     * @return The expr.
     */
    public org.ballistacompute.protobuf.PhysicalExprNode getExpr() {
      if (exprBuilder_ == null) {
        return expr_ == null ? org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance() : expr_;
      } else {
        return exprBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder setExpr(org.ballistacompute.protobuf.PhysicalExprNode value) {
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
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder setExpr(
        org.ballistacompute.protobuf.PhysicalExprNode.Builder builderForValue) {
      if (exprBuilder_ == null) {
        expr_ = builderForValue.build();
        onChanged();
      } else {
        exprBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public Builder mergeExpr(org.ballistacompute.protobuf.PhysicalExprNode value) {
      if (exprBuilder_ == null) {
        if (expr_ != null) {
          expr_ =
            org.ballistacompute.protobuf.PhysicalExprNode.newBuilder(expr_).mergeFrom(value).buildPartial();
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
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
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
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNode.Builder getExprBuilder() {
      
      onChanged();
      return getExprFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    public org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder getExprOrBuilder() {
      if (exprBuilder_ != null) {
        return exprBuilder_.getMessageOrBuilder();
      } else {
        return expr_ == null ?
            org.ballistacompute.protobuf.PhysicalExprNode.getDefaultInstance() : expr_;
      }
    }
    /**
     * <code>.ballista.protobuf.PhysicalExprNode expr = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder> 
        getExprFieldBuilder() {
      if (exprBuilder_ == null) {
        exprBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.PhysicalExprNode, org.ballistacompute.protobuf.PhysicalExprNode.Builder, org.ballistacompute.protobuf.PhysicalExprNodeOrBuilder>(
                getExpr(),
                getParentForChildren(),
                isClean());
        expr_ = null;
      }
      return exprBuilder_;
    }

    private org.ballistacompute.protobuf.ArrowType arrowType_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.ArrowType, org.ballistacompute.protobuf.ArrowType.Builder, org.ballistacompute.protobuf.ArrowTypeOrBuilder> arrowTypeBuilder_;
    /**
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     * @return Whether the arrowType field is set.
     */
    public boolean hasArrowType() {
      return arrowTypeBuilder_ != null || arrowType_ != null;
    }
    /**
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     * @return The arrowType.
     */
    public org.ballistacompute.protobuf.ArrowType getArrowType() {
      if (arrowTypeBuilder_ == null) {
        return arrowType_ == null ? org.ballistacompute.protobuf.ArrowType.getDefaultInstance() : arrowType_;
      } else {
        return arrowTypeBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder setArrowType(org.ballistacompute.protobuf.ArrowType value) {
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
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder setArrowType(
        org.ballistacompute.protobuf.ArrowType.Builder builderForValue) {
      if (arrowTypeBuilder_ == null) {
        arrowType_ = builderForValue.build();
        onChanged();
      } else {
        arrowTypeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     */
    public Builder mergeArrowType(org.ballistacompute.protobuf.ArrowType value) {
      if (arrowTypeBuilder_ == null) {
        if (arrowType_ != null) {
          arrowType_ =
            org.ballistacompute.protobuf.ArrowType.newBuilder(arrowType_).mergeFrom(value).buildPartial();
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
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
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
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     */
    public org.ballistacompute.protobuf.ArrowType.Builder getArrowTypeBuilder() {
      
      onChanged();
      return getArrowTypeFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     */
    public org.ballistacompute.protobuf.ArrowTypeOrBuilder getArrowTypeOrBuilder() {
      if (arrowTypeBuilder_ != null) {
        return arrowTypeBuilder_.getMessageOrBuilder();
      } else {
        return arrowType_ == null ?
            org.ballistacompute.protobuf.ArrowType.getDefaultInstance() : arrowType_;
      }
    }
    /**
     * <code>.ballista.protobuf.ArrowType arrow_type = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.ArrowType, org.ballistacompute.protobuf.ArrowType.Builder, org.ballistacompute.protobuf.ArrowTypeOrBuilder> 
        getArrowTypeFieldBuilder() {
      if (arrowTypeBuilder_ == null) {
        arrowTypeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.ArrowType, org.ballistacompute.protobuf.ArrowType.Builder, org.ballistacompute.protobuf.ArrowTypeOrBuilder>(
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.PhysicalTryCastNode)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.PhysicalTryCastNode)
  private static final org.ballistacompute.protobuf.PhysicalTryCastNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.PhysicalTryCastNode();
  }

  public static org.ballistacompute.protobuf.PhysicalTryCastNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PhysicalTryCastNode>
      PARSER = new com.google.protobuf.AbstractParser<PhysicalTryCastNode>() {
    @java.lang.Override
    public PhysicalTryCastNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PhysicalTryCastNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PhysicalTryCastNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PhysicalTryCastNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalTryCastNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

