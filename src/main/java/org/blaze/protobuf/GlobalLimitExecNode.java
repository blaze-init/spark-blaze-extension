// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/plan.proto

package org.blaze.protobuf;

/**
 * Protobuf type {@code plan.protobuf.GlobalLimitExecNode}
 */
public final class GlobalLimitExecNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:plan.protobuf.GlobalLimitExecNode)
    GlobalLimitExecNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GlobalLimitExecNode.newBuilder() to construct.
  private GlobalLimitExecNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GlobalLimitExecNode() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GlobalLimitExecNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GlobalLimitExecNode(
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
            org.blaze.protobuf.PhysicalPlanNode.Builder subBuilder = null;
            if (input_ != null) {
              subBuilder = input_.toBuilder();
            }
            input_ = input.readMessage(org.blaze.protobuf.PhysicalPlanNode.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(input_);
              input_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            limit_ = input.readUInt32();
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
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_GlobalLimitExecNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_GlobalLimitExecNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.blaze.protobuf.GlobalLimitExecNode.class, org.blaze.protobuf.GlobalLimitExecNode.Builder.class);
  }

  public static final int INPUT_FIELD_NUMBER = 1;
  private org.blaze.protobuf.PhysicalPlanNode input_;
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
   * @return Whether the input field is set.
   */
  @java.lang.Override
  public boolean hasInput() {
    return input_ != null;
  }
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
   * @return The input.
   */
  @java.lang.Override
  public org.blaze.protobuf.PhysicalPlanNode getInput() {
    return input_ == null ? org.blaze.protobuf.PhysicalPlanNode.getDefaultInstance() : input_;
  }
  /**
   * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
   */
  @java.lang.Override
  public org.blaze.protobuf.PhysicalPlanNodeOrBuilder getInputOrBuilder() {
    return getInput();
  }

  public static final int LIMIT_FIELD_NUMBER = 2;
  private int limit_;
  /**
   * <code>uint32 limit = 2;</code>
   * @return The limit.
   */
  @java.lang.Override
  public int getLimit() {
    return limit_;
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
    if (input_ != null) {
      output.writeMessage(1, getInput());
    }
    if (limit_ != 0) {
      output.writeUInt32(2, limit_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (input_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getInput());
    }
    if (limit_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, limit_);
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
    if (!(obj instanceof org.blaze.protobuf.GlobalLimitExecNode)) {
      return super.equals(obj);
    }
    org.blaze.protobuf.GlobalLimitExecNode other = (org.blaze.protobuf.GlobalLimitExecNode) obj;

    if (hasInput() != other.hasInput()) return false;
    if (hasInput()) {
      if (!getInput()
          .equals(other.getInput())) return false;
    }
    if (getLimit()
        != other.getLimit()) return false;
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
    if (hasInput()) {
      hash = (37 * hash) + INPUT_FIELD_NUMBER;
      hash = (53 * hash) + getInput().hashCode();
    }
    hash = (37 * hash) + LIMIT_FIELD_NUMBER;
    hash = (53 * hash) + getLimit();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.blaze.protobuf.GlobalLimitExecNode parseFrom(
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
  public static Builder newBuilder(org.blaze.protobuf.GlobalLimitExecNode prototype) {
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
   * Protobuf type {@code plan.protobuf.GlobalLimitExecNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:plan.protobuf.GlobalLimitExecNode)
      org.blaze.protobuf.GlobalLimitExecNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_GlobalLimitExecNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_GlobalLimitExecNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.blaze.protobuf.GlobalLimitExecNode.class, org.blaze.protobuf.GlobalLimitExecNode.Builder.class);
    }

    // Construct using org.blaze.protobuf.GlobalLimitExecNode.newBuilder()
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
      if (inputBuilder_ == null) {
        input_ = null;
      } else {
        input_ = null;
        inputBuilder_ = null;
      }
      limit_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.blaze.protobuf.BlazeProto.internal_static_plan_protobuf_GlobalLimitExecNode_descriptor;
    }

    @java.lang.Override
    public org.blaze.protobuf.GlobalLimitExecNode getDefaultInstanceForType() {
      return org.blaze.protobuf.GlobalLimitExecNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.blaze.protobuf.GlobalLimitExecNode build() {
      org.blaze.protobuf.GlobalLimitExecNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.blaze.protobuf.GlobalLimitExecNode buildPartial() {
      org.blaze.protobuf.GlobalLimitExecNode result = new org.blaze.protobuf.GlobalLimitExecNode(this);
      if (inputBuilder_ == null) {
        result.input_ = input_;
      } else {
        result.input_ = inputBuilder_.build();
      }
      result.limit_ = limit_;
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
      if (other instanceof org.blaze.protobuf.GlobalLimitExecNode) {
        return mergeFrom((org.blaze.protobuf.GlobalLimitExecNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.blaze.protobuf.GlobalLimitExecNode other) {
      if (other == org.blaze.protobuf.GlobalLimitExecNode.getDefaultInstance()) return this;
      if (other.hasInput()) {
        mergeInput(other.getInput());
      }
      if (other.getLimit() != 0) {
        setLimit(other.getLimit());
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
      org.blaze.protobuf.GlobalLimitExecNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.blaze.protobuf.GlobalLimitExecNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.blaze.protobuf.PhysicalPlanNode input_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.PhysicalPlanNode, org.blaze.protobuf.PhysicalPlanNode.Builder, org.blaze.protobuf.PhysicalPlanNodeOrBuilder> inputBuilder_;
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     * @return Whether the input field is set.
     */
    public boolean hasInput() {
      return inputBuilder_ != null || input_ != null;
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     * @return The input.
     */
    public org.blaze.protobuf.PhysicalPlanNode getInput() {
      if (inputBuilder_ == null) {
        return input_ == null ? org.blaze.protobuf.PhysicalPlanNode.getDefaultInstance() : input_;
      } else {
        return inputBuilder_.getMessage();
      }
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    public Builder setInput(org.blaze.protobuf.PhysicalPlanNode value) {
      if (inputBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        input_ = value;
        onChanged();
      } else {
        inputBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    public Builder setInput(
        org.blaze.protobuf.PhysicalPlanNode.Builder builderForValue) {
      if (inputBuilder_ == null) {
        input_ = builderForValue.build();
        onChanged();
      } else {
        inputBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    public Builder mergeInput(org.blaze.protobuf.PhysicalPlanNode value) {
      if (inputBuilder_ == null) {
        if (input_ != null) {
          input_ =
            org.blaze.protobuf.PhysicalPlanNode.newBuilder(input_).mergeFrom(value).buildPartial();
        } else {
          input_ = value;
        }
        onChanged();
      } else {
        inputBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    public Builder clearInput() {
      if (inputBuilder_ == null) {
        input_ = null;
        onChanged();
      } else {
        input_ = null;
        inputBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    public org.blaze.protobuf.PhysicalPlanNode.Builder getInputBuilder() {
      
      onChanged();
      return getInputFieldBuilder().getBuilder();
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    public org.blaze.protobuf.PhysicalPlanNodeOrBuilder getInputOrBuilder() {
      if (inputBuilder_ != null) {
        return inputBuilder_.getMessageOrBuilder();
      } else {
        return input_ == null ?
            org.blaze.protobuf.PhysicalPlanNode.getDefaultInstance() : input_;
      }
    }
    /**
     * <code>.plan.protobuf.PhysicalPlanNode input = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.blaze.protobuf.PhysicalPlanNode, org.blaze.protobuf.PhysicalPlanNode.Builder, org.blaze.protobuf.PhysicalPlanNodeOrBuilder> 
        getInputFieldBuilder() {
      if (inputBuilder_ == null) {
        inputBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.blaze.protobuf.PhysicalPlanNode, org.blaze.protobuf.PhysicalPlanNode.Builder, org.blaze.protobuf.PhysicalPlanNodeOrBuilder>(
                getInput(),
                getParentForChildren(),
                isClean());
        input_ = null;
      }
      return inputBuilder_;
    }

    private int limit_ ;
    /**
     * <code>uint32 limit = 2;</code>
     * @return The limit.
     */
    @java.lang.Override
    public int getLimit() {
      return limit_;
    }
    /**
     * <code>uint32 limit = 2;</code>
     * @param value The limit to set.
     * @return This builder for chaining.
     */
    public Builder setLimit(int value) {
      
      limit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 limit = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLimit() {
      
      limit_ = 0;
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


    // @@protoc_insertion_point(builder_scope:plan.protobuf.GlobalLimitExecNode)
  }

  // @@protoc_insertion_point(class_scope:plan.protobuf.GlobalLimitExecNode)
  private static final org.blaze.protobuf.GlobalLimitExecNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.blaze.protobuf.GlobalLimitExecNode();
  }

  public static org.blaze.protobuf.GlobalLimitExecNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GlobalLimitExecNode>
      PARSER = new com.google.protobuf.AbstractParser<GlobalLimitExecNode>() {
    @java.lang.Override
    public GlobalLimitExecNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GlobalLimitExecNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GlobalLimitExecNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GlobalLimitExecNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.blaze.protobuf.GlobalLimitExecNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

