create database if not exists muse;
use muse;
# 邮箱设置
create table if not exists email_setting
(
    id          bigint auto_increment primary key comment '主键',
    uid         bigint       not null comment '用户id',
    name        varchar(255) not null comment '邮箱名称',
    address     varchar(255) not null comment '邮箱服务器地址',
    port        varchar(24)  not null comment '邮箱服务器端口',
    account     varchar(64)  not null comment '发件人',
    username    varchar(64)  not null comment '用户名',
    password    varchar(64)  not null comment '密码',
    isSSL       tinyint      not null default 0 comment '是否开启SSL',
    isTLS       tinyint      not null default 0 comment '是否开启TLS',
    create_time timestamp             default current_timestamp not null,
    update_time timestamp             default current_timestamp not null,
    valid       tinyint      not null default 1,
    remark      varchar(255)
) engine = innodb;

# 接受者模板
create table if not exists m_receiver_template
(
    id          bigint auto_increment primary key comment '主键',
    uid         bigint  not null comment '用户id',
    name        varchar(255) not null comment '模板名称',

    template_type int not null comment '模板类型',
    receiver_type int not null comment '用户id类型',
    content   text comment '内容',

    status      int     not null default 0 comment '状态, 0为待审核',
    create_time timestamp        default current_timestamp not null,
    update_time timestamp        default current_timestamp not null,
    valid       tinyint not null default 1,
    remark      varchar(255)
) engine = innodb;

# 消息模板
create table if not exists message_template
(
    id             bigint auto_increment primary key comment '主键',
    uid            bigint       not null comment '用户id',
    name        varchar(255) not null comment '模板名称',
    content   text comment '内容',
    status         int          not null default 0 comment '状态, 0为待审核',
    create_time    timestamp             default current_timestamp not null,
    update_time    timestamp             default current_timestamp not null,
    valid          tinyint      not null default 1,
    remark         varchar(255)
) engine = innodb;

create table m_message
(
    id                   bigint auto_increment primary key comment '主键',
    uid                  bigint       not null comment '用户id',
    name                 varchar(255) not null comment '消息名称',
    type                 int          not null comment '消息类型',
    param_template_id    bigint comment '参数的模板id',
    param_json           text comment '参数的json格式',
    receiver_template_id bigint comment '接受者的模板id',
    receiver_json        text comment '接受者的json格式',
    status               int          not null default 0 comment '状态, 0待发送',
    step                 int          not null default 0 comment '处于哪一步, 默认0, 管理层,刚生成',
    create_time          timestamp             default current_timestamp not null,
    update_time          timestamp             default current_timestamp not null,
    valid                tinyint      not null default 1,
    remark               varchar(255)
) engine = innodb;
#
# # 消息发送详情
# create table m_send_detail
# (
#     id          bigint auto_increment primary key,
#     mid         bigint                              not null,
#     status      int                                 not null default 0,
#     receiver    varchar(255)                        not null,
#     create_time timestamp default current_timestamp not null,
#     update_time timestamp default current_timestamp not null,
#     remark      varchar(255)
# ) engine = innodb;
#
#
#
# create table if not exists a_user
# (
#     id          bigint auto_increment primary key comment '用户id',
#     username    varchar(64)                         not null comment '用户名',
#     password    varchar(64)                         not null comment '密码',
#     create_time timestamp default current_timestamp not null,
#     update_time timestamp default current_timestamp not null,
#     valid       tinyint   default 1
# ) engine = innodb;
#
# drop table m_template;
# create table if not exists m_template
# (
#     id               bigint auto_increment primary key comment '模板id',
#     uid              bigint                              not null comment '用户id',
#     type             int                                 not null comment '模板类型',
#     name             varchar(255)                        not null comment '模板名称',
#     send_cycle_type  int                                 not null comment '发送周期类型',
#     send_cycle       varchar(255)                        not null comment '发送周期类型',
#     receiver_id_type int                                 not null comment '接受者id类型',
#     body             text                                not null,
#     creator_name     varchar(255) comment '创建者姓名',
#     creator_phone    varchar(32) comment '创建者电话',
#     create_time      timestamp default current_timestamp not null,
#     update_time      timestamp default current_timestamp not null,
#     valid            tinyint   default 1,
#     remark           varchar(255)
# ) engine = innodb;
#
# create table if not exists m_send_account
# (
#     id          bigint auto_increment primary key comment '发送账号id',
#     username    varchar(255)                        not null comment '账号名',
#     password    varchar(255)                        not null comment '密码',
#     param       varchar(2048) comment '参数',
#     type        int                                 not null comment '账号类型',
#     uid         bigint                              not null comment '用户id',
#     create_time timestamp default current_timestamp not null,
#     update_time timestamp default current_timestamp not null,
#     valid       tinyint   default 1
# ) engine = innodb;
#
# create table if not exists m_account_type
# (
#     id        int auto_increment primary key,
#     type_id   int         not null,
#     type_name varchar(64) not null,
#     uid       bigint      not null comment '用户id'
# ) engine = innodb;


# insert into m_account_type (type_id, type_name)
# values (1, 'QQ');
# insert into m_account_type (type_id, type_name)
# values (2, '微信');
# insert into m_account_type (type_id, type_name)
# values (3, '邮箱');
# insert into m_account_type (type_id, type_name)
# values (4, 'IM');
# insert into m_account_type (type_id, type_name)
# values (5, 'Web');
# insert into m_account_type (type_id, type_name)
# values (5, 'SMS');
