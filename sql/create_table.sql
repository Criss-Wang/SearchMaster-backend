# 建表脚本
# @author <a href="https://github.com/liyupi">程序员鱼皮</a>
# @from <a href="https://yupi.icu">编程导航知识星球</a>

-- create table
create database if not exists my_db;

-- switch to current db
use my_db;

-- User table
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment 'Account',
    userPassword varchar(512)                           not null comment 'Password',
    unionId      varchar(256)                           null comment 'WechatId',
    mpOpenId     varchar(256)                           null comment 'openId',
    userName     varchar(256)                           null comment 'Nickname',
    userAvatar   varchar(1024)                          null comment 'Avatar',
    userProfile  varchar(512)                           null comment 'self-intro',
    userRole     varchar(256) default 'user'            not null comment 'Role: user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'Creation time',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'Update time',
    isDelete     tinyint      default 0                 not null comment 'if account is deleted',
    index idx_unionId (unionId)
) comment 'User' collate = utf8mb4_unicode_ci;

-- Post table
create table if not exists post
(
    id         bigint auto_increment comment 'id' primary key,
    title      varchar(512)                       null comment 'Title',
    content    text                               null comment 'Content',
    tags       varchar(1024)                      null comment 'Tag(json arra)',
    thumbNum   int      default 0                 not null comment 'likes',
    favourNum  int      default 0                 not null comment 'saves',
    userId     bigint                             not null comment 'created by User - id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'created at - time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    isDelete   tinyint  default 0                 not null comment 'if post is deleted',
    index idx_userId (userId)
) comment 'post' collate = utf8mb4_unicode_ci;

-- likes (hard delete)
create table if not exists post_thumb
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment 'post id',
    userId     bigint                             not null comment 'created by user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'created by time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    index idx_postId (postId),
    index idx_userId (userId)
) comment 'post likes';

-- post saves (hard delete)
create table if not exists post_favour
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment 'post id',
    userId     bigint                             not null comment 'created by user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'created time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    index idx_postId (postId),
    index idx_userId (userId)
) comment 'post saves';
