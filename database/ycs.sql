/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : ycs

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 30/06/2020 23:00:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auto_reply
-- ----------------------------
DROP TABLE IF EXISTS `auto_reply`;
CREATE TABLE `auto_reply`  (
  `terminal` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'web、app,mp,weibo,wap,h5',
  `scene` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'welcome,customer_service_no_response',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `time_limit` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auto_reply
-- ----------------------------

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist`  (
  `customer_service_id` int(0) NOT NULL COMMENT '创建客服id',
  `customer_id` int(0) NOT NULL COMMENT '客户id',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for common_words
-- ----------------------------
DROP TABLE IF EXISTS `common_words`;
CREATE TABLE `common_words`  (
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `lib` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `creator_id` int(0) NULL DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`content`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of common_words
-- ----------------------------

-- ----------------------------
-- Table structure for common_words_type
-- ----------------------------
DROP TABLE IF EXISTS `common_words_type`;
CREATE TABLE `common_words_type`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `creator_id` int(0) NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_words_type
-- ----------------------------

-- ----------------------------
-- Table structure for coustomer_info
-- ----------------------------
DROP TABLE IF EXISTS `coustomer_info`;
CREATE TABLE `coustomer_info`  (
  `customer_id` int(0) NOT NULL COMMENT '客户id',
  `customer_service_id` int(0) NOT NULL COMMENT '客服id',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `real_name` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` int(0) NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `level` int(0) NULL DEFAULT NULL COMMENT '客户等级',
  `channel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `lasted_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of coustomer_info
-- ----------------------------

-- ----------------------------
-- Table structure for coustomer_service
-- ----------------------------
DROP TABLE IF EXISTS `coustomer_service`;
CREATE TABLE `coustomer_service`  (
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名\r\n',
  `customer_service_id` int(0) NOT NULL COMMENT '客户工号',
  `customer_service_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客服手机号',
  `total_online_time` datetime(0) NULL DEFAULT NULL COMMENT '在线时常',
  `online_time_begin` datetime(0) NULL DEFAULT NULL COMMENT '上线时间',
  `online_time_end` datetime(0) NULL DEFAULT NULL COMMENT '下线时间',
  `session_count` int(0) NULL DEFAULT NULL COMMENT '会话次数',
  `msg_count` int(0) NULL DEFAULT NULL COMMENT '消息数',
  `customer_service_group_id` int(0) NULL DEFAULT NULL COMMENT '客服组id',
  `role` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '超级管理员、工单客户、在线客服、客户主管',
  `service_cap` int(0) NULL DEFAULT NULL COMMENT '服务上限',
  PRIMARY KEY (`customer_service_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of coustomer_service
-- ----------------------------
INSERT INTO `coustomer_service` VALUES ('15891866472', '12', 12, '12', '123@qq.com', 'abc', 'string', 12, '12', '2020-06-30 18:30:49', '2020-06-30 18:30:52', '2020-06-25 18:30:55', 12, 12, 12, '12', 12);

-- ----------------------------
-- Table structure for customer_service_group
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_group`;
CREATE TABLE `customer_service_group`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客服组名称',
  `number` int(0) NULL DEFAULT NULL COMMENT '数量',
  `customer_service_group_id` int(0) NOT NULL COMMENT '客服组id',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_service_group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_service_group
-- ----------------------------
INSERT INTO `customer_service_group` VALUES ('客服组2,测试', 2, 5, '2020-04-04 16:00:00');

-- ----------------------------
-- Table structure for customer_service_id
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_id`;
CREATE TABLE `customer_service_id`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客服角色',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `number` int(0) NULL DEFAULT NULL COMMENT '人数',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_service_id
-- ----------------------------

-- ----------------------------
-- Table structure for customer_service_role
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_role`;
CREATE TABLE `customer_service_role`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `number` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_service_role
-- ----------------------------

-- ----------------------------
-- Table structure for dialog_rule
-- ----------------------------
DROP TABLE IF EXISTS `dialog_rule`;
CREATE TABLE `dialog_rule`  (
  `rule_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则名',
  `time_limit` datetime(0) NULL DEFAULT NULL COMMENT '时间限制',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dialog_rule
-- ----------------------------

-- ----------------------------
-- Table structure for enterpise
-- ----------------------------
DROP TABLE IF EXISTS `enterpise`;
CREATE TABLE `enterpise`  (
  `loge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业logo',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户\r\n',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业',
  `team_size` int(0) NULL DEFAULT NULL COMMENT '团队规模\r\n',
  `contact_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `contact_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
  `company_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enterpise
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `creator_id` int(0) NOT NULL COMMENT '创建者id',
  `operate_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`creator_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息名',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `creator_id` int(0) NULL DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`title`, `content`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session`  (
  `customer_service_id` int(0) NOT NULL COMMENT '客服工号',
  `visitor_ip` int(0) NOT NULL COMMENT '访客编号',
  `visitor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客名称\r\n',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `channel` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手动录入；即时聊天；客户管理\r\n',
  `evaluation_time` datetime(0) NULL DEFAULT NULL COMMENT '评价时间',
  `evaluation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价',
  `evaluation_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价细节',
  `first_respond_time` datetime(0) NULL DEFAULT NULL COMMENT '首次回复时间',
  `customer_msg_num` int(0) NULL DEFAULT NULL,
  `customer_service_msg_mum` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_service_id`, `visitor_ip`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of session
-- ----------------------------

-- ----------------------------
-- Table structure for session_msg
-- ----------------------------
DROP TABLE IF EXISTS `session_msg`;
CREATE TABLE `session_msg`  (
  `session_id` int(0) NOT NULL COMMENT '消息id',
  `msg_sender_id` int(0) NOT NULL COMMENT '发件人id',
  `msg_recevice_id` int(0) NOT NULL COMMENT '收件人id\r\n',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `centent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  PRIMARY KEY (`session_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of session_msg
-- ----------------------------

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `tag_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签描述',
  `creator_id` int(0) NULL DEFAULT NULL COMMENT '创建者id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for visitor_info
-- ----------------------------
DROP TABLE IF EXISTS `visitor_info`;
CREATE TABLE `visitor_info`  (
  `customer_service_id` int(0) NOT NULL COMMENT '客服id',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip地址',
  `visitor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问者名称',
  `terminal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问终端',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `screen_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '屏幕大小',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问设备',
  `state` int(0) NULL DEFAULT NULL COMMENT '在线状态',
  `visit_duration` datetime(0) NULL DEFAULT NULL COMMENT '访客持续时间',
  PRIMARY KEY (`customer_service_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of visitor_info
-- ----------------------------

-- ----------------------------
-- Table structure for work_order
-- ----------------------------
DROP TABLE IF EXISTS `work_order`;
CREATE TABLE `work_order`  (
  `work_order_id` int(0) NOT NULL COMMENT '工单id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `order_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `attachments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件',
  `cclist` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抄送人',
  `priority` int(0) NULL DEFAULT NULL COMMENT '优先级',
  `state` int(0) NULL DEFAULT NULL COMMENT '状态',
  `customer_service_group_id` int(0) NULL DEFAULT NULL COMMENT '客服组id',
  `customer_service_id` int(0) NULL DEFAULT NULL COMMENT '客服id',
  `customer_id` int(0) NULL DEFAULT NULL COMMENT '客户id',
  `channel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '即时聊天、手工录入、客户管理',
  PRIMARY KEY (`work_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of work_order
-- ----------------------------

-- ----------------------------
-- Table structure for work_order_log
-- ----------------------------
DROP TABLE IF EXISTS `work_order_log`;
CREATE TABLE `work_order_log`  (
  `customer_service_id` int(0) NOT NULL COMMENT '创建客服的id',
  `word_order_id` int(0) NOT NULL COMMENT '工单号',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`word_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of work_order_log
-- ----------------------------

-- ----------------------------
-- Table structure for work_order_reply
-- ----------------------------
DROP TABLE IF EXISTS `work_order_reply`;
CREATE TABLE `work_order_reply`  (
  `work_order_id` int(0) NOT NULL COMMENT '回复编号',
  `customer_service_id` int(0) NULL DEFAULT NULL COMMENT '客服id',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY (`work_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of work_order_reply
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
