/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : ycs

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-07-12 18:37:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auto_reply`
-- ----------------------------
DROP TABLE IF EXISTS `auto_reply`;
CREATE TABLE `auto_reply` (
  `customer_service_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动回复创建者的客服id',
  `terminal` char(5) NOT NULL COMMENT '终端类型：web、app,mp,weibo,wap,h5',
  `welcome` varchar(255) DEFAULT NULL COMMENT '欢迎消息',
  `customer_service_no_response` varchar(255) DEFAULT NULL COMMENT '客服无应答消息',
  `customer_service_time_limit` time DEFAULT NULL COMMENT '客服无响应时间限制',
  `customer_no_response` varchar(255) DEFAULT NULL COMMENT '顾客无响应回复',
  `customer_time_limit` time DEFAULT NULL COMMENT '顾客无响应时间限制',
  `customer_service_end` varchar(255) DEFAULT NULL COMMENT '客服手动结束回复内容',
  `system_end` varchar(255) DEFAULT NULL COMMENT '系统自动结束回复内容',
  PRIMARY KEY (`customer_service_id`,`terminal`),
  CONSTRAINT `自动回复-客服id` FOREIGN KEY (`customer_service_id`) REFERENCES `customer_service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自动回复';

-- ----------------------------
-- Records of auto_reply
-- ----------------------------
INSERT INTO `auto_reply` VALUES ('1', '微信小程序', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('1', '微博', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('1', '手机app', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('1', '手机站', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('1', '网页端', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('2', '微信小程序', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('2', '微博', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('2', '手机app', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('2', '手机站', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');
INSERT INTO `auto_reply` VALUES ('2', '网页端', '你好', '请稍等', '00:00:20', '在吗', '00:00:20', '再见', '对话已被系统关闭，再见！');

-- ----------------------------
-- Table structure for `blacklist`
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `customer_service_id` int(11) NOT NULL COMMENT '创建客服id',
  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`,`customer_service_id`),
  KEY `blacklist_ibfk_1` (`customer_service_id`),
  CONSTRAINT `blacklist_ibfk_1` FOREIGN KEY (`customer_service_id`) REFERENCES `customer_service` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of blacklist
