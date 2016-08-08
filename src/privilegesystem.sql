/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : privilegesystem

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-08-08 14:31:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `privilege`
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES ('3ccfc2fc-74f2-4432-9a01-c049abd1907a', '修改权限', '这是一个可以用于修改Privilege的权限 ');
INSERT INTO `privilege` VALUES ('4b391989-493c-4188-a917-444657af4a95', '删除商品', '这个权限可以用来删除商品信息 ');
INSERT INTO `privilege` VALUES ('804f3706-0969-4de3-ac34-f3c25524e1fc', '更新商品', '这个权限可以用来更新商品信息 ，比如物价或者更换等等。');
INSERT INTO `privilege` VALUES ('a3a40e31-0aa6-4368-a6ae-937a5d16040c', 'Privilege1', 'This is the first test for adding privilege. ');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0324b8a8-ef2d-4f8d-96a9-e83b77db95b4', '管理员', '管理员拥有仅次于站长的权限，可以完成日常的业务。 ');
INSERT INTO `role` VALUES ('58a166ff-52c6-491e-a13a-e46ec31123d7', '游客', ' 游客的权限最低，只能在网站上进行浏览。 ');

-- ----------------------------
-- Table structure for `role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `role_id` varchar(40) NOT NULL,
  `privilege_id` varchar(40) NOT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`),
  KEY `privilege_id_FK` (`privilege_id`),
  CONSTRAINT `privilege_id_FK` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `role_id_FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
INSERT INTO `role_privilege` VALUES ('58a166ff-52c6-491e-a13a-e46ec31123d7', '3ccfc2fc-74f2-4432-9a01-c049abd1907a');
INSERT INTO `role_privilege` VALUES ('0324b8a8-ef2d-4f8d-96a9-e83b77db95b4', 'a3a40e31-0aa6-4368-a6ae-937a5d16040c');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3f89381b-448a-49de-9966-0acab01c9126', '郭璞', '123456');
INSERT INTO `user` VALUES ('467c6e35-0a1a-42b0-bae0-b134fb7272df', 'Mark', 'Mark_password');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(40) NOT NULL,
  `role_id` varchar(40) NOT NULL,
  KEY `user_id_FK` (`user_id`),
  KEY `role_id_FK1` (`role_id`),
  CONSTRAINT `role_id_FK1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('3f89381b-448a-49de-9966-0acab01c9126', '0324b8a8-ef2d-4f8d-96a9-e83b77db95b4');
INSERT INTO `user_role` VALUES ('467c6e35-0a1a-42b0-bae0-b134fb7272df', '58a166ff-52c6-491e-a13a-e46ec31123d7');
