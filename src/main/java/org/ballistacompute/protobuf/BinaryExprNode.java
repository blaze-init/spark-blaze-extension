// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.BinaryExprNode}
 */
public final class BinaryExprNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.BinaryExprNode)
    BinaryExprNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BinaryExprNode.newBuilder() to construct.
  private BinaryExprNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BinaryExprNode() {
    op_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BinaryExprNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BinaryExprNode(
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
            org.ballistacompute.protobuf.LogicalExprNode.Builder subBuilder = null;
            if (l_ != null) {
              subBuilder = l_.toBuilder();
            }
            l_ = input.readMessage(org.ballistacompute.protobuf.LogicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(l_);
              l_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            org.ballistacompute.protobuf.LogicalExprNode.Builder subBuilder = null;
            if (r_ != null) {
              subBuilder = r_.toBuilder();
            }
            r_ = input.readMessage(org.ballistacompute.protobuf.LogicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(r_);
              r_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            op_ = s;
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_BinaryExprNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_BinaryExprNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.BinaryExprNode.class, org.ballistacompute.protobuf.BinaryExprNode.Builder.class);
  }

  public static final int L_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.LogicalExprNode l_;
  /**
   * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
   * @return Whether the l field is set.
   */
  @java.lang.Override
  public boolean hasL() {
    return l_ != null;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
   * @return The l.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNode getL() {
    return l_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : l_;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getLOrBuilder() {
    return getL();
  }

  public static final int R_FIELD_NUMBER = 2;
  private org.ballistacompute.protobuf.LogicalExprNode r_;
  /**
   * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
   * @return Whether the r field is set.
   */
  @java.lang.Override
  public boolean hasR() {
    return r_ != null;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
   * @return The r.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNode getR() {
    return r_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : r_;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getROrBuilder() {
    return getR();
  }

  public static final int OP_FIELD_NUMBER = 3;
  private volatile java.lang.Object op_;
  /**
   * <code>string op = 3;</code>
   * @return The op.
   */
  @java.lang.Override
  public java.lang.String getOp() {
    java.lang.Object ref = op_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      op_ = s;
      return s;
    }
  }
  /**
   * <code>string op = 3;</code>
   * @return The bytes for op.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOpBytes() {
    java.lang.Object ref = op_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      op_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (l_ != null) {
      output.writeMessage(1, getL());
    }
    if (r_ != null) {
      output.writeMessage(2, getR());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(op_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, op_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (l_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getL());
    }
    if (r_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getR());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(op_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, op_);
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
    if (!(obj instanceof org.ballistacompute.protobuf.BinaryExprNode)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.BinaryExprNode other = (org.ballistacompute.protobuf.BinaryExprNode) obj;

    if (hasL() != other.hasL()) return false;
    if (hasL()) {
      if (!getL()
          .equals(other.getL())) return false;
    }
    if (hasR() != other.hasR()) return false;
    if (hasR()) {
      if (!getR()
          .equals(other.getR())) return false;
    }
    if (!getOp()
        .equals(other.getOp())) return false;
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
    if (hasL()) {
      hash = (37 * hash) + L_FIELD_NUMBER;
      hash = (53 * hash) + getL().hashCode();
    }
    if (hasR()) {
      hash = (37 * hash) + R_FIELD_NUMBER;
      hash = (53 * hash) + getR().hashCode();
    }
    hash = (37 * hash) + OP_FIELD_NUMBER;
    hash = (53 * hash) + getOp().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.BinaryExprNode parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.BinaryExprNode prototype) {
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
   * Protobuf type {@code ballista.protobuf.BinaryExprNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.BinaryExprNode)
      org.ballistacompute.protobuf.BinaryExprNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_BinaryExprNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_BinaryExprNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.BinaryExprNode.class, org.ballistacompute.protobuf.BinaryExprNode.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.BinaryExprNode.newBuilder()
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
      if (lBuilder_ == null) {
        l_ = null;
      } else {
        l_ = null;
        lBuilder_ = null;
      }
      if (rBuilder_ == null) {
        r_ = null;
      } else {
        r_ = null;
        rBuilder_ = null;
      }
      op_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_BinaryExprNode_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.BinaryExprNode getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.BinaryExprNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.BinaryExprNode build() {
      org.ballistacompute.protobuf.BinaryExprNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.BinaryExprNode buildPartial() {
      org.ballistacompute.protobuf.BinaryExprNode result = new org.ballistacompute.protobuf.BinaryExprNode(this);
      if (lBuilder_ == null) {
        result.l_ = l_;
      } else {
        result.l_ = lBuilder_.build();
      }
      if (rBuilder_ == null) {
        result.r_ = r_;
      } else {
        result.r_ = rBuilder_.build();
      }
      result.op_ = op_;
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
      if (other instanceof org.ballistacompute.protobuf.BinaryExprNode) {
        return mergeFrom((org.ballistacompute.protobuf.BinaryExprNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.BinaryExprNode other) {
      if (other == org.ballistacompute.protobuf.BinaryExprNode.getDefaultInstance()) return this;
      if (other.hasL()) {
        mergeL(other.getL());
      }
      if (other.hasR()) {
        mergeR(other.getR());
      }
      if (!other.getOp().isEmpty()) {
        op_ = other.op_;
        onChanged();
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
      org.ballistacompute.protobuf.BinaryExprNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.BinaryExprNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.ballistacompute.protobuf.LogicalExprNode l_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> lBuilder_;
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     * @return Whether the l field is set.
     */
    public boolean hasL() {
      return lBuilder_ != null || l_ != null;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     * @return The l.
     */
    public org.ballistacompute.protobuf.LogicalExprNode getL() {
      if (lBuilder_ == null) {
        return l_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : l_;
      } else {
        return lBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    public Builder setL(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (lBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        l_ = value;
        onChanged();
      } else {
        lBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    public Builder setL(
        org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (lBuilder_ == null) {
        l_ = builderForValue.build();
        onChanged();
      } else {
        lBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    public Builder mergeL(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (lBuilder_ == null) {
        if (l_ != null) {
          l_ =
            org.ballistacompute.protobuf.LogicalExprNode.newBuilder(l_).mergeFrom(value).buildPartial();
        } else {
          l_ = value;
        }
        onChanged();
      } else {
        lBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    public Builder clearL() {
      if (lBuilder_ == null) {
        l_ = null;
        onChanged();
      } else {
        l_ = null;
        lBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder getLBuilder() {
      
      onChanged();
      return getLFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getLOrBuilder() {
      if (lBuilder_ != null) {
        return lBuilder_.getMessageOrBuilder();
      } else {
        return l_ == null ?
            org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : l_;
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode l = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
        getLFieldBuilder() {
      if (lBuilder_ == null) {
        lBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder>(
                getL(),
                getParentForChildren(),
                isClean());
        l_ = null;
      }
      return lBuilder_;
    }

    private org.ballistacompute.protobuf.LogicalExprNode r_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> rBuilder_;
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     * @return Whether the r field is set.
     */
    public boolean hasR() {
      return rBuilder_ != null || r_ != null;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     * @return The r.
     */
    public org.ballistacompute.protobuf.LogicalExprNode getR() {
      if (rBuilder_ == null) {
        return r_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : r_;
      } else {
        return rBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    public Builder setR(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (rBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        r_ = value;
        onChanged();
      } else {
        rBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    public Builder setR(
        org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (rBuilder_ == null) {
        r_ = builderForValue.build();
        onChanged();
      } else {
        rBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    public Builder mergeR(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (rBuilder_ == null) {
        if (r_ != null) {
          r_ =
            org.ballistacompute.protobuf.LogicalExprNode.newBuilder(r_).mergeFrom(value).buildPartial();
        } else {
          r_ = value;
        }
        onChanged();
      } else {
        rBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    public Builder clearR() {
      if (rBuilder_ == null) {
        r_ = null;
        onChanged();
      } else {
        r_ = null;
        rBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder getRBuilder() {
      
      onChanged();
      return getRFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getROrBuilder() {
      if (rBuilder_ != null) {
        return rBuilder_.getMessageOrBuilder();
      } else {
        return r_ == null ?
            org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : r_;
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode r = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
        getRFieldBuilder() {
      if (rBuilder_ == null) {
        rBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder>(
                getR(),
                getParentForChildren(),
                isClean());
        r_ = null;
      }
      return rBuilder_;
    }

    private java.lang.Object op_ = "";
    /**
     * <code>string op = 3;</code>
     * @return The op.
     */
    public java.lang.String getOp() {
      java.lang.Object ref = op_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        op_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string op = 3;</code>
     * @return The bytes for op.
     */
    public com.google.protobuf.ByteString
        getOpBytes() {
      java.lang.Object ref = op_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        op_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string op = 3;</code>
     * @param value The op to set.
     * @return This builder for chaining.
     */
    public Builder setOp(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      op_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string op = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearOp() {
      
      op_ = getDefaultInstance().getOp();
      onChanged();
      return this;
    }
    /**
     * <code>string op = 3;</code>
     * @param value The bytes for op to set.
     * @return This builder for chaining.
     */
    public Builder setOpBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      op_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.BinaryExprNode)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.BinaryExprNode)
  private static final org.ballistacompute.protobuf.BinaryExprNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.BinaryExprNode();
  }

  public static org.ballistacompute.protobuf.BinaryExprNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BinaryExprNode>
      PARSER = new com.google.protobuf.AbstractParser<BinaryExprNode>() {
    @java.lang.Override
    public BinaryExprNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BinaryExprNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BinaryExprNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BinaryExprNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.BinaryExprNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

