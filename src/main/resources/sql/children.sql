/**
  初始化数据库表
  建立网站相关数据库内容
  三个表，一个用于存放地点信息，一个存放用户信息，一个存放需求信息

 */

DROP DATABASE IF EXISTS `CHILDREN_DB`;
CREATE DATABASE CHILDREN_DB;
USE CHILDREN_DB;

-- 用户表

CREATE TABLE `user` (
  `uid`           int(11)      NOT NULL AUTO_INCREMENT
  COMMENT '负责人uid',
  `username`      varchar(255) NOT NULL UNIQUE,
  `password`      varchar(255) NOT NULL,
  `sex`           int(1)                DEFAULT NULL
  COMMENT '性别：0-女，1-男',
  `phone`         varchar(30)  NOT NULL,
  `email`         varchar(30)  NOT NULL,
  `register_date` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '注册时间',
  PRIMARY KEY (`uid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = UTF8MB4
  COMMENT '用户信息表';

DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `pid`         int(11)      NOT NULL AUTO_INCREMENT,
  `uid`         int(11)      NOT NULL
  COMMENT '负责人uid',
  `title`       varchar(255) NOT NULL
  COMMENT '服务点名称',
  `province`    varchar(120) NOT NULL
  COMMENT '该点所属省',
  `city`        varchar(120) NOT NULL
  COMMENT '该点所属市',
  `district`    varchar(120) NOT NULL
  COMMENT '该点所属区',
  `address`     varchar(255) NOT NULL
  COMMENT '地址',
  `lat`         varchar(255) NOT NULL
  COMMENT '纬度',
  `lng`         varchar(255) NOT NULL
  COMMENT '经度',
  `describe`    varchar(255) NOT NULL
  COMMENT '该服务点的描述',
  `state`       int(4)                DEFAULT 0
  COMMENT '审核状态：0正在审核，1通过审核，-1审核不通过',
  `detail`      varchar(255)          default ""
  COMMENT '审核说明',
  `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '申请时间',
  PRIMARY KEY (`pid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = UTF8MB4
  COMMENT '服务点表';

DROP TABLE IF EXISTS `demand`;
CREATE TABLE `demand` (
  `did`                 int(11)      NOT NULL AUTO_INCREMENT COMMENT 'UID' ,
  `pid`                 int(11)      NOT NULL
  COMMENT '发起该需求的服务点id',
  `detail`              varchar(255) NOT NULL COMMENT '需求描述，必填',
  `status`              int(4)           DEFAULT -1
  COMMENT '需求审核状态，1-通过，0-待审核, -1-不通过',
  `review_apply_detail` varchar(255)
  COMMENT '需求申请审核说明',
  `hid`                 int(11)          DEFAULT -1
  COMMENT '帮扶人id',
  `help_detail`         varchar(255) COMMENT '帮扶申请说明',
  `help_state`          int(4)                DEFAULT -2
  COMMENT '申请帮扶状态： -2： 无人申请  -1： 不通过 0：  待审核 1：  通过',
  `review_help_detail`  varchar(255)
  COMMENT '帮扶审核说明',
  `create_time`         timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '申请时间',
  PRIMARY KEY (`did`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = UTF8MB4
  COMMENT '需求信息表';

-- 需求信息初始化
INSERT INTO `demand`
VALUES ('1', '1', '需要两条被子', '0', '待审核', '-1', '', '-2', '', CURRENT_TIMESTAMP);
INSERT INTO `demand`
VALUES ('2', '3', '需要一部手机', '1', '通过', '2', '正好有资源', '0', '等待审核', CURRENT_TIMESTAMP);
INSERT INTO `demand`
VALUES ('3', '6', '需要三台电脑', '-1', '不通过', '-1', '', '-2', '', CURRENT_TIMESTAMP);
INSERT INTO `demand`
VALUES ('4', '3', '需要一位教师', '1', '通过', '4', '刚毕业，可以去帮助', '1', '符合要求', CURRENT_TIMESTAMP);
INSERT INTO `demand`
VALUES ('5', '8', '需要10000元', '1', '通过', '2', '就是有钱', '-1', '信任度不高', CURRENT_TIMESTAMP);
INSERT INTO `demand`
VALUES ('6', '2', '需要10000元', '1', '通过', '-1', '', '-2', '无人申请', CURRENT_TIMESTAMP);

SELECT *
FROM demand;

-- point 初始化
INSERT INTO `point`VALUES ('1', '2', '志新小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('2', '3', '海淀小区', '北京市', '北京市', '海淀区', 'address' ,'58.57', '12.87', '贫穷', 1, '通过', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('3', '1', '龙泉小区', '北京市', '北京市', '海淀区', 'address' ,'45.57', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('4', '7', '夏季小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('5', '2', '良心小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('6', '8', '阿萨小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('7', '3', '网络小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', -1, '未通过', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('8', '5', '破损小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`VALUES ('9', '9', '农业小区', '北京市', '北京市', '海淀区', 'address' ,'60.23', '12.87', '贫穷', 1, '通过', CURRENT_TIMESTAMP);

select *
FROM point;

-- user初始化
INSERT INTO `user`
VALUES ('1', '张三', '123456', '1', '123456789', '1@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('2', '李四', '123456', '1', '123456789', '2@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('3', '王五', '123456', '0', '123456789', '3@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('4', '老赵', '123456', '1', '123456789', '4@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('5', '小刘', '123456', '1', '123456789', '5@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('6', '老李', '123456', '0', '123456789', '6@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('7', '老徐', '123456', '1', '123456789', '7@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('8', '刘琦', '123456', '1', '123456789', '8@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('9', '顾屿', '123456', '1', '123456789', '9@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('10', '刘思', '123456', '0', '123456789', '10@qq.com', '2017-06-23 14:24:23');
INSERT INTO `user`
VALUES ('0', 'admin', 'gh123456', '0', '123456789', '10@qq.com', '2017-06-23 14:24:23');

SELECT *
FROM user;