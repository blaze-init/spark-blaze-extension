// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.CsvScanExecNode}
 */
public final class CsvScanExecNode extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.CsvScanExecNode)
    CsvScanExecNodeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CsvScanExecNode.newBuilder() to construct.
  private CsvScanExecNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CsvScanExecNode() {
    delimiter_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CsvScanExecNode();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CsvScanExecNode(
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
            org.ballistacompute.protobuf.FileScanExecConf.Builder subBuilder = null;
            if (baseConf_ != null) {
              subBuilder = baseConf_.toBuilder();
            }
            baseConf_ = input.readMessage(org.ballistacompute.protobuf.FileScanExecConf.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(baseConf_);
              baseConf_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            hasHeader_ = input.readBool();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            delimiter_ = s;
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CsvScanExecNode_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CsvScanExecNode_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.CsvScanExecNode.class, org.ballistacompute.protobuf.CsvScanExecNode.Builder.class);
  }

  public static final int BASE_CONF_FIELD_NUMBER = 1;
  private org.ballistacompute.protobuf.FileScanExecConf baseConf_;
  /**
   * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
   * @return Whether the baseConf field is set.
   */
  @java.lang.Override
  public boolean hasBaseConf() {
    return baseConf_ != null;
  }
  /**
   * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
   * @return The baseConf.
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.FileScanExecConf getBaseConf() {
    return baseConf_ == null ? org.ballistacompute.protobuf.FileScanExecConf.getDefaultInstance() : baseConf_;
  }
  /**
   * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
   */
  @java.lang.Override
  public org.ballistacompute.protobuf.FileScanExecConfOrBuilder getBaseConfOrBuilder() {
    return getBaseConf();
  }

  public static final int HAS_HEADER_FIELD_NUMBER = 2;
  private boolean hasHeader_;
  /**
   * <code>bool has_header = 2;</code>
   * @return The hasHeader.
   */
  @java.lang.Override
  public boolean getHasHeader() {
    return hasHeader_;
  }

  public static final int DELIMITER_FIELD_NUMBER = 3;
  private volatile java.lang.Object delimiter_;
  /**
   * <code>string delimiter = 3;</code>
   * @return The delimiter.
   */
  @java.lang.Override
  public java.lang.String getDelimiter() {
    java.lang.Object ref = delimiter_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      delimiter_ = s;
      return s;
    }
  }
  /**
   * <code>string delimiter = 3;</code>
   * @return The bytes for delimiter.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDelimiterBytes() {
    java.lang.Object ref = delimiter_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      delimiter_ = b;
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
    if (baseConf_ != null) {
      output.writeMessage(1, getBaseConf());
    }
    if (hasHeader_ != false) {
      output.writeBool(2, hasHeader_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(delimiter_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, delimiter_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (baseConf_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getBaseConf());
    }
    if (hasHeader_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, hasHeader_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(delimiter_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, delimiter_);
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
    if (!(obj instanceof org.ballistacompute.protobuf.CsvScanExecNode)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.CsvScanExecNode other = (org.ballistacompute.protobuf.CsvScanExecNode) obj;

    if (hasBaseConf() != other.hasBaseConf()) return false;
    if (hasBaseConf()) {
      if (!getBaseConf()
          .equals(other.getBaseConf())) return false;
    }
    if (getHasHeader()
        != other.getHasHeader()) return false;
    if (!getDelimiter()
        .equals(other.getDelimiter())) return false;
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
    if (hasBaseConf()) {
      hash = (37 * hash) + BASE_CONF_FIELD_NUMBER;
      hash = (53 * hash) + getBaseConf().hashCode();
    }
    hash = (37 * hash) + HAS_HEADER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getHasHeader());
    hash = (37 * hash) + DELIMITER_FIELD_NUMBER;
    hash = (53 * hash) + getDelimiter().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.CsvScanExecNode parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.CsvScanExecNode prototype) {
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
   * Protobuf type {@code ballista.protobuf.CsvScanExecNode}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.CsvScanExecNode)
      org.ballistacompute.protobuf.CsvScanExecNodeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CsvScanExecNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CsvScanExecNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.CsvScanExecNode.class, org.ballistacompute.protobuf.CsvScanExecNode.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.CsvScanExecNode.newBuilder()
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
      if (baseConfBuilder_ == null) {
        baseConf_ = null;
      } else {
        baseConf_ = null;
        baseConfBuilder_ = null;
      }
      hasHeader_ = false;

      delimiter_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_CsvScanExecNode_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.CsvScanExecNode getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.CsvScanExecNode.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.CsvScanExecNode build() {
      org.ballistacompute.protobuf.CsvScanExecNode result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.CsvScanExecNode buildPartial() {
      org.ballistacompute.protobuf.CsvScanExecNode result = new org.ballistacompute.protobuf.CsvScanExecNode(this);
      if (baseConfBuilder_ == null) {
        result.baseConf_ = baseConf_;
      } else {
        result.baseConf_ = baseConfBuilder_.build();
      }
      result.hasHeader_ = hasHeader_;
      result.delimiter_ = delimiter_;
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
      if (other instanceof org.ballistacompute.protobuf.CsvScanExecNode) {
        return mergeFrom((org.ballistacompute.protobuf.CsvScanExecNode)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.CsvScanExecNode other) {
      if (other == org.ballistacompute.protobuf.CsvScanExecNode.getDefaultInstance()) return this;
      if (other.hasBaseConf()) {
        mergeBaseConf(other.getBaseConf());
      }
      if (other.getHasHeader() != false) {
        setHasHeader(other.getHasHeader());
      }
      if (!other.getDelimiter().isEmpty()) {
        delimiter_ = other.delimiter_;
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
      org.ballistacompute.protobuf.CsvScanExecNode parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.CsvScanExecNode) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private org.ballistacompute.protobuf.FileScanExecConf baseConf_;
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.FileScanExecConf, org.ballistacompute.protobuf.FileScanExecConf.Builder, org.ballistacompute.protobuf.FileScanExecConfOrBuilder> baseConfBuilder_;
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     * @return Whether the baseConf field is set.
     */
    public boolean hasBaseConf() {
      return baseConfBuilder_ != null || baseConf_ != null;
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     * @return The baseConf.
     */
    public org.ballistacompute.protobuf.FileScanExecConf getBaseConf() {
      if (baseConfBuilder_ == null) {
        return baseConf_ == null ? org.ballistacompute.protobuf.FileScanExecConf.getDefaultInstance() : baseConf_;
      } else {
        return baseConfBuilder_.getMessage();
      }
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    public Builder setBaseConf(org.ballistacompute.protobuf.FileScanExecConf value) {
      if (baseConfBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        baseConf_ = value;
        onChanged();
      } else {
        baseConfBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    public Builder setBaseConf(
        org.ballistacompute.protobuf.FileScanExecConf.Builder builderForValue) {
      if (baseConfBuilder_ == null) {
        baseConf_ = builderForValue.build();
        onChanged();
      } else {
        baseConfBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    public Builder mergeBaseConf(org.ballistacompute.protobuf.FileScanExecConf value) {
      if (baseConfBuilder_ == null) {
        if (baseConf_ != null) {
          baseConf_ =
            org.ballistacompute.protobuf.FileScanExecConf.newBuilder(baseConf_).mergeFrom(value).buildPartial();
        } else {
          baseConf_ = value;
        }
        onChanged();
      } else {
        baseConfBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    public Builder clearBaseConf() {
      if (baseConfBuilder_ == null) {
        baseConf_ = null;
        onChanged();
      } else {
        baseConf_ = null;
        baseConfBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    public org.ballistacompute.protobuf.FileScanExecConf.Builder getBaseConfBuilder() {
      
      onChanged();
      return getBaseConfFieldBuilder().getBuilder();
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    public org.ballistacompute.protobuf.FileScanExecConfOrBuilder getBaseConfOrBuilder() {
      if (baseConfBuilder_ != null) {
        return baseConfBuilder_.getMessageOrBuilder();
      } else {
        return baseConf_ == null ?
            org.ballistacompute.protobuf.FileScanExecConf.getDefaultInstance() : baseConf_;
      }
    }
    /**
     * <code>.ballista.protobuf.FileScanExecConf base_conf = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        org.ballistacompute.protobuf.FileScanExecConf, org.ballistacompute.protobuf.FileScanExecConf.Builder, org.ballistacompute.protobuf.FileScanExecConfOrBuilder> 
        getBaseConfFieldBuilder() {
      if (baseConfBuilder_ == null) {
        baseConfBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            org.ballistacompute.protobuf.FileScanExecConf, org.ballistacompute.protobuf.FileScanExecConf.Builder, org.ballistacompute.protobuf.FileScanExecConfOrBuilder>(
                getBaseConf(),
                getParentForChildren(),
                isClean());
        baseConf_ = null;
      }
      return baseConfBuilder_;
    }

    private boolean hasHeader_ ;
    /**
     * <code>bool has_header = 2;</code>
     * @return The hasHeader.
     */
    @java.lang.Override
    public boolean getHasHeader() {
      return hasHeader_;
    }
    /**
     * <code>bool has_header = 2;</code>
     * @param value The hasHeader to set.
     * @return This builder for chaining.
     */
    public Builder setHasHeader(boolean value) {
      
      hasHeader_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool has_header = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearHasHeader() {
      
      hasHeader_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object delimiter_ = "";
    /**
     * <code>string delimiter = 3;</code>
     * @return The delimiter.
     */
    public java.lang.String getDelimiter() {
      java.lang.Object ref = delimiter_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        delimiter_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string delimiter = 3;</code>
     * @return The bytes for delimiter.
     */
    public com.google.protobuf.ByteString
        getDelimiterBytes() {
      java.lang.Object ref = delimiter_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        delimiter_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string delimiter = 3;</code>
     * @param value The delimiter to set.
     * @return This builder for chaining.
     */
    public Builder setDelimiter(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      delimiter_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string delimiter = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDelimiter() {
      
      delimiter_ = getDefaultInstance().getDelimiter();
      onChanged();
      return this;
    }
    /**
     * <code>string delimiter = 3;</code>
     * @param value The bytes for delimiter to set.
     * @return This builder for chaining.
     */
    public Builder setDelimiterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      delimiter_ = value;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.CsvScanExecNode)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.CsvScanExecNode)
  private static final org.ballistacompute.protobuf.CsvScanExecNode DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.CsvScanExecNode();
  }

  public static org.ballistacompute.protobuf.CsvScanExecNode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CsvScanExecNode>
      PARSER = new com.google.protobuf.AbstractParser<CsvScanExecNode>() {
    @java.lang.Override
    public CsvScanExecNode parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CsvScanExecNode(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CsvScanExecNode> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CsvScanExecNode> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.CsvScanExecNode getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
