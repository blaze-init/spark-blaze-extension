// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ballista.proto

package org.ballistacompute.protobuf;

/**
 * Protobuf type {@code ballista.protobuf.ExecuteSqlParams}
 */
public final class ExecuteSqlParams extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ballista.protobuf.ExecuteSqlParams)
    ExecuteSqlParamsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExecuteSqlParams.newBuilder() to construct.
  private ExecuteSqlParams(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExecuteSqlParams() {
    sql_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExecuteSqlParams();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExecuteSqlParams(
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
            java.lang.String s = input.readStringRequireUtf8();

            sql_ = s;
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
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ExecuteSqlParams_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ExecuteSqlParams_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.ballistacompute.protobuf.ExecuteSqlParams.class, org.ballistacompute.protobuf.ExecuteSqlParams.Builder.class);
  }

  public static final int SQL_FIELD_NUMBER = 1;
  private volatile java.lang.Object sql_;
  /**
   * <code>string sql = 1;</code>
   * @return The sql.
   */
  @java.lang.Override
  public java.lang.String getSql() {
    java.lang.Object ref = sql_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sql_ = s;
      return s;
    }
  }
  /**
   * <code>string sql = 1;</code>
   * @return The bytes for sql.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSqlBytes() {
    java.lang.Object ref = sql_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sql_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(sql_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, sql_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(sql_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, sql_);
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
    if (!(obj instanceof org.ballistacompute.protobuf.ExecuteSqlParams)) {
      return super.equals(obj);
    }
    org.ballistacompute.protobuf.ExecuteSqlParams other = (org.ballistacompute.protobuf.ExecuteSqlParams) obj;

    if (!getSql()
        .equals(other.getSql())) return false;
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
    hash = (37 * hash) + SQL_FIELD_NUMBER;
    hash = (53 * hash) + getSql().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.ballistacompute.protobuf.ExecuteSqlParams parseFrom(
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
  public static Builder newBuilder(org.ballistacompute.protobuf.ExecuteSqlParams prototype) {
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
   * Protobuf type {@code ballista.protobuf.ExecuteSqlParams}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ballista.protobuf.ExecuteSqlParams)
      org.ballistacompute.protobuf.ExecuteSqlParamsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ExecuteSqlParams_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ExecuteSqlParams_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.ballistacompute.protobuf.ExecuteSqlParams.class, org.ballistacompute.protobuf.ExecuteSqlParams.Builder.class);
    }

    // Construct using org.ballistacompute.protobuf.ExecuteSqlParams.newBuilder()
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
      sql_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.ballistacompute.protobuf.BallistaProto.internal_static_ballista_protobuf_ExecuteSqlParams_descriptor;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ExecuteSqlParams getDefaultInstanceForType() {
      return org.ballistacompute.protobuf.ExecuteSqlParams.getDefaultInstance();
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ExecuteSqlParams build() {
      org.ballistacompute.protobuf.ExecuteSqlParams result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.ballistacompute.protobuf.ExecuteSqlParams buildPartial() {
      org.ballistacompute.protobuf.ExecuteSqlParams result = new org.ballistacompute.protobuf.ExecuteSqlParams(this);
      result.sql_ = sql_;
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
      if (other instanceof org.ballistacompute.protobuf.ExecuteSqlParams) {
        return mergeFrom((org.ballistacompute.protobuf.ExecuteSqlParams)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.ballistacompute.protobuf.ExecuteSqlParams other) {
      if (other == org.ballistacompute.protobuf.ExecuteSqlParams.getDefaultInstance()) return this;
      if (!other.getSql().isEmpty()) {
        sql_ = other.sql_;
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
      org.ballistacompute.protobuf.ExecuteSqlParams parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.ballistacompute.protobuf.ExecuteSqlParams) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object sql_ = "";
    /**
     * <code>string sql = 1;</code>
     * @return The sql.
     */
    public java.lang.String getSql() {
      java.lang.Object ref = sql_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sql_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string sql = 1;</code>
     * @return The bytes for sql.
     */
    public com.google.protobuf.ByteString
        getSqlBytes() {
      java.lang.Object ref = sql_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sql_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string sql = 1;</code>
     * @param value The sql to set.
     * @return This builder for chaining.
     */
    public Builder setSql(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sql_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string sql = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSql() {
      
      sql_ = getDefaultInstance().getSql();
      onChanged();
      return this;
    }
    /**
     * <code>string sql = 1;</code>
     * @param value The bytes for sql to set.
     * @return This builder for chaining.
     */
    public Builder setSqlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sql_ = value;
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


    // @@protoc_insertion_point(builder_scope:ballista.protobuf.ExecuteSqlParams)
  }

  // @@protoc_insertion_point(class_scope:ballista.protobuf.ExecuteSqlParams)
  private static final org.ballistacompute.protobuf.ExecuteSqlParams DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.ballistacompute.protobuf.ExecuteSqlParams();
  }

  public static org.ballistacompute.protobuf.ExecuteSqlParams getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExecuteSqlParams>
      PARSER = new com.google.protobuf.AbstractParser<ExecuteSqlParams>() {
    @java.lang.Override
    public ExecuteSqlParams parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExecuteSqlParams(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExecuteSqlParams> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExecuteSqlParams> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.ballistacompute.protobuf.ExecuteSqlParams getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

