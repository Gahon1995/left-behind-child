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


CREATE TABLE `point` (
  `pid`         int(11)      NOT NULL AUTO_INCREMENT,
  `uid`         int(11)      NOT NULL
  COMMENT '负责人uid',
  `vid`         int(11)      NOT NULL DEFAULT 0
  COMMENT '帮扶人id，默认0-无人帮扶',
  `title`       varchar(255) NOT NULL
  COMMENT '服务点名称',
  `address`     varchar(255) NOT NULL
  COMMENT '地址',
  `province`    varchar(120) NOT NULL
  COMMENT '该点所属省',
  `city`        varchar(120) NOT NULL
  COMMENT '该点所属市',
  `district`    varchar(120) NOT NULL
  COMMENT '该点所属区',
  `lat`         varchar(255) NOT NULL
  COMMENT '纬度',
  `lng`         varchar(255) NOT NULL
  COMMENT '经度',
  `describe`    varchar(255) NOT NULL
  COMMENT '该服务点的描述',
  `state`       int(4)                DEFAULT 0
  COMMENT '审核状态：0正在审核，1通过审核，-1审核不通过',
  `detail`      varchar(255) NOT NULL
  COMMENT '审核说明',
  `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '申请时间',
  PRIMARY KEY (`pid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = UTF8MB4
  COMMENT '服务点表';


CREATE TABLE `demand` (
  `did`    int(11)      NOT NULL AUTO_INCREMENT,
  `uid`    int(11)      NOT NULL,
  `detail` varchar(255) NOT NULL
  COMMENT '需求信息',
  PRIMARY KEY (`did`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = UTF8MB4
  COMMENT '需求信息表';

-- 需求信息初始化
INSERT INTO `demand`
VALUES ('1', '1', '需要两条被子');
INSERT INTO `demand`
VALUES ('2', '3', '需要一部手机');
INSERT INTO `demand`
VALUES ('3', '6', '需要三台电脑');
INSERT INTO `demand`
VALUES ('4', '3', '需要一位教师');
INSERT INTO `demand`
VALUES ('5', '8', '需要10000元');

SELECT *
FROM demand;

-- point 初始化
INSERT INTO `point`
VALUES ('1', '2', '0', '志新小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('2', '3', '3', '海淀小区', '', '北京市', '北京市', '海淀区', '58.57', '12.87', '贫穷', 1, '通过', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('3', '1', '5', '龙泉小区', '', '北京市', '北京市', '海淀区', '45.57', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('4', '7', '0', '夏季小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('5', '2', '0', '良心小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('6', '8', '2', '阿萨小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('7', '3', '0', '网络小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', -1, '未通过', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('8', '5', '4', '破损小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', 0, '正在审核', CURRENT_TIMESTAMP);
INSERT INTO `point`
VALUES ('9', '9', '0', '农业小区', '', '北京市', '北京市', '海淀区', '60.23', '12.87', '贫穷', 1, '通过', CURRENT_TIMESTAMP);

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

SELECT *
FROM user;