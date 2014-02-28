/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : adouteam

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-02-28 19:09:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adou_blog`
-- ----------------------------
DROP TABLE IF EXISTS `adou_blog`;
CREATE TABLE `adou_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` char(36) NOT NULL,
  `editor` varchar(20) DEFAULT NULL,
  `titile` varchar(100) NOT NULL,
  `content` longtext NOT NULL,
  `ctime` datetime NOT NULL,
  `utime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adou_blog
-- ----------------------------

-- ----------------------------
-- Table structure for `adou_blog_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `adou_blog_catalog`;
CREATE TABLE `adou_blog_catalog` (
  `id` int(11) NOT NULL,
  `blog` char(36) NOT NULL,
  `catalog` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adou_blog_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `adou_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `adou_catalog`;
CREATE TABLE `adou_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `parent` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adou_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `adou_user`
-- ----------------------------
DROP TABLE IF EXISTS `adou_user`;
CREATE TABLE `adou_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` char(8) NOT NULL,
  `privilege` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adou_user
-- ----------------------------
INSERT INTO `adou_user` VALUES ('1', 'buxianglong', 'buxianglong@oschina.net', '432c0b43f5231c242ba62127566705af', '', '110');
