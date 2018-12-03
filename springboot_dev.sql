/*
Navicat MySQL Data Transfer

Source Server         : 172.21.0.6（new）
Source Server Version : 50722
Source Host           : 172.21.0.6:3306
Source Database       : springboot_dev

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-12-03 16:49:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_btn
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_btn`;
CREATE TABLE `t_sys_btn` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `btn_code` varchar(32) NOT NULL COMMENT '按钮编码（add,get,del）',
  `btn_name` varchar(64) DEFAULT NULL COMMENT '按钮名称',
  `btn_title` varchar(100) DEFAULT NULL COMMENT '按钮提示说明',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单编码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COMMENT='系统按钮资源表';

-- ----------------------------
-- Table structure for t_sys_dict_city
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_city`;
CREATE TABLE `t_sys_dict_city` (
  `id` int(11) NOT NULL,
  `areaname` text NOT NULL,
  `parentid` int(11) NOT NULL,
  `shortname` text,
  `areacode` int(11) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `pinyin` text,
  `lng` text,
  `lat` text,
  `level` int(11) NOT NULL,
  `position` text NOT NULL,
  `sort` int(10) unsigned DEFAULT '50',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_data`;
CREATE TABLE `t_sys_dict_data` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dict_code` varchar(32) NOT NULL COMMENT '字典Key',
  `dict_value` varchar(64) DEFAULT NULL COMMENT '字典数据名称',
  `dict_type` varchar(32) NOT NULL COMMENT '字典类型CODE',
  `pid_code` varchar(32) DEFAULT NULL COMMENT '字典数据上级CODE',
  `state` char(1) DEFAULT NULL COMMENT '是否有效 1有效，0无效',
  `order_by` int(9) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  `discount` decimal(12,2) DEFAULT NULL COMMENT '付款方式专用折扣值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_code` (`dict_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Table structure for t_sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_type`;
CREATE TABLE `t_sys_dict_type` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dict_type` varchar(32) NOT NULL COMMENT '字典类型关键字',
  `dict_name` varchar(64) DEFAULT NULL COMMENT '字典类型名称',
  `state` char(1) DEFAULT NULL COMMENT '是否有效 1有效，0无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT,
  `attc_code` varchar(64) DEFAULT NULL COMMENT '附件编号',
  `attc_suffix` varchar(32) DEFAULT NULL COMMENT '附件后缀',
  `file_type` varchar(64) DEFAULT NULL COMMENT '上传附件类型',
  `attc_url_big` varchar(512) DEFAULT NULL COMMENT '大图附件路径',
  `attc_url_small` varchar(512) DEFAULT NULL COMMENT '小图附件路径',
  `attc_name` varchar(512) DEFAULT NULL COMMENT '附件名',
  `attc_url_middle` varchar(512) DEFAULT NULL COMMENT '中图附件路径',
  `attc_type` varchar(64) DEFAULT NULL COMMENT '文件分类（image、media、file）',
  `attc_url` varchar(512) DEFAULT NULL COMMENT '附件路径',
  `attc_order` bigint(15) DEFAULT NULL COMMENT '附件顺序 1、2、3、4',
  `biz_key` varchar(64) DEFAULT NULL COMMENT '业务key',
  `biz_type` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `is_valid` char(1) DEFAULT NULL COMMENT '状态（0正常 1删除 2停用）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  `editor` varchar(64) DEFAULT NULL COMMENT '修改人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本',
  `is_deleted` char(1) DEFAULT NULL COMMENT '是否删除（0： 正常 1：已删除）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `file_group` varchar(50) DEFAULT NULL,
  `file_size` bigint(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_attc_code` (`attc_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1365 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `id` bigint(18) NOT NULL COMMENT 'id',
  `log_type_id` bigint(18) DEFAULT '1' COMMENT '日志类型[0异常日志,1正常日志]',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题[接口名]',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作ip地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求uri',
  `method` varchar(6) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  `creator` varchar(64) DEFAULT NULL COMMENT '操作者',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `menu_code` varchar(32) NOT NULL COMMENT '菜单编码',
  `menu_name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `pid_code` varchar(32) DEFAULT NULL COMMENT '父菜单编码',
  `pid_name` varchar(64) DEFAULT NULL COMMENT '父菜单名称',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否子节点 1是 0否',
  `icon` varchar(64) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `grder_by` int(9) DEFAULT NULL COMMENT '排序',
  `state` char(1) DEFAULT '1' COMMENT '是否有效  1:有效   0:无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_code` (`menu_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Table structure for t_sys_msg_push
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_msg_push`;
CREATE TABLE `t_sys_msg_push` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `msg_type` varchar(32) DEFAULT NULL COMMENT '消息类型（PC APP 短信 邮件 微信）',
  `tpl_code` varchar(32) DEFAULT NULL COMMENT '消息模板编号',
  `app_code` varchar(32) DEFAULT NULL COMMENT 'APP编码',
  `msg_title` varchar(32) DEFAULT NULL COMMENT '消息标题',
  `msg_content` varchar(500) DEFAULT NULL COMMENT '消息内容',
  `receive_code` varchar(32) DEFAULT NULL COMMENT '接受者账号',
  `receive_user_code` varchar(32) DEFAULT NULL COMMENT '接受者用户编码',
  `receive_user_name` varchar(64) DEFAULT NULL COMMENT '接受者用户姓名',
  `send_user_code` varchar(32) DEFAULT NULL COMMENT '发送者用户编码',
  `send_user_name` varchar(64) DEFAULT NULL COMMENT '发送者用户姓名',
  `send_date` varchar(32) DEFAULT NULL COMMENT '发送时间',
  `plan_push_date` varchar(32) DEFAULT NULL COMMENT '计划推送时间',
  `push_number` int(5) DEFAULT NULL COMMENT '推送尝试次数',
  `push_return_code` varchar(32) DEFAULT NULL COMMENT '推送返回结果码',
  `push_return_content` varchar(500) DEFAULT NULL COMMENT '推送返回的内容信息',
  `push_status` varchar(1) DEFAULT NULL COMMENT '推送状态（0未推送 1成功  2失败 3推送中）',
  `biz_code` varchar(32) DEFAULT NULL COMMENT '业务编码',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1145 DEFAULT CHARSET=utf8 COMMENT='消息推送表';

-- ----------------------------
-- Table structure for t_sys_msg_template
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_msg_template`;
CREATE TABLE `t_sys_msg_template` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `tpl_type` varchar(32) DEFAULT NULL COMMENT '模板类型',
  `tpl_code` varchar(32) DEFAULT NULL COMMENT '模板编号',
  `tpl_name` varchar(64) DEFAULT NULL COMMENT '模板名称',
  `tpl_content` varchar(500) DEFAULT NULL COMMENT '模板内容',
  `state` char(1) DEFAULT NULL COMMENT '状态（0正常 1删除 2停用）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tpl_code` (`tpl_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='消息模板表';

-- ----------------------------
-- Table structure for t_sys_organ
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_organ`;
CREATE TABLE `t_sys_organ` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `org_code` varchar(32) NOT NULL COMMENT '部门编码',
  `org_name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `pid_code` varchar(32) DEFAULT NULL COMMENT '父级编码',
  `duty_code` varchar(64) DEFAULT NULL COMMENT '部门负责人编号',
  `duty_name` varchar(64) DEFAULT NULL COMMENT '部门负责人姓名',
  `order_by` int(9) DEFAULT NULL COMMENT '排序',
  `state` char(1) DEFAULT '1' COMMENT '是否有效  1:有效   0:无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `org_code` (`org_code`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_code` varchar(32) NOT NULL COMMENT '角色编码',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `state` char(1) DEFAULT '1' COMMENT '状态1有效，0无效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for t_sys_role_btn
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_btn`;
CREATE TABLE `t_sys_role_btn` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编码',
  `btn_id` bigint(15) DEFAULT NULL COMMENT '按钮id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_btn_code` (`role_code`,`btn_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 COMMENT='角色按钮关系表';

-- ----------------------------
-- Table structure for t_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menu`;
CREATE TABLE `t_sys_role_menu` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编码',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单编码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_menu_code` (`role_code`,`menu_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='角色菜单关系表';

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(64) NOT NULL COMMENT '用户编码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `user_pwd` varchar(64) NOT NULL COMMENT '用户密码',
  `org_code` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `org_name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `job_num` varchar(32) NOT NULL COMMENT '工号',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `open_id` varchar(64) DEFAULT NULL COMMENT '微信openID',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `state` char(1) DEFAULT '1' COMMENT '状态(0:无效, 1:有效)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`),
  UNIQUE KEY `job_num` (`job_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1067969021399203842 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_code` varchar(64) DEFAULT NULL COMMENT '用户编码',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `editor` varchar(64) DEFAULT NULL COMMENT '更新人',
  `version` bigint(15) DEFAULT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` char(1) DEFAULT '0' COMMENT '是否删除0： 正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_code` (`user_code`,`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
