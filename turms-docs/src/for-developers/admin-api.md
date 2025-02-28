# 管理员API接口

Turms的API文档基于[Springdoc](https://github.com/springdoc/springdoc-openapi)依赖实现，并采用[OpenAPI 3.0](https://swagger.io/specification)标准。

Turms在生产环境下默认开启OpenAPI的UI与API接口，并与Admin API接口一样使用8510端口（turms-gateway没有OpenAPI接口）。如果您需要查阅API接口文档，您可以在启动turms服务端后，访问 http://localhost:8510/swagger-ui.html 查阅API接口。如果您需要API接口的JSON数据，可访问 http://localhost:8510/v3/api-docs 获取。

注意：在将Turms服务端部署到生产环境时，切记要在安全组中，将Turms的8510端口设置为“仅内网访问”，以抵御不必要的公网攻击。

## 接口设计准则

为了让接口能够顾名思义，保证开发者能一目了然，turms的管理接口设计在参考[RESTful](https://en.wikipedia.org/wiki/Representational_state_transfer)设计上做了进一步优化与统一，具体遵循以下准则：

* URL的路径部分代表目标资源（如`/users/relationships`），或是资源的表现形式（如`/users/relationships/page`表示以分页的形式返回资源。一个URI有且仅可能返回一种格式的Response）
* POST方法用于Create资源，DELETE方法用于Delete资源，PUT方法用于Update资源，GET方法用于Query资源，以及比较特殊的HEAD方法用于Check资源（类似于GET，但无Response body，仅通过HTTP状态码交互）
* 请求的Query string用于定位资源，如`?ids=1,2,3`；或是附加指令，如`?reset=true`
* 请求的Body用于描述要创建或更新的数据

## 使用管理接口的对象

* 您的前端管理系统或后端服务端发出HTTP(S)请求进行调用

* 作为内容统计管理系统与集群监控管理系统的[turms-admin](https://github.com/turms-im/turms/tree/develop/turms-admin)使用

注意：管理接口不是给终端用户使用的，而是您团队内部进行调用的。因此您通常不需要给Turms服务端开放外网IP与端口。

## 类别

### 非业务相关类

#### 管理员类

| **种类**       | **Controller**      | 路径          | **补充**                                                     |
| :------------- | :------------------ | ------------- | ------------------------------------------------------------ |
| 管理员管理     | AdminController     | /admins       | 每个Turms集群默认存在一个角色为`ROOT`，账号名与密码均为`turms`的账号 |
| 管理员角色管理 | AdminRoleController | /admins/roles | 每个Turms集群默认存在一个角色为`ROOT`的超级管理员角色，其具有所有权限 |

#### 集群类

| **种类**     | **Controller**   | 路径             |
| :----------- | :--------------- | ---------------- |
| 集群节点管理 | MemberController | /cluster/members |
| 集群配置管理 | SettingController | /cluster/settings  |

#### 黑名单类

| **种类**       | **Controller**          | 路径                   |
| :------------- | :---------------------- | ---------------------- |
| IP黑名单管理   | IpBlocklistController   | /blocked-clients/ips   |
| 用户黑名单管理 | UserBlocklistController | /blocked-clients/users |

### 业务相关类

#### 用户类

| **职责**         | **Controller**                  | 路径                                 |
| :--------------- | :------------------------------ | ------------------------------------ |
| 用户信息管理     | UserController                  | /users                               |
| 用户在线状态管理 | UserOnlineInfoController        | /users/online-infos                  |
| 用户权限组管理   | UserPermissionGroupController   | /users/permission-groups             |
| 用户关系管理     | UserRelationshipController      | /users/relationships                 |
| 用户关系组管理   | UserRelationshipGroupController | /users/relationships/groups          |
| 用户好友请求管理 | UserFriendRequestController     | /users/relationships/friend-requests |

#### 群组类

| 职责             | Controller                 | 路径                  |
| ---------------- | -------------------------- | --------------------- |
| 群组管理         | GroupController            | /groups               |
| 群组类型管理     | GroupTypeController        | /groups/types         |
| 群组入群问题管理 | GroupQuestionController    | /groups/questions     |
| 群组成员管理     | GroupMemberController      | /groups/members       |
| 群组黑名单管理   | GroupBlocklistController   | /groups/blocked-users |
| 群组邀请管理     | GroupInvitationController  | /groups/invitations   |
| 群组入群请求管理 | GroupJoinRequestController | /groups/join-requests |

#### 会话类

| 职责     | Controller             | 路径           |
| -------- | ---------------------- | -------------- |
| 会话管理 | ConversationController | /conversations |

#### 消息类

| 职责     | Controller        | 路径      |
| -------- | ----------------- | --------- |
| 消息管理 | MessageController | /messages |

## 统计

当前对外暴露的统计相关接口多为Legacy API，不推荐使用。我们会在之后对其进行调整与重构。具体原因请查阅[数据分析](https://turms-im.github.io/docs/for-developers/data-analytics.html)章节。
