package com.toxind.benchmark.thrid.proto1;
//// Generated by the protocol buffer compiler.  DO NOT EDIT!
//// source: demo.proto
//
//package com.taobao.ethon.thrid.proto1;
//
//public final class Bean {
//  private Bean() {}
//  public static void registerAllExtensions(
//      com.google.protobuf.ExtensionRegistry registry) {
//  }
//  public interface ObjOrBuilder
//      extends com.google.protobuf.MessageOrBuilder {
//    
//    // optional string name = 1;
//    boolean hasName();
//    String getName();
//    
//    // optional int32 id = 2;
//    boolean hasId();
//    int getId();
//  }
//  public static final class Obj extends
//      com.google.protobuf.GeneratedMessage
//      implements ObjOrBuilder {
//    // Use Obj.newBuilder() to construct.
//    private Obj(Builder builder) {
//      super(builder);
//    }
//    private Obj(boolean noInit) {}
//    
//    private static final Obj defaultInstance;
//    public static Obj getDefaultInstance() {
//      return defaultInstance;
//    }
//    
//    public Obj getDefaultInstanceForType() {
//      return defaultInstance;
//    }
//    
//    public static final com.google.protobuf.Descriptors.Descriptor
//        getDescriptor() {
//      return com.proto.Bean.internal_static_tutorial_Obj_descriptor;
//    }
//    
//    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
//        internalGetFieldAccessorTable() {
//      return com.proto.Bean.internal_static_tutorial_Obj_fieldAccessorTable;
//    }
//    
//    private int bitField0_;
//    // optional string name = 1;
//    public static final int NAME_FIELD_NUMBER = 1;
//    private java.lang.Object name_;
//    public boolean hasName() {
//      return ((bitField0_ & 0x00000001) == 0x00000001);
//    }
//    public String getName() {
//      java.lang.Object ref = name_;
//      if (ref instanceof String) {
//        return (String) ref;
//      } else {
//        com.google.protobuf.ByteString bs = 
//            (com.google.protobuf.ByteString) ref;
//        String s = bs.toStringUtf8();
//        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
//          name_ = s;
//        }
//        return s;
//      }
//    }
//    private com.google.protobuf.ByteString getNameBytes() {
//      java.lang.Object ref = name_;
//      if (ref instanceof String) {
//        com.google.protobuf.ByteString b = 
//            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
//        name_ = b;
//        return b;
//      } else {
//        return (com.google.protobuf.ByteString) ref;
//      }
//    }
//    
//    // optional int32 id = 2;
//    public static final int ID_FIELD_NUMBER = 2;
//    private int id_;
//    public boolean hasId() {
//      return ((bitField0_ & 0x00000002) == 0x00000002);
//    }
//    public int getId() {
//      return id_;
//    }
//    
//    private void initFields() {
//      name_ = "";
//      id_ = 0;
//    }
//    private byte memoizedIsInitialized = -1;
//    public final boolean isInitialized() {
//      byte isInitialized = memoizedIsInitialized;
//      if (isInitialized != -1) return isInitialized == 1;
//      
//      memoizedIsInitialized = 1;
//      return true;
//    }
//    
//    public void writeTo(com.google.protobuf.CodedOutputStream output)
//                        throws java.io.IOException {
//      getSerializedSize();
//      if (((bitField0_ & 0x00000001) == 0x00000001)) {
//        output.writeBytes(1, getNameBytes());
//      }
//      if (((bitField0_ & 0x00000002) == 0x00000002)) {
//        output.writeInt32(2, id_);
//      }
//      getUnknownFields().writeTo(output);
//    }
//    
//    private int memoizedSerializedSize = -1;
//    public int getSerializedSize() {
//      int size = memoizedSerializedSize;
//      if (size != -1) return size;
//    
//      size = 0;
//      if (((bitField0_ & 0x00000001) == 0x00000001)) {
//        size += com.google.protobuf.CodedOutputStream
//          .computeBytesSize(1, getNameBytes());
//      }
//      if (((bitField0_ & 0x00000002) == 0x00000002)) {
//        size += com.google.protobuf.CodedOutputStream
//          .computeInt32Size(2, id_);
//      }
//      size += getUnknownFields().getSerializedSize();
//      memoizedSerializedSize = size;
//      return size;
//    }
//    
//    private static final long serialVersionUID = 0L;
//    @java.lang.Override
//    protected java.lang.Object writeReplace()
//        throws java.io.ObjectStreamException {
//      return super.writeReplace();
//    }
//    
//    public static com.proto.Bean.Obj parseFrom(
//        com.google.protobuf.ByteString data)
//        throws com.google.protobuf.InvalidProtocolBufferException {
//      return newBuilder().mergeFrom(data).buildParsed();
//    }
//    public static com.proto.Bean.Obj parseFrom(
//        com.google.protobuf.ByteString data,
//        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
//        throws com.google.protobuf.InvalidProtocolBufferException {
//      return newBuilder().mergeFrom(data, extensionRegistry)
//               .buildParsed();
//    }
//    public static com.proto.Bean.Obj parseFrom(byte[] data)
//        throws com.google.protobuf.InvalidProtocolBufferException {
//      return newBuilder().mergeFrom(data).buildParsed();
//    }
//    public static com.proto.Bean.Obj parseFrom(
//        byte[] data,
//        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
//        throws com.google.protobuf.InvalidProtocolBufferException {
//      return newBuilder().mergeFrom(data, extensionRegistry)
//               .buildParsed();
//    }
//    public static com.proto.Bean.Obj parseFrom(java.io.InputStream input)
//        throws java.io.IOException {
//      return newBuilder().mergeFrom(input).buildParsed();
//    }
//    public static com.proto.Bean.Obj parseFrom(
//        java.io.InputStream input,
//        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
//        throws java.io.IOException {
//      return newBuilder().mergeFrom(input, extensionRegistry)
//               .buildParsed();
//    }
//    public static com.proto.Bean.Obj parseDelimitedFrom(java.io.InputStream input)
//        throws java.io.IOException {
//      Builder builder = newBuilder();
//      if (builder.mergeDelimitedFrom(input)) {
//        return builder.buildParsed();
//      } else {
//        return null;
//      }
//    }
//    public static com.proto.Bean.Obj parseDelimitedFrom(
//        java.io.InputStream input,
//        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
//        throws java.io.IOException {
//      Builder builder = newBuilder();
//      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
//        return builder.buildParsed();
//      } else {
//        return null;
//      }
//    }
//    public static com.proto.Bean.Obj parseFrom(
//        com.google.protobuf.CodedInputStream input)
//        throws java.io.IOException {
//      return newBuilder().mergeFrom(input).buildParsed();
//    }
//    public static com.proto.Bean.Obj parseFrom(
//        com.google.protobuf.CodedInputStream input,
//        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
//        throws java.io.IOException {
//      return newBuilder().mergeFrom(input, extensionRegistry)
//               .buildParsed();
//    }
//    
//    public static Builder newBuilder() { return Builder.create(); }
//    public Builder newBuilderForType() { return newBuilder(); }
//    public static Builder newBuilder(com.proto.Bean.Obj prototype) {
//      return newBuilder().mergeFrom(prototype);
//    }
//    public Builder toBuilder() { return newBuilder(this); }
//    
//    @java.lang.Override
//    protected Builder newBuilderForType(
//        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
//      Builder builder = new Builder(parent);
//      return builder;
//    }
//    public static final class Builder extends
//        com.google.protobuf.GeneratedMessage.Builder<Builder>
//       implements com.proto.Bean.ObjOrBuilder {
//      public static final com.google.protobuf.Descriptors.Descriptor
//          getDescriptor() {
//        return com.proto.Bean.internal_static_tutorial_Obj_descriptor;
//      }
//      
//      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
//          internalGetFieldAccessorTable() {
//        return com.proto.Bean.internal_static_tutorial_Obj_fieldAccessorTable;
//      }
//      
//      // Construct using com.proto.Bean.Obj.newBuilder()
//      private Builder() {
//        maybeForceBuilderInitialization();
//      }
//      
//      private Builder(BuilderParent parent) {
//        super(parent);
//        maybeForceBuilderInitialization();
//      }
//      private void maybeForceBuilderInitialization() {
//        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
//        }
//      }
//      private static Builder create() {
//        return new Builder();
//      }
//      
//      public Builder clear() {
//        super.clear();
//        name_ = "";
//        bitField0_ = (bitField0_ & ~0x00000001);
//        id_ = 0;
//        bitField0_ = (bitField0_ & ~0x00000002);
//        return this;
//      }
//      
//      public Builder clone() {
//        return create().mergeFrom(buildPartial());
//      }
//      
//      public com.google.protobuf.Descriptors.Descriptor
//          getDescriptorForType() {
//        return com.proto.Bean.Obj.getDescriptor();
//      }
//      
//      public com.proto.Bean.Obj getDefaultInstanceForType() {
//        return com.proto.Bean.Obj.getDefaultInstance();
//      }
//      
//      public com.proto.Bean.Obj build() {
//        com.proto.Bean.Obj result = buildPartial();
//        if (!result.isInitialized()) {
//          throw newUninitializedMessageException(result);
//        }
//        return result;
//      }
//      
//      private com.proto.Bean.Obj buildParsed()
//          throws com.google.protobuf.InvalidProtocolBufferException {
//        com.proto.Bean.Obj result = buildPartial();
//        if (!result.isInitialized()) {
//          throw newUninitializedMessageException(
//            result).asInvalidProtocolBufferException();
//        }
//        return result;
//      }
//      
//      public com.proto.Bean.Obj buildPartial() {
//        com.proto.Bean.Obj result = new com.proto.Bean.Obj(this);
//        int from_bitField0_ = bitField0_;
//        int to_bitField0_ = 0;
//        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
//          to_bitField0_ |= 0x00000001;
//        }
//        result.name_ = name_;
//        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
//          to_bitField0_ |= 0x00000002;
//        }
//        result.id_ = id_;
//        result.bitField0_ = to_bitField0_;
//        onBuilt();
//        return result;
//      }
//      
//      public Builder mergeFrom(com.google.protobuf.Message other) {
//        if (other instanceof com.proto.Bean.Obj) {
//          return mergeFrom((com.proto.Bean.Obj)other);
//        } else {
//          super.mergeFrom(other);
//          return this;
//        }
//      }
//      
//      public Builder mergeFrom(com.proto.Bean.Obj other) {
//        if (other == com.proto.Bean.Obj.getDefaultInstance()) return this;
//        if (other.hasName()) {
//          setName(other.getName());
//        }
//        if (other.hasId()) {
//          setId(other.getId());
//        }
//        this.mergeUnknownFields(other.getUnknownFields());
//        return this;
//      }
//      
//      public final boolean isInitialized() {
//        return true;
//      }
//      
//      public Builder mergeFrom(
//          com.google.protobuf.CodedInputStream input,
//          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
//          throws java.io.IOException {
//        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
//          com.google.protobuf.UnknownFieldSet.newBuilder(
//            this.getUnknownFields());
//        while (true) {
//          int tag = input.readTag();
//          switch (tag) {
//            case 0:
//              this.setUnknownFields(unknownFields.build());
//              onChanged();
//              return this;
//            default: {
//              if (!parseUnknownField(input, unknownFields,
//                                     extensionRegistry, tag)) {
//                this.setUnknownFields(unknownFields.build());
//                onChanged();
//                return this;
//              }
//              break;
//            }
//            case 10: {
//              bitField0_ |= 0x00000001;
//              name_ = input.readBytes();
//              break;
//            }
//            case 16: {
//              bitField0_ |= 0x00000002;
//              id_ = input.readInt32();
//              break;
//            }
//          }
//        }
//      }
//      
//      private int bitField0_;
//      
//      // optional string name = 1;
//      private java.lang.Object name_ = "";
//      public boolean hasName() {
//        return ((bitField0_ & 0x00000001) == 0x00000001);
//      }
//      public String getName() {
//        java.lang.Object ref = name_;
//        if (!(ref instanceof String)) {
//          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
//          name_ = s;
//          return s;
//        } else {
//          return (String) ref;
//        }
//      }
//      public Builder setName(String value) {
//        if (value == null) {
//    throw new NullPointerException();
//  }
//  bitField0_ |= 0x00000001;
//        name_ = value;
//        onChanged();
//        return this;
//      }
//      public Builder clearName() {
//        bitField0_ = (bitField0_ & ~0x00000001);
//        name_ = getDefaultInstance().getName();
//        onChanged();
//        return this;
//      }
//      void setName(com.google.protobuf.ByteString value) {
//        bitField0_ |= 0x00000001;
//        name_ = value;
//        onChanged();
//      }
//      
//      // optional int32 id = 2;
//      private int id_ ;
//      public boolean hasId() {
//        return ((bitField0_ & 0x00000002) == 0x00000002);
//      }
//      public int getId() {
//        return id_;
//      }
//      public Builder setId(int value) {
//        bitField0_ |= 0x00000002;
//        id_ = value;
//        onChanged();
//        return this;
//      }
//      public Builder clearId() {
//        bitField0_ = (bitField0_ & ~0x00000002);
//        id_ = 0;
//        onChanged();
//        return this;
//      }
//      
//      // @@protoc_insertion_point(builder_scope:tutorial.Obj)
//    }
//    
//    static {
//      defaultInstance = new Obj(true);
//      defaultInstance.initFields();
//    }
//    
//    // @@protoc_insertion_point(class_scope:tutorial.Obj)
//  }
//  
//  private static com.google.protobuf.Descriptors.Descriptor
//    internal_static_tutorial_Obj_descriptor;
//  private static
//    com.google.protobuf.GeneratedMessage.FieldAccessorTable
//      internal_static_tutorial_Obj_fieldAccessorTable;
//  
//  public static com.google.protobuf.Descriptors.FileDescriptor
//      getDescriptor() {
//    return descriptor;
//  }
//  private static com.google.protobuf.Descriptors.FileDescriptor
//      descriptor;
//  static {
//    java.lang.String[] descriptorData = {
//      "\n\ndemo.proto\022\010tutorial\"\037\n\003Obj\022\014\n\004name\030\001 " +
//      "\001(\t\022\n\n\002id\030\002 \001(\005B\021\n\tcom.protoB\004Bean"
//    };
//    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
//      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
//        public com.google.protobuf.ExtensionRegistry assignDescriptors(
//            com.google.protobuf.Descriptors.FileDescriptor root) {
//          descriptor = root;
//          internal_static_tutorial_Obj_descriptor =
//            getDescriptor().getMessageTypes().get(0);
//          internal_static_tutorial_Obj_fieldAccessorTable = new
//            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
//              internal_static_tutorial_Obj_descriptor,
//              new java.lang.String[] { "Name", "Id", },
//              com.proto.Bean.Obj.class,
//              com.proto.Bean.Obj.Builder.class);
//          return null;
//        }
//      };
//    com.google.protobuf.Descriptors.FileDescriptor
//      .internalBuildGeneratedFileFrom(descriptorData,
//        new com.google.protobuf.Descriptors.FileDescriptor[] {
//        }, assigner);
//  }
//  
//  // @@protoc_insertion_point(outer_class_scope)
//}
