// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: model/user/user_relationships_with_version.proto

package im.turms.common.model.bo.user;

public final class UserRelationshipsWithVersionOuterClass {
  private UserRelationshipsWithVersionOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_UserRelationshipsWithVersion_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_UserRelationshipsWithVersion_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n0model/user/user_relationships_with_ver" +
      "sion.proto\022\016im.turms.proto\032\036google/proto" +
      "buf/wrappers.proto\032\"model/user/user_rela" +
      "tionship.proto\"\224\001\n\034UserRelationshipsWith" +
      "Version\022<\n\022user_relationships\030\001 \003(\0132 .im" +
      ".turms.proto.UserRelationship\0226\n\021last_up" +
      "dated_date\030\002 \001(\0132\033.google.protobuf.Int64" +
      "ValueB$\n\035im.turms.common.model.bo.userP\001" +
      "\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          im.turms.common.model.bo.user.UserRelationshipOuterClass.getDescriptor(),
        });
    internal_static_im_turms_proto_UserRelationshipsWithVersion_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_UserRelationshipsWithVersion_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_UserRelationshipsWithVersion_descriptor,
        new java.lang.String[] { "UserRelationships", "LastUpdatedDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
    im.turms.common.model.bo.user.UserRelationshipOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
