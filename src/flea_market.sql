/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : flea_market

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-20 15:16:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adress_table`
-- ----------------------------
DROP TABLE IF EXISTS `adress_table`;
CREATE TABLE `adress_table` (
  `adress_id` int(11) NOT NULL AUTO_INCREMENT,
  `adress1` varchar(200) DEFAULT NULL,
  `adress2` varchar(200) DEFAULT NULL,
  `adress3` varchar(200) DEFAULT NULL,
  `adress4` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`adress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adress_table
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` int(20) NOT NULL AUTO_INCREMENT,
  `g_price` float(10,2) NOT NULL,
  `g_attribute` varchar(255) NOT NULL,
  `restnum` int(20) DEFAULT NULL,
  `g_name` varchar(225) NOT NULL,
  `u_id` int(11) NOT NULL,
  `image_id` int(50) DEFAULT NULL,
  `introduce` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`g_id`),
  KEY `u_id2` (`u_id`),
  KEY `image_id` (`image_id`),
  CONSTRAINT `image_id` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`),
  CONSTRAINT `u_id2` FOREIGN KEY (`u_id`) REFERENCES `usertable` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `url1` varchar(50) DEFAULT NULL,
  `url2` varchar(50) DEFAULT NULL,
  `url3` varchar(50) DEFAULT NULL,
  `url4` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `pay_type` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `s_id` (`s_id`),
  KEY `u_id3` (`u_id`),
  CONSTRAINT `s_id` FOREIGN KEY (`s_id`) REFERENCES `session` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `u_id3` FOREIGN KEY (`u_id`) REFERENCES `usertable` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `og_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` int(11) NOT NULL,
  `g_id` int(11) NOT NULL,
  `prince` float NOT NULL,
  `og_num` int(11) NOT NULL,
  PRIMARY KEY (`og_id`),
  KEY `o_id` (`o_id`),
  KEY `g_id2` (`g_id`),
  CONSTRAINT `g_id2` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `o_id` FOREIGN KEY (`o_id`) REFERENCES `order` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `session`
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `s_id` int(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `evaluate` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------

-- ----------------------------
-- Table structure for `shopcar_goods`
-- ----------------------------
DROP TABLE IF EXISTS `shopcar_goods`;
CREATE TABLE `shopcar_goods` (
  `sg_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `g_id` int(11) NOT NULL,
  PRIMARY KEY (`sg_id`),
  KEY `u_id` (`u_id`),
  KEY `g_id1` (`g_id`),
  CONSTRAINT `g_id1` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `usertable` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcar_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `usertable`
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `psw` varchar(30) NOT NULL,
  `state_type` int(11) NOT NULL DEFAULT '0',
  `adress_id` int(11) DEFAULT NULL,
  `integral` int(11) DEFAULT '0',
  PRIMARY KEY (`uid`),
  KEY `adress_id` (`adress_id`),
  CONSTRAINT `adress_id` FOREIGN KEY (`adress_id`) REFERENCES `adress_table` (`adress_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------

-- ----------------------------
-- Table structure for `user_goods`
-- ----------------------------
DROP TABLE IF EXISTS `user_goods`;
CREATE TABLE `user_goods` (
  `ug_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `ug_date` varchar(20) NOT NULL,
  PRIMARY KEY (`ug_id`),
  KEY `u1_id` (`u_id`),
  KEY `g_id` (`g_id`),
  CONSTRAINT `g_id` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`),
  CONSTRAINT `u1_id` FOREIGN KEY (`u_id`) REFERENCES `usertable` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_goods
-- ----------------------------
