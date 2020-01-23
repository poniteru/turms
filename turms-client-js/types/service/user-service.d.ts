import TurmsClient from "../turms-client";
import { im } from "../model/proto-bundle";
import { ParsedModel } from "../model/parsed-model";
import UserStatus = im.turms.proto.UserStatus;
import ProfileAccessStrategy = im.turms.proto.ProfileAccessStrategy;
import ResponseAction = im.turms.proto.ResponseAction;
import DeviceType = im.turms.proto.DeviceType;
export declare const COOKIE_REQUEST_ID = "rid";
export declare const COOKIE_USER_ID = "uid";
export declare const COOKIE_PASSWORD = "pwd";
export declare const COOKIE_USER_ONLINE_STATUS = "us";
export declare const COOKIE_DEVICE_TYPE = "dt";
export declare const COOKIE_LOCATION = "loc";
export default class UserService {
    private _turmsClient;
    private _userId?;
    private _password?;
    private _location;
    private _userOnlineStatus;
    private _deviceType;
    constructor(turmsClient: TurmsClient);
    get password(): string;
    get userId(): number;
    static getUserLocationFromBrowser(): Promise<Position>;
    login(userId: number, password: string, location?: string | Position, userOnlineStatus?: UserStatus, deviceType?: DeviceType): Promise<void>;
    relogin(): Promise<void>;
    logout(): Promise<CloseEvent>;
    updateUserOnlineStatus(onlineStatus: string | UserStatus): Promise<void>;
    updatePassword(password: string): Promise<void>;
    updateProfile(name?: string, intro?: string, profilePictureUrl?: string, profileAccessStrategy?: string | ProfileAccessStrategy): Promise<void>;
    queryUserGroupInvitations(lastUpdatedDate?: Date): Promise<ParsedModel.GroupInvitationsWithVersion>;
    queryUserProfile(userId: number, lastUpdatedDate?: Date): Promise<ParsedModel.UserInfoWithVersion>;
    queryUsersIdsNearby(latitude: number, longitude: number, distance?: number, maxNumber?: number): Promise<number[]>;
    queryUsersInfosNearby(latitude: number, longitude: number, distance?: number, maxNumber?: number): Promise<ParsedModel.UserInfo[]>;
    queryUsersOnlineStatusRequest(usersIds: number[]): Promise<ParsedModel.UserStatusDetail[]>;
    queryRelationships(relatedUsersIds?: number[], isRelatedUsers?: boolean, isBlocked?: boolean, groupIndex?: number, lastUpdatedDate?: Date): Promise<ParsedModel.UserRelationshipsWithVersion>;
    queryRelatedUsersIds(isBlocked?: boolean, groupIndex?: number, lastUpdatedDate?: Date): Promise<ParsedModel.IdsWithVersion>;
    queryFriends(groupIndex?: number, lastUpdatedDate?: Date): Promise<ParsedModel.UserRelationshipsWithVersion>;
    queryBlacklistedUsers(groupIndex?: number, lastUpdatedDate?: Date): Promise<ParsedModel.UserRelationshipsWithVersion>;
    createRelationship(userId: number, isBlocked: boolean, groupIndex?: number): Promise<void>;
    createFriendRelationship(userId: number, groupIndex?: number): Promise<void>;
    createBlacklistedUserRelationship(userId: number, groupIndex?: number): Promise<void>;
    deleteRelationship(relatedUserId: number, deleteGroupIndex?: number, targetGroupIndex?: number): Promise<void>;
    updateRelationship(relatedUserId: number, isBlocked?: boolean, groupIndex?: number): Promise<void>;
    sendFriendRequest(recipientId: number, content: string): Promise<void>;
    replyFriendRequest(requestId: number, responseAction: string | ResponseAction, reason?: string): Promise<void>;
    queryFriendRequests(lastUpdatedDate?: Date): Promise<ParsedModel.UserFriendRequestsWithVersion>;
    createRelationshipGroup(name: string): Promise<void>;
    deleteRelationshipGroups(groupIndex: number, targetGroupIndex?: number): Promise<void>;
    updateRelationshipGroup(groupIndex: number, newName: string): Promise<void>;
    queryRelationshipGroups(lastUpdatedDate?: Date): Promise<ParsedModel.UserRelationshipGroupsWithVersion>;
    moveRelatedUserToGroup(relatedUserId: number, groupIndex: number): Promise<void>;
    updateLocation(latitude: number, longitude: number, name?: string, address?: string): Promise<void>;
    private static _clearCookies;
}
