// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request/group/blacklist/query_group_blacklisted_users_ids_request.proto

package im.turms.common.model.dto.request.group.blacklist;

public final class QueryGroupBlacklistedUsersIdsRequestOuterClass {
  private QueryGroupBlacklistedUsersIdsRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_im_turms_proto_QueryGroupBlacklistedUsersIdsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_im_turms_proto_QueryGroupBlacklistedUsersIdsRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nGrequest/group/blacklist/query_group_bl" +
      "acklisted_users_ids_request.proto\022\016im.tu" +
      "rms.proto\032\036google/protobuf/wrappers.prot" +
      "o\"p\n$QueryGroupBlacklistedUsersIdsReques" +
      "t\022\020\n\010group_id\030\001 \001(\003\0226\n\021last_updated_date" +
      "\030\002 \001(\0132\033.google.protobuf.Int64ValueB8\n1i" +
      "m.turms.common.model.dto.request.group.b" +
      "lacklistP\001\272\002\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_im_turms_proto_QueryGroupBlacklistedUsersIdsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_im_turms_proto_QueryGroupBlacklistedUsersIdsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_im_turms_proto_QueryGroupBlacklistedUsersIdsRequest_descriptor,
        new java.lang.String[] { "GroupId", "LastUpdatedDate", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
