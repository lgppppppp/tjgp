/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-08-02 15:44:52
*/



-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('u', '$2a$10$j0T8C80mrdtDx5I1UL85teUtMY2/23UEb7kR5toVcvnbSqpsubgme', '1');
INSERT INTO `users` VALUES ('a', '$2a$10$j0T8C80mrdtDx5I1UL85teUtMY2/23UEb7kR5toVcvnbSqpsubgme', '1');
-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('u', 'ROLE_user');
INSERT INTO `authorities` VALUES ('a', 'ROLE_admin');