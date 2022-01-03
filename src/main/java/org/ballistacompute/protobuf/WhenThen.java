// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.WhenThen}
 */
public final class WhenThen extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.WhenThen)
    WhenThenOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WhenThen.newBuilder() to construct.
  private WhenThen(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WhenThen() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WhenThen();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private WhenThen(
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
            if (whenExpr_ != null) {
              subBuilder = whenExpr_.toBuilder();
            }
            whenExpr_ = input.readMessage(org.ballistacompute.protobuf.LogicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(whenExpr_);
              whenExpr_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            org.ballistacompute.protobuf.LogicalExprNode.Builder subBuilder = null;
            if (thenExpr_ != null) {
              subBuilder = thenExpr_.toBuilder();
            }
            thenExpr_ = input.readMessage(org.ballistacompute.protobuf.LogicalExprNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(thenExpr_);
              thenExpr_ = subBuilder.buildPartial();
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_WhenThen_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_WhenThen_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.WhenThen.class, org.ballistacompute.protobuf.WhenThen.Builder.class);
  }

  public static final int WHEN_EXPR_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.LogicalExprNode whenExpr_;
  /**
   * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
   * @return Whether the whenExpr field is set.
   */
  @java.lang.Override
  public boolean hasWhenExpr() {
    return whenExpr_ != null;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
   * @return The whenExpr.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNode getWhenExpr() {
    return whenExpr_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : whenExpr_;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getWhenExprOrBuilder() {
    return getWhenExpr();
  }

  public static final int THEN_EXPR_FIELD_NUMBER = 2;
  private org.ballistacompute.protobuf.LogicalExprNode thenExpr_;
  /**
   * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
   * @return Whether the thenExpr field is set.
   */
  @java.lang.Override
  public boolean hasThenExpr() {
    return thenExpr_ != null;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
   * @return The thenExpr.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNode getThenExpr() {
    return thenExpr_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : thenExpr_;
  }
  /**
   * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getThenExprOrBuilder() {
    return getThenExpr();
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
    if (whenExpr_ != null) {
      output.writeMessage(1, getWhenExpr());
    }
    if (thenExpr_ != null) {
      output.writeMessage(2, getThenExpr());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (whenExpr_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getWhenExpr());
    }
    if (thenExpr_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getThenExpr());
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
    if (!(obj instanceof org.ballistacompute.protobuf.WhenThen)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.WhenThen other = (org.ballistacompute.protobuf.WhenThen) obj;

    if (hasWhenExpr() != other.hasWhenExpr()) return false;
    if (hasWhenExpr()) {
      if (!getWhenExpr()
          .equals(other.getWhenExpr())) return false;
    }
    if (hasThenExpr() != other.hasThenExpr()) return false;
    if (hasThenExpr()) {
      if (!getThenExpr()
          .equals(other.getThenExpr())) return false;
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
    if (hasWhenExpr()) {
      hash = (37 * hash) + WHEN_EXPR_FIELD_NUMBER;
      hash = (53 * hash) + getWhenExpr().hashCode();
    }
    if (hasThenExpr()) {
      hash = (37 * hash) + THEN_EXPR_FIELD_NUMBER;
      hash = (53 * hash) + getThenExpr().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.WhenThen parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.WhenThen parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.WhenThen parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.WhenThen prototype) {
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
   * Protobuf type {@code ballista.protobuf.WhenThen}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.WhenThen)
      org.ballistacompute.protobuf.WhenThenOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_WhenThen_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_WhenThen_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.WhenThen.class, org.ballistacompute.protobuf.WhenThen.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.WhenThen.newBuilder()
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
      if (whenExprBuilder_ == null) {
        whenExpr_ = null;
      } else {
        whenExpr_ = null;
        whenExprBuilder_ = null;
      }
      if (thenExprBuilder_ == null) {
        thenExpr_ = null;
      } else {
        thenExpr_ = null;
        thenExprBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_WhenThen_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.WhenThen getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.WhenThen.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.WhenThen build() {
      org.ballistacompute.protobuf.WhenThen result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.WhenThen buildPartial() {
      org.ballistacompute.protobuf.WhenThen result = new org.ballistacompute.protobuf.WhenThen(this);
      if (whenExprBuilder_ == null) {
        result.whenExpr_ = whenExpr_;
      } else {
        result.whenExpr_ = whenExprBuilder_.build();
      }
      if (thenExprBuilder_ == null) {
        result.thenExpr_ = thenExpr_;
      } else {
        result.thenExpr_ = thenExprBuilder_.build();
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
      if (other instanceof org.ballistacompute.protobuf.WhenThen) {
        return mergeFrom((org.ballistacompute.protobuf.WhenThen)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.WhenThen other) {
      if (other == org.ballistacompute.protobuf.WhenThen.getDefaultInstance()) return this;
      if (other.hasWhenExpr()) {
        mergeWhenExpr(other.getWhenExpr());
      }
      if (other.hasThenExpr()) {
        mergeThenExpr(other.getThenExpr());
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
      org.ballistacompute.protobuf.WhenThen parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.WhenThen) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.ballistacompute.protobuf.LogicalExprNode whenExpr_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> whenExprBuilder_;
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     * @return Whether the whenExpr field is set.
     */
    public boolean hasWhenExpr() {
      return whenExprBuilder_ != null || whenExpr_ != null;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     * @return The whenExpr.
     */
    public org.ballistacompute.protobuf.LogicalExprNode getWhenExpr() {
      if (whenExprBuilder_ == null) {
        return whenExpr_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : whenExpr_;
      } else {
        return whenExprBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    public Builder setWhenExpr(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (whenExprBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        whenExpr_ = value;
        onChanged();
      } else {
        whenExprBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    public Builder setWhenExpr(
        org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (whenExprBuilder_ == null) {
        whenExpr_ = builderForValue.build();
        onChanged();
      } else {
        whenExprBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    public Builder mergeWhenExpr(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (whenExprBuilder_ == null) {
        if (whenExpr_ != null) {
          whenExpr_ =
            org.ballistacompute.protobuf.LogicalExprNode.newBuilder(whenExpr_).mergeFrom(value).buildPartial();
        } else {
          whenExpr_ = value;
        }
        onChanged();
      } else {
        whenExprBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    public Builder clearWhenExpr() {
      if (whenExprBuilder_ == null) {
        whenExpr_ = null;
        onChanged();
      } else {
        whenExpr_ = null;
        whenExprBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder getWhenExprBuilder() {
      
      onChanged();
      return getWhenExprFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getWhenExprOrBuilder() {
      if (whenExprBuilder_ != null) {
        return whenExprBuilder_.getMessageOrBuilder();
      } else {
        return whenExpr_ == null ?
            org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : whenExpr_;
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode when_expr = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
        getWhenExprFieldBuilder() {
      if (whenExprBuilder_ == null) {
        whenExprBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder>(
                getWhenExpr(),
                getParentForChildren(),
                isClean());
        whenExpr_ = null;
      }
      return whenExprBuilder_;
    }

    private org.ballistacompute.protobuf.LogicalExprNode thenExpr_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> thenExprBuilder_;
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     * @return Whether the thenExpr field is set.
     */
    public boolean hasThenExpr() {
      return thenExprBuilder_ != null || thenExpr_ != null;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     * @return The thenExpr.
     */
    public org.ballistacompute.protobuf.LogicalExprNode getThenExpr() {
      if (thenExprBuilder_ == null) {
        return thenExpr_ == null ? org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : thenExpr_;
      } else {
        return thenExprBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    public Builder setThenExpr(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (thenExprBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        thenExpr_ = value;
        onChanged();
      } else {
        thenExprBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    public Builder setThenExpr(
        org.ballistacompute.protobuf.LogicalExprNode.Builder builderForValue) {
      if (thenExprBuilder_ == null) {
        thenExpr_ = builderForValue.build();
        onChanged();
      } else {
        thenExprBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    public Builder mergeThenExpr(org.ballistacompute.protobuf.LogicalExprNode value) {
      if (thenExprBuilder_ == null) {
        if (thenExpr_ != null) {
          thenExpr_ =
            org.ballistacompute.protobuf.LogicalExprNode.newBuilder(thenExpr_).mergeFrom(value).buildPartial();
        } else {
          thenExpr_ = value;
        }
        onChanged();
      } else {
        thenExprBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    public Builder clearThenExpr() {
      if (thenExprBuilder_ == null) {
        thenExpr_ = null;
        onChanged();
      } else {
        thenExpr_ = null;
        thenExprBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNode.Builder getThenExprBuilder() {
      
      onChanged();
      return getThenExprFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    public org.ballistacompute.protobuf.LogicalExprNodeOrBuilder getThenExprOrBuilder() {
      if (thenExprBuilder_ != null) {
        return thenExprBuilder_.getMessageOrBuilder();
      } else {
        return thenExpr_ == null ?
            org.ballistacompute.protobuf.LogicalExprNode.getDefaultInstance() : thenExpr_;
      }
    }
    /**
     * <code>.ballista.protobuf.LogicalExprNode then_expr = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder> 
        getThenExprFieldBuilder() {
      if (thenExprBuilder_ == null) {
        thenExprBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.LogicalExprNode, org.ballistacompute.protobuf.LogicalExprNode.Builder, org.ballistacompute.protobuf.LogicalExprNodeOrBuilder>(
                getThenExpr(),
                getParentForChildren(),
                isClean());
        thenExpr_ = null;
      }
      return thenExprBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.WhenThen)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.WhenThen)
  private static final org.ballistacompute.protobuf.WhenThen DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.WhenThen();
  }

  public static org.ballistacompute.protobuf.WhenThen getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WhenThen>
      PARSER = new com.google.protobuf.AbstractParser<WhenThen>() {
    @java.lang.Override
    public WhenThen parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new WhenThen(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WhenThen> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WhenThen> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.WhenThen getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

