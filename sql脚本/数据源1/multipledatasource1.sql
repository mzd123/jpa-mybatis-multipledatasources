/*
Navicat MariaDB Data Transfer

Source Server         : localhost_mariadb
Source Server Version : 100017
Source Host           : localhost:3307
Source Database       : multipledatasource1

Target Server Type    : MariaDB
Target Server Version : 100017
File Encoding         : 65001

Date: 2018-07-12 09:41:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cs_test
-- ----------------------------
DROP TABLE IF EXISTS `cs_test`;
CREATE TABLE `cs_test` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL,
  `userid` varchar(32) DEFAULT NULL,
  `score` int(3) DEFAULT NULL,
  `classid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cs_test
-- ----------------------------
INSERT INTO `cs_test` VALUES ('04c4e3ea0a044d62994717d1c1749281', '4', '30', '2');
INSERT INTO `cs_test` VALUES ('09db5fa080fe11e881d854ab3a1e783c', '1', '80', '1');
INSERT INTO `cs_test` VALUES ('25c62dbd6eee46c2b9db89d8791ac57b', '4', '30', '2');
INSERT INTO `cs_test` VALUES ('2b62353f80fe11e881d854ab3a1e783c', '1', '60', '2');
INSERT INTO `cs_test` VALUES ('2b63c4cc80fe11e881d854ab3a1e783c', '1', '75', '4');
INSERT INTO `cs_test` VALUES ('3e415aff80fe11e881d854ab3a1e783c', '2', '80', '1');
INSERT INTO `cs_test` VALUES ('3e4371a880fe11e881d854ab3a1e783c', '2', '95', '4');
INSERT INTO `cs_test` VALUES ('5e1627a7b6bd47fc9175edd3613db504', '4', '30', '2');
INSERT INTO `cs_test` VALUES ('90dcccc9e969492384f0f23cca8f7743', '4', '30', '2');
INSERT INTO `cs_test` VALUES ('d3a9d83a6360405993f71ac79eb64eb6', '3', '30', '2');
INSERT INTO `cs_test` VALUES ('d51254c645974a42974a99b690b7e769', '3', '70', '4');
INSERT INTO `cs_test` VALUES ('dcc41c1283494c0d9bdafe4fcffa6081', '4', '30', '2');
INSERT INTO `cs_test` VALUES ('e4ef7bd6f950455d9961de4f73e860ce', '4', '30', '2');
INSERT INTO `cs_test` VALUES ('e7cd56c3ad274fea9fc28d097208af71', '4', '30', '2');

-- ----------------------------
-- Table structure for cs_user
-- ----------------------------
DROP TABLE IF EXISTS `cs_user`;
CREATE TABLE `cs_user` (
  `userid` varchar(32) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `usersex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_user
-- ----------------------------
INSERT INTO `cs_user` VALUES ('1', '小明', '男');
INSERT INTO `cs_user` VALUES ('2', '小黄', '女');
INSERT INTO `cs_user` VALUES ('3', '小王', '男');
