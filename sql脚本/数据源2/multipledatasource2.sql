/*
Navicat MariaDB Data Transfer

Source Server         : localhost_mariadb
Source Server Version : 100017
Source Host           : localhost:3307
Source Database       : multipledatasource2

Target Server Type    : MariaDB
Target Server Version : 100017
File Encoding         : 65001

Date: 2018-07-12 09:43:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cs_class
-- ----------------------------
DROP TABLE IF EXISTS `cs_class`;
CREATE TABLE `cs_class` (
  `classid` varchar(32) NOT NULL,
  `classname` varchar(255) DEFAULT NULL,
  `classno` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_class
-- ----------------------------
INSERT INTO `cs_class` VALUES ('1', '一班', 'a');
INSERT INTO `cs_class` VALUES ('2', '二班', 'b');

-- ----------------------------
-- Table structure for cs_teacher
-- ----------------------------
DROP TABLE IF EXISTS `cs_teacher`;
CREATE TABLE `cs_teacher` (
  `id` varchar(32) NOT NULL,
  `teachername` varchar(255) DEFAULT NULL,
  `classid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_teacher
-- ----------------------------
INSERT INTO `cs_teacher` VALUES ('1', '马老师', '1');
INSERT INTO `cs_teacher` VALUES ('2', '王老师', '1');
INSERT INTO `cs_teacher` VALUES ('3', '张老师', '2');
INSERT INTO `cs_teacher` VALUES ('4', '李老师', '1');
INSERT INTO `cs_teacher` VALUES ('5', '方老师', '2');
INSERT INTO `cs_teacher` VALUES ('ca1dccb0dfc848b5bb666b7055c2f48b', '方老师', '2');
INSERT INTO `cs_teacher` VALUES ('f18d357f94264c1ca4ef52e597e8b9c8', '方老师', '2');
