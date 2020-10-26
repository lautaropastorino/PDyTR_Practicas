// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FtpService.proto

package io.grpc.ejercicio4.ftp;

/**
 * Protobuf type {@code pdytr.ejercicio4.grpc.LeerResponse}
 */
public final class LeerResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:pdytr.ejercicio4.grpc.LeerResponse)
    LeerResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LeerResponse.newBuilder() to construct.
  private LeerResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LeerResponse() {
    bytes_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new LeerResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LeerResponse(
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

            bytes_ = input.readBytes();
            break;
          }
          case 16: {

            bytesALeer_ = input.readInt32();
            break;
          }
          case 24: {

            byetsLeidos_ = input.readInt32();
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
    return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.ejercicio4.ftp.LeerResponse.class, io.grpc.ejercicio4.ftp.LeerResponse.Builder.class);
  }

  public static final int BYTES_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString bytes_;
  /**
   * <code>bytes bytes = 1;</code>
   * @return The bytes.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getBytes() {
    return bytes_;
  }

  public static final int BYTESALEER_FIELD_NUMBER = 2;
  private int bytesALeer_;
  /**
   * <code>int32 bytesALeer = 2;</code>
   * @return The bytesALeer.
   */
  @java.lang.Override
  public int getBytesALeer() {
    return bytesALeer_;
  }

  public static final int BYETSLEIDOS_FIELD_NUMBER = 3;
  private int byetsLeidos_;
  /**
   * <code>int32 byetsLeidos = 3;</code>
   * @return The byetsLeidos.
   */
  @java.lang.Override
  public int getByetsLeidos() {
    return byetsLeidos_;
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
    if (!bytes_.isEmpty()) {
      output.writeBytes(1, bytes_);
    }
    if (bytesALeer_ != 0) {
      output.writeInt32(2, bytesALeer_);
    }
    if (byetsLeidos_ != 0) {
      output.writeInt32(3, byetsLeidos_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!bytes_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, bytes_);
    }
    if (bytesALeer_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, bytesALeer_);
    }
    if (byetsLeidos_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, byetsLeidos_);
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
    if (!(obj instanceof io.grpc.ejercicio4.ftp.LeerResponse)) {
      return super.equals(obj);
    }
    io.grpc.ejercicio4.ftp.LeerResponse other = (io.grpc.ejercicio4.ftp.LeerResponse) obj;

    if (!getBytes()
        .equals(other.getBytes())) return false;
    if (getBytesALeer()
        != other.getBytesALeer()) return false;
    if (getByetsLeidos()
        != other.getByetsLeidos()) return false;
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
    hash = (37 * hash) + BYTES_FIELD_NUMBER;
    hash = (53 * hash) + getBytes().hashCode();
    hash = (37 * hash) + BYTESALEER_FIELD_NUMBER;
    hash = (53 * hash) + getBytesALeer();
    hash = (37 * hash) + BYETSLEIDOS_FIELD_NUMBER;
    hash = (53 * hash) + getByetsLeidos();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.ejercicio4.ftp.LeerResponse parseFrom(
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
  public static Builder newBuilder(io.grpc.ejercicio4.ftp.LeerResponse prototype) {
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
   * Protobuf type {@code pdytr.ejercicio4.grpc.LeerResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pdytr.ejercicio4.grpc.LeerResponse)
      io.grpc.ejercicio4.ftp.LeerResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.ejercicio4.ftp.LeerResponse.class, io.grpc.ejercicio4.ftp.LeerResponse.Builder.class);
    }

    // Construct using io.grpc.ejercicio4.ftp.LeerResponse.newBuilder()
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
      bytes_ = com.google.protobuf.ByteString.EMPTY;

      bytesALeer_ = 0;

      byetsLeidos_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.ejercicio4.ftp.FtpServiceProto.internal_static_pdytr_ejercicio4_grpc_LeerResponse_descriptor;
    }

    @java.lang.Override
    public io.grpc.ejercicio4.ftp.LeerResponse getDefaultInstanceForType() {
      return io.grpc.ejercicio4.ftp.LeerResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.ejercicio4.ftp.LeerResponse build() {
      io.grpc.ejercicio4.ftp.LeerResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.ejercicio4.ftp.LeerResponse buildPartial() {
      io.grpc.ejercicio4.ftp.LeerResponse result = new io.grpc.ejercicio4.ftp.LeerResponse(this);
      result.bytes_ = bytes_;
      result.bytesALeer_ = bytesALeer_;
      result.byetsLeidos_ = byetsLeidos_;
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
      if (other instanceof io.grpc.ejercicio4.ftp.LeerResponse) {
        return mergeFrom((io.grpc.ejercicio4.ftp.LeerResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.ejercicio4.ftp.LeerResponse other) {
      if (other == io.grpc.ejercicio4.ftp.LeerResponse.getDefaultInstance()) return this;
      if (other.getBytes() != com.google.protobuf.ByteString.EMPTY) {
        setBytes(other.getBytes());
      }
      if (other.getBytesALeer() != 0) {
        setBytesALeer(other.getBytesALeer());
      }
      if (other.getByetsLeidos() != 0) {
        setByetsLeidos(other.getByetsLeidos());
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
      io.grpc.ejercicio4.ftp.LeerResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.ejercicio4.ftp.LeerResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString bytes_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes bytes = 1;</code>
     * @return The bytes.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getBytes() {
      return bytes_;
    }
    /**
     * <code>bytes bytes = 1;</code>
     * @param value The bytes to set.
     * @return This builder for chaining.
     */
    public Builder setBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      bytes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes bytes = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBytes() {
      
      bytes_ = getDefaultInstance().getBytes();
      onChanged();
      return this;
    }

    private int bytesALeer_ ;
    /**
     * <code>int32 bytesALeer = 2;</code>
     * @return The bytesALeer.
     */
    @java.lang.Override
    public int getBytesALeer() {
      return bytesALeer_;
    }
    /**
     * <code>int32 bytesALeer = 2;</code>
     * @param value The bytesALeer to set.
     * @return This builder for chaining.
     */
    public Builder setBytesALeer(int value) {
      
      bytesALeer_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 bytesALeer = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBytesALeer() {
      
      bytesALeer_ = 0;
      onChanged();
      return this;
    }

    private int byetsLeidos_ ;
    /**
     * <code>int32 byetsLeidos = 3;</code>
     * @return The byetsLeidos.
     */
    @java.lang.Override
    public int getByetsLeidos() {
      return byetsLeidos_;
    }
    /**
     * <code>int32 byetsLeidos = 3;</code>
     * @param value The byetsLeidos to set.
     * @return This builder for chaining.
     */
    public Builder setByetsLeidos(int value) {
      
      byetsLeidos_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 byetsLeidos = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearByetsLeidos() {
      
      byetsLeidos_ = 0;
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


    // @@protoc_insertion_point(builder_scope:pdytr.ejercicio4.grpc.LeerResponse)
  }

  // @@protoc_insertion_point(class_scope:pdytr.ejercicio4.grpc.LeerResponse)
  private static final io.grpc.ejercicio4.ftp.LeerResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.ejercicio4.ftp.LeerResponse();
  }

  public static io.grpc.ejercicio4.ftp.LeerResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LeerResponse>
      PARSER = new com.google.protobuf.AbstractParser<LeerResponse>() {
    @java.lang.Override
    public LeerResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LeerResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LeerResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LeerResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.ejercicio4.ftp.LeerResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

