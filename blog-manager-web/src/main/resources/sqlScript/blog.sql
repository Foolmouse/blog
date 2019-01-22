/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-01-22 17:40:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `abstractContent` varchar(255) DEFAULT NULL,
  `content` text,
  `categoryId` bigint(11) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `createdDatetime` datetime DEFAULT NULL,
  `lastModifiedDatetime` datetime DEFAULT NULL,
  `dr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `createdDatetime` datetime DEFAULT NULL,
  `lastModifiedDatetime` datetime DEFAULT NULL,
  `dr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `isLoginSuccess` varchar(255) DEFAULT NULL,
  `browserInfo` varchar(512) DEFAULT NULL,
  `loginDateTime` datetime DEFAULT NULL,
  `errorMessage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=215 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for portal_log
-- ----------------------------
DROP TABLE IF EXISTS `portal_log`;
CREATE TABLE `portal_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(64) DEFAULT NULL,
  `userAgent` varchar(512) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `requestDateTime` datetime DEFAULT NULL,
  `errorMessage` varchar(512) DEFAULT NULL,
  `blogName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=362 DEFAULT CHARSET=utf8;

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
