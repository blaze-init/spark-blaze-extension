// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.PhysicalIsNull}
 */
public final class PhysicalIsNull extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.PhysicalIsNull)
    PhysicalIsNullOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PhysicalIsNull.newBuilder() to construct.
  private PhysicalIsNull(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PhysicalIsNull() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PhysicalIsNull();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PhysicalIsNull(
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalIsNull_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalIsNull_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.PhysicalIsNull.class, org.ballistacompute.protobuf.PhysicalIsNull.Builder.class);
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
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.ballistacompute.protobuf.PhysicalIsNull)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.PhysicalIsNull other = (org.ballistacompute.protobuf.PhysicalIsNull) obj;

    if (hasExpr() != other.hasExpr()) return false;
    if (hasExpr()) {
      if (!getExpr()
          .equals(other.getExpr())) return false;
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
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.PhysicalIsNull parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.PhysicalIsNull prototype) {
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
   * Protobuf type {@code ballista.protobuf.PhysicalIsNull}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.PhysicalIsNull)
      org.ballistacompute.protobuf.PhysicalIsNullOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalIsNull_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalIsNull_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.PhysicalIsNull.class, org.ballistacompute.protobuf.PhysicalIsNull.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.PhysicalIsNull.newBuilder()
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
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_PhysicalIsNull_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalIsNull getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.PhysicalIsNull.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalIsNull build() {
      org.ballistacompute.protobuf.PhysicalIsNull result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.PhysicalIsNull buildPartial() {
      org.ballistacompute.protobuf.PhysicalIsNull result = new org.ballistacompute.protobuf.PhysicalIsNull(this);
      if (exprBuilder_ == null) {
        result.expr_ = expr_;
      } else {
        result.expr_ = exprBuilder_.build();
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
      if (other instanceof org.ballistacompute.protobuf.PhysicalIsNull) {
        return mergeFrom((org.ballistacompute.protobuf.PhysicalIsNull)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.PhysicalIsNull other) {
      if (other == org.ballistacompute.protobuf.PhysicalIsNull.getDefaultInstance()) return this;
      if (other.hasExpr()) {
        mergeExpr(other.getExpr());
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
      org.ballistacompute.protobuf.PhysicalIsNull parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.PhysicalIsNull) e.getUnfinishedMessage();
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.PhysicalIsNull)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.PhysicalIsNull)
  private static final org.ballistacompute.protobuf.PhysicalIsNull DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.PhysicalIsNull();
  }

  public static org.ballistacompute.protobuf.PhysicalIsNull getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PhysicalIsNull>
      PARSER = new com.google.protobuf.AbstractParser<PhysicalIsNull>() {
    @java.lang.Override
    public PhysicalIsNull parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PhysicalIsNull(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PhysicalIsNull> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PhysicalIsNull> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.PhysicalIsNull getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