-- ----------------------------
INSERT INTO `blacklist` VALUES ('1', '1', 'Dadadad', null);
INSERT INTO `blacklist` VALUES ('1', '11', '骂人', '2020-07-11 11:01:58');
INSERT INTO `blacklist` VALUES ('3', '4', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('5', '5', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('6', '6', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('7', '5', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('8', '6', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('9', '4', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('10', '3', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('11', '4', '骂人', '2020-07-23 11:03:45');
INSERT INTO `blacklist` VALUES ('12', '2', '辱骂客服', null);
INSERT INTO `blacklist` VALUES ('12', '12', '法沙发沙发', null);

-- ----------------------------
-- Table structure for `common_words`
-- ----------------------------
DROP TABLE IF EXISTS `common_words`;
CREATE TABLE `common_words` (
  `creator_id` int(11) NOT NULL COMMENT '创建者id',
  `is_personal` int(1) NOT NULL COMMENT '库',
  `type` varchar(255) NOT NULL COMMENT '类型',
  `content` varchar(255) NOT NULL COMMENT '内容',
  PRIMARY KEY (`content`,`is_personal`,`type`,`creator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='常用语';

-- ----------------------------
-- Records of common_words
-- ----------------------------
INSERT INTO `common_words` VALUES ('12', '1', '欢迎语', '你好');
INSERT INTO `common_words` VALUES ('1', '1', '再见语', '再见');
INSERT INTO `common_words` VALUES ('12', '1', '再见语', '再见');
INSERT INTO `common_words` VALUES ('1', '1', '感谢语', '谢谢');
INSERT INTO `common_words` VALUES ('12', '1', '感谢语', '谢谢');

-- ----------------------------
-- Table structure for `common_words_type`
-- ----------------------------
DROP TABLE IF EXISTS `common_words_type`;
CREATE TABLE `common_words_type` (
  `name` varchar(255) NOT NULL COMMENT '标签名',
  `creator_id` int(11) NOT NULL COMMENT '创建者id',
  `is_personal` int(1) NOT NULL,
  PRIMARY KEY (`name`,`creator_id`,`is_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='常用语类型';

-- ----------------------------
-- Records of common_words_type
-- ----------------------------
INSERT INTO `common_words_type` VALUES ('再见语', '12', '1');

-- ----------------------------
-- Table structure for `customer_info`
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `customer_service_id` int(11) NOT NULL COMMENT '客服id',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `real_name` char(8) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `company` varchar(255) DEFAULT NULL COMMENT '公司',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `level` varchar(11) DEFAULT NULL COMMENT '客户等级',
  `channel` varchar(255) DEFAULT NULL COMMENT '来源',
  `remark` varchar(255) DEFAULT NULL COMMENT '客户备注',
  `tags` varchar(255) DEFAULT NULL COMMENT '客户标签',
  `create_time` datetime DEFAULT NULL COMMENT '客户创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '客户更新时间',
  `lasted_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`customer_id`) USING BTREE,
  KEY `客服id` (`customer_service_id`),
  CONSTRAINT `客服id` FOREIGN KEY (`customer_service_id`) REFERENCES `customer_service` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='顾客信息';

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('1', '1', '小小', '晓晓', '100001', '1@qq.com', '华泰集团', '北京市一环1号', 'vip客户', 'Mac', '第一位客户', '已上市', '2020-07-03 18:46:38', '2020-07-09 18:46:51', '2020-07-10 18:46:58');
INSERT INTO `customer_info` VALUES ('2', '1', '大大', '达答', '100002', '2@qq.com', '鼎盛企业', '北京市一环2号', 'vip客户', 'Mac', '第二位客户', '已上市', '2020-07-06 18:47:08', '2020-07-08 18:47:22', '2020-07-09 18:47:26');
INSERT INTO `customer_info` VALUES ('3', '2', '北京市客户', '王伟', '100003', '3@qq.com', '王伟企业', '北京市一环3号', 'vip客户', 'Mac', '第3位客户', '已上市', '2020-07-07 18:48:51', '2020-07-08 18:49:04', '2020-07-10 18:49:08');
INSERT INTO `customer_info` VALUES ('4', '2', '河南省客户', '李丽', '100004', '4@qq.com', '小夜传媒', '北京市一环4号', 'vip客户', 'Mac', '第4位客户', '已上市', '2020-07-10 18:51:06', '2020-07-10 18:51:10', '2020-07-10 18:51:18');
INSERT INTO `customer_info` VALUES ('5', '1', '小张', '张悟', '100005', '5@qq.com', '张悟企业', '北京市一环5号', 'vip客户', 'Mac', '第5位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('6', '2', '小伟', '李伟', '100006', '6@qq.com', '李伟企业', '北京市一环6号', 'vip客户', 'Mac', '第6位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('7', '4', '小四', '田四', '100007', '7@qq.com', '田四企业', '北京市一环7号', 'vip客户', 'Mac', '第7位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('8', '5', '小李', '李三', '100008', '8@qq.com', '李三企业', '北京市一环8号', 'vip客户', 'Mac', '第8位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('9', '6', '小万', '李万', '100009', '9@qq.com', '李万企业', '北京市一环9号', 'vip客户', 'Mac', '第9位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('10', '7', '小田', '田天', '1000010', '10@qq.com', '田天企业', '北京市一环10号', 'vip客户', 'Mac', '第10位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('11', '8', '万里', '彭万里', '1000011', '11@qq.com', '万里企业', '北京市一环11号', 'vip客户', 'Mac', '第11位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('12', '9', '大山', '高大山', '1000012', '12@qq.com', '大山企业', '北京市一环12号', 'vip客户', 'Mac', '第12位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('13', '10', '大海', '谢大海', '1000013', '13@qq.com', '大海企业', '北京市一环13号', 'vip客户', 'Mac', '第13位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('14', '11', '宏宇', '马宏宇', '1000014', '14@qq.com', '宏宇企业', '北京市一环14号', 'vip客户', 'Mac', '第14位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('15', '12', '莽', '林莽', '1000015', '15@qq.com', '林莽企业', '北京市一环15号', 'vip客户', 'Mac', '第15位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('16', '4', '强辉', '黄强辉', '1000016', '16@qq.com', '强辉企业', '北京市一环16号', 'vip客户', 'Mac', '第16位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('17', '6', '汉夫', '章汉夫', '1000017', '17@qq.com', '汉夫企业', '北京市一环17号', 'vip客户', 'Mac', '第17位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');
INSERT INTO `customer_info` VALUES ('18', '9', '长江', '范长江', '1000018', '18@qq.com', '长江企业', '北京市一环18号', 'vip客户', 'Mac', '第18位客户', '已上市', '2020-07-07 18:48:51', '2020-07-07 18:48:51', '2020-07-07 18:48:51');

-- ----------------------------
-- Table structure for `customer_service`
-- ----------------------------
DROP TABLE IF EXISTS `customer_service`;
CREATE TABLE `customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_service_id` int(11) DEFAULT NULL COMMENT '客户工号',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `online_state` varchar(255) DEFAULT NULL COMMENT '在线状态',
  `work_state` int(11) DEFAULT NULL COMMENT '工作状态：0禁用，1可用',
  `head_img` mediumblob COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `create_time` datetime DEFAULT NULL COMMENT '创建客服时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新客服信息时间',
  `total_online_time` time DEFAULT NULL COMMENT '总计在线时长',
  `average_response_time` time DEFAULT NULL COMMENT '平均响应时长',
  `average_session_time` time DEFAULT NULL COMMENT '平均会话时长',
  `online_time_begin` datetime DEFAULT NULL COMMENT '上线时间',
  `online_time_end` datetime DEFAULT NULL COMMENT '下线时间',
  `session_count` int(11) DEFAULT NULL COMMENT '会话次数',
  `msg_count` int(11) DEFAULT NULL COMMENT '消息数',
  `service_cap` int(255) DEFAULT NULL COMMENT '服务上限',
  `customer_service_group_id` int(11) DEFAULT NULL COMMENT '客服分组',
  `role_id` int(255) DEFAULT NULL COMMENT '客服角色的id（对应role表外键）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_phone` (`phone`),
  UNIQUE KEY `Index_email` (`email`),
  KEY `coustomer_service_ibfk_1` (`customer_service_group_id`),
  KEY `customer_service_ibfk_2` (`role_id`),
  CONSTRAINT `customer_service_ibfk_1` FOREIGN KEY (`customer_service_group_id`) REFERENCES `customer_service_group` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `customer_service_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `customer_service_role` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客服信息表';

-- ----------------------------
-- Records of customer_service
-- ----------------------------
INSERT INTO `customer_service` VALUES ('1', '1', '123456', '3333333', '在线', '1', null, '126@qq.com', '唐果', '水蜜桃', '2020-07-02 23:41:54', '2020-07-03 00:21:22', '23:59:59', '00:00:10', '00:08:48', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '10', '123', '10000', '1', '1');
INSERT INTO `customer_service` VALUES ('2', '2', '12345', '111111', '离线', '0', null, '124@qq.com', '林感', '小林哥', '2020-07-03 00:21:52', '2020-07-03 00:21:55', '02:21:59', '00:00:09', '00:13:22', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '20', '123', '10000', '3', '4');
INSERT INTO `customer_service` VALUES ('3', '3', '132434', '22222222', '在线', '1', null, '125@qq.com', '索瑞萨', '史蒂夫索', '2020-07-03 00:22:15', '2020-07-03 00:22:18', '00:22:30', '00:00:08', '00:02:18', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '30', '123', '10000', '3', '3');
INSERT INTO `customer_service` VALUES ('4', '4', '999999', '123456', '在线', '1', null, '324@qq.com', '副丽鱼', '鱼儿', '2020-07-05 14:14:40', '2020-07-05 14:18:47', '04:14:49', '00:00:06', '00:18:20', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '13', '34', '10000', '4', '4');
INSERT INTO `customer_service` VALUES ('5', '5', '1314520', 'hhh', '在线', '1', null, '1232@qq.com', '李一桐', '桐儿', '2020-07-05 15:23:38', '2020-07-05 14:24:20', '09:24:24', '00:00:13', '00:03:08', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '33', '209', '10000', '2', '3');
INSERT INTO `customer_service` VALUES ('6', '6', '138238', 'wxhn', '离线', '1', null, '1qwr@qq.com', '张云雷', '张师傅', '2020-07-05 14:25:31', '2020-07-05 17:25:28', '10:25:21', '00:00:12', '00:06:42', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '43', '343', '10000', '2', '1');
INSERT INTO `customer_service` VALUES ('7', '7', '8888', '21453', '在线', '1', null, '463@qq.com', '范丞丞', '小范师兄', '2020-07-05 14:28:37', '2020-07-05 16:28:42', '15:28:49', '00:00:11', '00:11:56', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '65', '245', '10000', '3', '5');
INSERT INTO `customer_service` VALUES ('8', '8', '20201314', '54gfd', '在线', '1', null, '232323@qq.com', '杨洋', '羊羊', '2020-07-05 07:30:14', '2020-07-05 14:30:10', '08:30:05', '00:00:04', '00:09:38', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '60', '234', '10000', '4', '2');
INSERT INTO `customer_service` VALUES ('9', '9', '112233', 'niceofyou', '在线', '1', null, '1818@qq.com', '柳岩', '柳姐', '2020-07-05 10:34:26', '2020-07-05 16:25:39', '12:34:51', '00:00:17', '00:18:43', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '99', '666', '10000', '1', '3');
INSERT INTO `customer_service` VALUES ('10', '10', '1332', 'how123', '在线', '1', null, '287@qq.com', '周杰伦', '杰伦哥', '2020-07-05 16:48:09', '2020-07-05 16:48:20', '06:48:24', '00:00:20', '00:23:09', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '23', '266', '10000', '2', '1');
INSERT INTO `customer_service` VALUES ('11', '11', '234552', 'sodf2', '离线', '0', null, '2321@qq.com', '黄圣依', '依姐', '2020-07-05 16:49:53', '2020-07-05 16:49:56', '08:49:37', '00:00:16', '00:05:46', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '66', '243', '10000', '1', '2');
INSERT INTO `customer_service` VALUES ('12', '12', '18860', 'woaini', '在线', '1', null, 'tiantian@qq.com', '李子柒', '子柒', '2020-07-05 16:52:36', '2020-07-05 16:52:40', '16:52:42', '00:00:13', '00:02:59', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '88', '345', '10000', '1', '4');
INSERT INTO `customer_service` VALUES ('13', '13', '13388', '123456', '在线', '1', null, '168@qq.com', '尼格买提', '小尼哥', '2020-07-08 21:20:30', '2020-07-09 21:20:39', '15:22:35', '00:00:05', '00:06:50', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '34', '324', '10000', '4', '1');
INSERT INTO `customer_service` VALUES ('14', '14', '13572', 'qwerasdf', '在线', '1', null, 'rti2@qq.com', '林心如', '小林姐', '2020-07-03 21:20:45', '2020-07-06 21:20:52', '14:27:47', '00:00:09', '00:15:48', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '99', '666', '10000', '3', '5');
INSERT INTO `customer_service` VALUES ('15', '15', '12223', 'qweasd', '在线', '1', null, '13243@qq.com', '杨国福', '国服', '2020-07-09 21:23:09', '2020-07-10 21:23:14', '06:23:17', '00:00:19', '00:22:28', '2020-07-10 15:03:29', '2020-07-11 16:03:29', '23', '233', '10000', '1', '2');

-- ----------------------------
-- Table structure for `customer_service_group`
-- ----------------------------
DROP TABLE IF EXISTS `customer_service_group`;
CREATE TABLE `customer_service_group` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '客服组名称',
  `number` int(20) DEFAULT NULL COMMENT '客服成员数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='客服组';

-- ----------------------------
-- Records of customer_service_group
-- ----------------------------
INSERT INTO `customer_service_group` VALUES ('1', '客服一组', '12', '2020-07-03 05:18:37', '2020-07-08 17:19:40');
INSERT INTO `customer_service_group` VALUES ('2', '客服二组', '10', '2020-07-04 14:18:45', '2020-07-08 17:19:44');
INSERT INTO `customer_service_group` VALUES ('3', '客服三组', '23', '2020-07-05 19:25:56', '2020-07-08 17:19:48');
INSERT INTO `customer_service_group` VALUES ('4', '客服四组', '42', '2020-07-06 06:19:36', '2020-07-08 17:19:52');
INSERT INTO `customer_service_group` VALUES ('5', '客服五组', '35', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('6', '客服六组', '6', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('7', '客服七组', '64', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('8', '客服八组', '46', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('9', '客服九组', '3', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('10', '客服十组', '543', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('11', '客服十一组', '645', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('12', '客服十二组', '6', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('13', '客服十三组', '7', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('14', '客服十四组', '45', '2020-07-08 09:16:42', '2020-07-08 17:19:56');
INSERT INTO `customer_service_group` VALUES ('15', '客服十五组', '74', '2020-07-08 09:16:42', '2020-07-08 17:19:56');

-- ----------------------------
-- Table structure for `customer_service_role`
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
INSERT INTO `customer_service_role` VALUES ('1', 'supovisor', '客服主管', '2', '2020-06-30 17:19:04', '2020-07-08 17:19:14', null);
INSERT INTO `customer_service_role` VALUES ('2', 'administrator', '管理员', '3', '2020-06-30 17:19:15', '2020-07-08 17:19:19', null);
INSERT INTO `customer_service_role` VALUES ('3', 'super administrator', '超级管理员', '4', '2020-06-30 17:19:19', '2020-07-08 17:19:22', null);
INSERT INTO `customer_service_role` VALUES ('4', 'work order customer service', '工单客服', '5', '2020-06-30 17:19:24', '2020-07-08 17:19:28', null);
INSERT INTO `customer_service_role` VALUES ('5', 'online customer service', '在线客服', '6', '2020-06-30 17:21:29', '2020-07-08 17:19:32', null);

-- ----------------------------
-- Table structure for `dialog_rule`
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
-- Table structure for `enterpise`
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
INSERT INTO `enterpise` VALUES ('', '七尾云科技有限公司', '1339000@163.com', '教育', '98', '杜宇', '17789067899', '北京市', '备注信息');

-- ----------------------------
-- Table structure for `log`
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
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `title` varchar(255) NOT NULL COMMENT '消息名',
  `content` varchar(255) NOT NULL COMMENT '消息内容',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`title`,`content`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('产品上新通知', '10号产品将于9号上线', '6', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '11号产品将于9号上线', '4', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '12号产品将于9号上线', '6', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '13号产品将于9号上线', '2', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '14号产品将于9号上线', '2', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '15号产品将于9号上线', '2', '2020-07-11 11:46:55');
INSERT INTO `notice` VALUES ('产品上新通知', '16号产品将于9号上线', '4', '2020-07-07 11:46:51');
INSERT INTO `notice` VALUES ('产品上新通知', '17号产品将于9号上线', '1', '2020-07-11 11:46:59');
INSERT INTO `notice` VALUES ('产品上新通知', '1号产品将于9号上线', '4', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '2号产品将于9号上线', '6', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '3号产品将于9号上线', '8', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '4号产品将于9号上线', '9', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '5号产品将于9号上线', '3', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '6号产品将于9号上线', '4', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '7号产品将于9号上线', '4', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '8号产品将于9号上线', '7', '2020-07-24 11:40:06');
INSERT INTO `notice` VALUES ('产品上新通知', '9号产品将于9号上线', '5', '2020-07-24 11:40:06');

-- ----------------------------
-- Table structure for `session`
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `customer_service_id` int(11) NOT NULL COMMENT '客服工号',
  `visitor_ip` varchar(255) NOT NULL COMMENT '访客编号',
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
  PRIMARY KEY (`customer_service_id`,`visitor_ip`) USING BTREE,
  KEY `会话-访客ip` (`visitor_ip`),
  CONSTRAINT `会话-客服id` FOREIGN KEY (`customer_service_id`) REFERENCES `customer_service` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `会话-访客ip` FOREIGN KEY (`visitor_ip`) REFERENCES `visitor_info` (`ip`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES ('1', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:45:28', null, null, null, null, null, '1', null);
INSERT INTO `session` VALUES ('1', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:09:58', null, null, null, null, null, '53', null);
INSERT INTO `session` VALUES ('1', '198.40.3', null, '2020-07-11 22:13:57', '2020-07-11 22:26:57', null, null, null, null, null, null, null);
INSERT INTO `session` VALUES ('2', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:34:28', null, null, null, null, null, '16', null);
INSERT INTO `session` VALUES ('2', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:10:42', null, null, null, null, null, '53', null);
INSERT INTO `session` VALUES ('3', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:47:28', null, null, null, null, null, '14', null);
INSERT INTO `session` VALUES ('3', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:09:49', null, null, null, null, null, '4', null);
INSERT INTO `session` VALUES ('4', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:44:28', null, null, null, null, null, '24', null);
INSERT INTO `session` VALUES ('4', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:49:42', null, null, null, null, null, '1', null);
INSERT INTO `session` VALUES ('5', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:24:28', null, null, null, null, null, '26', null);
INSERT INTO `session` VALUES ('5', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:39:42', null, null, null, null, null, '2', null);
INSERT INTO `session` VALUES ('6', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:53:28', null, null, null, null, null, '26', null);
INSERT INTO `session` VALUES ('6', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:29:42', null, null, null, null, null, '4', null);
INSERT INTO `session` VALUES ('7', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:33:48', null, null, null, null, null, '47', null);
INSERT INTO `session` VALUES ('7', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:09:51', null, null, null, null, null, '53', null);
INSERT INTO `session` VALUES ('8', '198.40.1', null, '2020-07-11 21:33:28', '2020-07-11 21:36:28', null, null, null, null, null, '58', null);
INSERT INTO `session` VALUES ('8', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:10:42', null, null, null, null, null, '53', null);
INSERT INTO `session` VALUES ('9', '198.40.2', null, '2020-07-11 22:09:42', '2020-07-11 22:19:42', null, null, null, null, null, '23', null);

-- ----------------------------
-- Table structure for `session_msg`
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
-- Table structure for `tags`
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
-- Table structure for `visitor_info`
-- ----------------------------
DROP TABLE IF EXISTS `visitor_info`;
CREATE TABLE `visitor_info` (
  `ip` varchar(255) NOT NULL COMMENT 'ip地址',
  `customer_service_id` int(11) NOT NULL COMMENT '客服id',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '访客昵称',
  `visitor_name` varchar(255) DEFAULT NULL COMMENT '访问者名称',
  `terminal` varchar(255) DEFAULT NULL COMMENT '访客终端',
  `browser` varchar(255) DEFAULT NULL COMMENT '访客浏览器',
  `screen_size` varchar(255) DEFAULT NULL COMMENT '屏幕大小',
  `device` varchar(255) DEFAULT NULL COMMENT '访问设备',
  `state` int(11) DEFAULT NULL COMMENT '在线状态',
  `visit_duration` time DEFAULT NULL COMMENT '访客持续时间',
  `begin_time` datetime DEFAULT NULL COMMENT '访问开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '访问结束时间',
  `visit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ip`),
  KEY `访客-客服id` (`customer_service_id`),
  CONSTRAINT `访客-客服id` FOREIGN KEY (`customer_service_id`) REFERENCES `customer_service` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of visitor_info
-- ----------------------------
INSERT INTO `visitor_info` VALUES ('198.40.1', '2', '君雄', '林君雄', '浏览器', 'Firefox', '15.6寸', '笔记本', '0', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.10', '3', '平山', '谭平山', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.2', '3', '希亮', '朱希亮', '浏览器', 'Firefox', '14寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.202', '1', '水蜜桃', '小香香', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.3', '4', '四光', '李四光', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.4', '5', '铁生', '甘铁生', '浏览器', 'Firefox', '15.6寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.5', '6', '绍祖', '张伍绍祖', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.6', '2', '继祖', '马继祖', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.7', '8', '孝先', '程孝先', '浏览器', 'Firefox', '14寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.8', '4', '敬先', '宗敬先', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:32', '2020-07-12 17:29:50');
INSERT INTO `visitor_info` VALUES ('198.40.9', '1', '广嗣', '年广嗣', '浏览器', 'Firefox', '18寸', '笔记本', '1', '00:21:36', '2020-07-12 17:29:12', '2020-07-12 17:29:50', '2020-07-12 17:29:50');

-- ----------------------------
-- Table structure for `word_order_reply`
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
-- Table structure for `work_order`
-- ----------------------------
DROP TABLE IF EXISTS `work_order`;
CREATE TABLE `work_order` (
  `work_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工单id',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `order_desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `attachments` varchar(255) DEFAULT NULL COMMENT '附件',
  `cclist` varchar(255) DEFAULT NULL COMMENT '抄送人',
  `priority` varchar(11) DEFAULT NULL COMMENT '优先级',
  `state` varchar(11) DEFAULT NULL COMMENT '工单状态',
  `customer_service_id` int(11) DEFAULT NULL COMMENT '受理客服id',
  `customer_id` int(11) DEFAULT NULL COMMENT '所属客户id',
  `channel` varchar(255) DEFAULT NULL COMMENT '即时聊天、手工录入、客户管理',
  `create_time` datetime DEFAULT NULL COMMENT '工单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '工单更新时间',
  PRIMARY KEY (`work_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of work_order
-- ----------------------------
INSERT INTO `work_order` VALUES ('1', '分类一', '客户报价', '客户报价相关问题回复', null, '七尾', '高', '未分配', '1', '2', '手动录入', '2020-07-02 20:52:04', '2020-07-03 20:52:08');
INSERT INTO `work_order` VALUES ('2', '分类二', '商业合作', '合作相关事宜回复', null, '七尾', '低', '待处理', '2', '1', '即时聊天', '2020-07-04 20:52:31', '2020-07-05 20:52:36');
INSERT INTO `work_order` VALUES ('3', '分类一', '客户报价', '客户报价相关问题回复', null, '李想', '中', '处理中', '3', '3', '客户管理', '2020-07-06 20:53:43', '2020-07-09 20:53:52');
INSERT INTO `work_order` VALUES ('4', '分类三', '优化建议', '客户关于产品优化的建议', null, '王志', '紧急', '已解决', '2', '2', '手动录入', '2020-07-05 20:55:55', '2020-07-08 20:55:48');
INSERT INTO `work_order` VALUES ('5', '分类三', '改善建议', '客户关于改善优化的建议', null, '李想', '中', '已关闭', '1', '1', '客户管理', '2020-07-07 20:56:09', '2020-07-10 20:56:01');
INSERT INTO `work_order` VALUES ('6', '分类一', '客户咨询', '客户关于产品问题咨询', null, '王志', '高', '处理中', '6', '3', '即时聊天', '2020-07-08 21:14:44', '2020-07-09 21:14:48');

-- ----------------------------
-- Table structure for `work_order_class`
-- ----------------------------
DROP TABLE IF EXISTS `work_order_class`;
CREATE TABLE `work_order_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工单类别id',
  `class_name` varchar(255) NOT NULL COMMENT '工单类别名称',
  `number` int(11) DEFAULT NULL COMMENT '该类别工单数量',
  `create_time` datetime DEFAULT NULL COMMENT '类别创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_order_class
-- ----------------------------
INSERT INTO `work_order_class` VALUES ('1', '推广相关工单', '108', '2020-07-08 22:19:49');
INSERT INTO `work_order_class` VALUES ('2', '服务相关工单', '100', '2020-07-08 22:20:28');
INSERT INTO `work_order_class` VALUES ('3', '合作相关工单', '99', '2020-07-08 22:21:13');

-- ----------------------------
-- Table structure for `work_order_log`
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

-- ----------------------------
-- View structure for `cs_group_role`
-- ----------------------------
DROP VIEW IF EXISTS `cs_group_role`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cs_group_role` AS select `customer_service`.`id` AS `customer_service_id`,`customer_service_group`.`id` AS `group_id`,`customer_service_group`.`group_name` AS `group_name`,`customer_service_role`.`id` AS `role_id`,`customer_service_role`.`name` AS `name` from ((`customer_service` join `customer_service_group` on((`customer_service`.`customer_service_group_id` = `customer_service_group`.`id`))) join `customer_service_role` on((`customer_service`.`role_id` = `customer_service_role`.`id`))) ;

-- ----------------------------
-- View structure for `c_cs_wo_group`
-- ----------------------------
DROP VIEW IF EXISTS `c_cs_wo_group`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `c_cs_wo_group` AS select `customer_service`.`id` AS `customer_service_id`,`customer_service_group`.`id` AS `group_id`,`customer_service_group`.`group_name` AS `group_name`,`customer_service_role`.`id` AS `role_id`,`customer_service_role`.`name` AS `role_name`,`customer_service`.`nick_name` AS `nick_name`,`customer_service`.`real_name` AS `real_name`,`customer_service`.`phone` AS `phone`,`customer_service`.`email` AS `email`,`customer_service`.`work_state` AS `work_state`,`customer_service`.`online_state` AS `online_state`,`customer_service`.`average_session_time` AS `average_session_time`,`customer_service`.`average_response_time` AS `average_response_time`,`customer_service`.`session_count` AS `session_count`,`customer_service`.`msg_count` AS `msg_count`,`customer_service`.`total_online_time` AS `total_online_time` from ((`customer_service` join `customer_service_group` on((`customer_service`.`customer_service_group_id` = `customer_service_group`.`id`))) join `customer_service_role` on((`customer_service`.`role_id` = `customer_service_role`.`id`))) ;
