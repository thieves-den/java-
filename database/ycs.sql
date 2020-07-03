/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : ycs

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-07-03 01:52:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auto_reply
-- ----------------------------
DROP TABLE IF EXISTS `auto_reply`;
CREATE TABLE `auto_reply` (
  `terminal` char(5) DEFAULT NULL COMMENT 'web、app,mp,weibo,wap,h5',
  `scene` varchar(255) DEFAULT NULL COMMENT 'welcome,customer_service_no_response',
  `content` varchar(255) DEFAULT NULL COMMENT '名字',
  `time_limit` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of auto_reply
-- ----------------------------

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `customer_service_id` int(11) NOT NULL COMMENT '创建客服id',
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  PRIMARY KEY (`customer_id`) USING BTREE,
  KEY `blacklist_ibfk_1` (`customer_service_id`),
  CONSTRAINT `blacklist_ibfk_1` FOREIGN KEY (`customer_service_id`) REFERENCES `customer_service` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for common_words
-- ----------------------------
DROP TABLE IF EXISTS `common_words`;
CREATE TABLE `common_words` (
  `content` varchar(255) NOT NULL COMMENT '内容',
  `lib` varchar(255) DEFAULT NULL COMMENT '库',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`content`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of common_words
-- ----------------------------

-- ----------------------------
-- Table structure for common_words_type
-- ----------------------------
DROP TABLE IF EXISTS `common_words_type`;
CREATE TABLE `common_words_type` (
  `name` varchar(255) NOT NULL COMMENT '标签名',
  `creator_id` int(11) NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of common_words_type
-- ----------------------------

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `customer_service_id` int(11) NOT NULL COMMENT '客服id',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `real_name` char(8) DEFAULT NULL COMMENT '真实姓名',
  `phone` int(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `company` varchar(255) DEFAULT NULL COMMENT '公司',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `level` int(11) DEFAULT NULL COMMENT '客户等级',
  `channel` varchar(255) DEFAULT NULL COMMENT '来源',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签',
  `lasted_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer_info
-- ----------------------------

-- ----------------------------
-- Table structure for customer_service
-- ----------------------------
DROP TABLE IF EXISTS `customer_service`;
CREATE TABLE `customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_service_id` int(11) DEFAULT NULL COMMENT '客户工号',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `online_state` enum('1','0') DEFAULT NULL COMMENT '状态：0下线，1在线',
  `work_state` enum('1','0') DEFAULT NULL COMMENT '工作状态：0禁用，1可用',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `create_time` datetime DEFAULT NULL COMMENT '创建客服时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新客服信息时间',
  `total_online_time` time DEFAULT NULL COMMENT '总计在线时长',
  `online_time_begin` datetime DEFAULT NULL COMMENT '上线时间',
  `online_time_end` datetime DEFAULT NULL COMMENT '下线时间',
  `session_count` int(11) DEFAULT NULL COMMENT '会话次数',
  `msg_count` int(11) DEFAULT NULL COMMENT '消息数',
  `service_cap` int(255) DEFAULT NULL COMMENT '服务上限',
  `customer_service_group_id` int(11) DEFAULT NULL COMMENT '客服分组',
  `role_id` int(255) DEFAULT NULL COMMENT '客服角色的id（对应role表外键）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_phone` (`phone`),
  UNIQUE KEY `Index_customer_service_id` (`customer_service_id`),
  UNIQUE KEY `Index_email` (`email`),
  KEY `coustomer_service_ibfk_1` (`customer_service_group_id`),
  KEY `customer_service_ibfk_2` (`role_id`),
  CONSTRAINT `customer_service_ibfk_1` FOREIGN KEY (`customer_service_group_id`) REFERENCES `customer_service_group` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `customer_service_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `customer_service_role` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer_service
-- ----------------------------
INSERT INTO `customer_service` VALUES ('1', null, '36435', '3333333', '1', '1', null, '126@qq.com', 'A', '1号', '2020-07-02 23:41:54', '2020-07-03 00:21:22', '23:59:59', null, null, '10', '123', '100', '1', '1');
INSERT INTO `customer_service` VALUES ('2', null, '123', '11111111', '1', '1', null, '123@qq.com', 'B', '2号', '2020-07-03 00:21:52', '2020-07-03 00:21:55', '02:21:59', null, null, '20', '123', '100', '2', '2');
INSERT INTO `customer_service` VALUES ('3', null, '132434', '22222222', '1', '1', null, '125@qq.com', 'C', '3号', '2020-07-03 00:22:15', '2020-07-03 00:22:18', '00:22:30', null, null, '30', '123', '100', '3', '3');

-- ----------------------------
-- Table structure for customer_service_group
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_group`;
CREATE TABLE `customer_service_group` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(50) NOT NULL COMMENT '客服组名称',
  `number` int(20) DEFAULT NULL COMMENT '客服成员数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='客服组';

-- ----------------------------
-- Records of customer_service_group
-- ----------------------------
INSERT INTO `customer_service_group` VALUES ('1', 'group 1', '123', null, null);
INSERT INTO `customer_service_group` VALUES ('2', 'group 2', '123', null, null);
INSERT INTO `customer_service_group` VALUES ('3', 'group 3', '123', null, null);
INSERT INTO `customer_service_group` VALUES ('4', 'group 4', '123', null, null);

-- ----------------------------
-- Table structure for customer_service_role
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_role`;
CREATE TABLE `customer_service_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_describe` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色描述',
  `number` int(11) DEFAULT '0' COMMENT '角色客户数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='客服角色表';

-- ----------------------------
-- Records of customer_service_role
-- ----------------------------
INSERT INTO `customer_service_role` VALUES ('1', 'supovisor', '客服主管', '0', '2020-06-30 17:19:04', null, null);
INSERT INTO `customer_service_role` VALUES ('2', 'administrator', '管理员', '0', '2020-06-30 17:19:15', null, null);
INSERT INTO `customer_service_role` VALUES ('3', 'super administrator', '超级管理员', '0', '2020-06-30 17:19:19', null, null);
INSERT INTO `customer_service_role` VALUES ('4', 'work order customer service', '工单客服', '0', '2020-06-30 17:19:24', null, null);
INSERT INTO `customer_service_role` VALUES ('5', 'online customer service', '在线客服', '0', '2020-06-30 17:21:29', null, null);

-- ----------------------------
-- Table structure for dialog_rule
-- ----------------------------
DROP TABLE IF EXISTS `dialog_rule`;
CREATE TABLE `dialog_rule` (
  `rule_name` varchar(255) DEFAULT NULL COMMENT '规则名',
  `time_limit` datetime DEFAULT NULL COMMENT '时间限制',
  `state` int(11) DEFAULT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dialog_rule
-- ----------------------------

-- ----------------------------
-- Table structure for enterpise
-- ----------------------------
DROP TABLE IF EXISTS `enterpise`;
CREATE TABLE `enterpise` (
  `loge` varchar(255) DEFAULT NULL COMMENT '企业logo',
  `name` varchar(255) DEFAULT NULL,
  `account` varchar(255) NOT NULL COMMENT '账户\r\n',
  `industry` varchar(255) DEFAULT NULL COMMENT '行业',
  `team_size` int(11) DEFAULT NULL COMMENT '团队规模\r\n',
  `contact_name` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `contact_phone` varchar(255) DEFAULT NULL COMMENT '联系人电话',
  `company_address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '评论',
  PRIMARY KEY (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of enterpise
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `creator_id` int(11) NOT NULL COMMENT '创建者id',
  `operate_name` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`creator_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `title` varchar(255) NOT NULL COMMENT '消息名',
  `content` varchar(255) NOT NULL COMMENT '消息内容',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`title`,`content`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `customer_service_id` int(11) NOT NULL COMMENT '客服工号',
  `visitor_ip` int(11) NOT NULL COMMENT '访客编号',
  `visitor_name` varchar(255) DEFAULT NULL COMMENT '访客名称\r\n',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `channel` char(8) DEFAULT NULL COMMENT '手动录入；即时聊天；客户管理\r\n',
  `evaluation_time` datetime DEFAULT NULL COMMENT '评价时间',
  `evaluation` varchar(255) DEFAULT NULL COMMENT '评价',
  `evaluation_detail` varchar(255) DEFAULT NULL COMMENT '评价细节',
  `first_respond_time` datetime DEFAULT NULL COMMENT '首次回复时间',
  `customer_msg_num` int(11) DEFAULT NULL,
  `customer_service_msg_mum` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_service_id`,`visitor_ip`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of session
-- ----------------------------

-- ----------------------------
-- Table structure for session_msg
-- ----------------------------
DROP TABLE IF EXISTS `session_msg`;
CREATE TABLE `session_msg` (
  `session_id` int(11) NOT NULL COMMENT '消息id',
  `msg_sender_id` int(11) NOT NULL COMMENT '发件人id',
  `msg_recevice_id` int(11) NOT NULL COMMENT '收件人id\r\n',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) DEFAULT NULL COMMENT '消息内容',
  PRIMARY KEY (`session_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of session_msg
-- ----------------------------

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `name` varchar(255) NOT NULL COMMENT '标签名',
  `tag_desc` varchar(255) DEFAULT NULL COMMENT '标签描述',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for visitor_info
-- ----------------------------
DROP TABLE IF EXISTS `visitor_info`;
CREATE TABLE `visitor_info` (
  `customer_service_id` int(11) NOT NULL COMMENT '客服id',
  `ip` varchar(255) NOT NULL COMMENT 'ip地址',
  `visitor_name` varchar(255) DEFAULT NULL COMMENT '访问者名称',
  `terminal` varchar(255) DEFAULT NULL COMMENT '访问终端',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `screen_size` varchar(255) DEFAULT NULL COMMENT '屏幕大小',
  `device` varchar(255) DEFAULT NULL COMMENT '访问设备',
  `state` int(11) DEFAULT NULL COMMENT '在线状态',
  `visit_duration` datetime DEFAULT NULL COMMENT '访客持续时间',
  PRIMARY KEY (`customer_service_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of visitor_info
-- ----------------------------

-- ----------------------------
-- Table structure for word_order
-- ----------------------------
DROP TABLE IF EXISTS `word_order`;
CREATE TABLE `word_order` (
  `work_order_id` int(11) NOT NULL COMMENT '工单id',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `order_desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `attachments` varchar(255) DEFAULT NULL COMMENT '附件',
  `cclist` varchar(255) DEFAULT NULL COMMENT '抄送人',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `customer_service_group_id` int(11) DEFAULT NULL COMMENT '客服组id',
  `customer_service_id` int(11) DEFAULT NULL COMMENT '客服id',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `channel` varchar(255) DEFAULT NULL COMMENT '即时聊天、手工录入、客户管理',
  PRIMARY KEY (`work_order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of word_order
-- ----------------------------

-- ----------------------------
-- Table structure for word_order_reply
-- ----------------------------
DROP TABLE IF EXISTS `word_order_reply`;
CREATE TABLE `word_order_reply` (
  `work_order_id` int(11) NOT NULL COMMENT '回复编号',
  `customer_service_id` int(11) DEFAULT NULL COMMENT '客服id',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `content` varchar(255) DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY (`work_order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of word_order_reply
-- ----------------------------

-- ----------------------------
-- Table structure for work_order_log
-- ----------------------------
DROP TABLE IF EXISTS `work_order_log`;
CREATE TABLE `work_order_log` (
  `customer_service_id` int(11) NOT NULL COMMENT '创建客服的id',
  `word_order_id` int(11) NOT NULL COMMENT '工单号',
  `content` varchar(255) DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`word_order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of work_order_log
-- ----------------------------
