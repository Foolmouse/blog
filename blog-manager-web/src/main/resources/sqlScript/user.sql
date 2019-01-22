/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-01-22 17:41:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userCode` varchar(64) DEFAULT NULL,
  `userName` varchar(64) DEFAULT NULL,
  `nickName` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `telephone` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `gender` varchar(64) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `isLocked` tinyint(4) DEFAULT NULL,
  `isExpired` tinyint(4) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `image` longblob,
  `createdDatetime` datetime DEFAULT NULL,
  `lastModifiedDatetime` datetime DEFAULT NULL,
  `dr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_USERCODE` (`userCode`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '00001', 'admin', 'dunk', '985440944@qq.com', null, '$2a$10$dc4AsvsqH14iDBnRnjU/r.ZxKW1feStv5hLjTH8OrOiWc9tM3Io52', null, null, null, null, null, null, null, null, null);
