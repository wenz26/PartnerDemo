/*
Navicat MySQL Data Transfer

Source Server         : alibabaCould
Source Server Version : 50727
Source Host           : 106.15.37.148:3306
Source Database       : hbulider

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-08 13:12:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `zan` int(10) DEFAULT NULL,
  `cai` int(10) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `comment_user_fk` (`userid`),
  CONSTRAINT `comment_user_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '哇！太厉害了！', null, null, '2');
INSERT INTO `comment` VALUES ('3', 'aaa', null, null, '1');
INSERT INTO `comment` VALUES ('9', '顶！！！', '3', null, '2');
INSERT INTO `comment` VALUES ('10', '挖槽！！什么玩意', null, null, '1');
INSERT INTO `comment` VALUES ('11', 'asd', '2', null, '2');
INSERT INTO `comment` VALUES ('12', '阿萨德', null, null, '2');
INSERT INTO `comment` VALUES ('13', 'asddas', null, null, '2');
INSERT INTO `comment` VALUES ('14', 'adfdgfdf', null, null, '2');
INSERT INTO `comment` VALUES ('15', 'asdfddggfghhg', null, null, '2');
INSERT INTO `comment` VALUES ('16', 'undefined', null, null, '2');
INSERT INTO `comment` VALUES ('22', 'asduyujjh', null, null, '2');
INSERT INTO `comment` VALUES ('24', '挖槽牛逼', null, null, '2');
INSERT INTO `comment` VALUES ('25', '挖槽，牛逼', null, null, '2');
INSERT INTO `comment` VALUES ('26', '嗦嘎', null, null, '2');
INSERT INTO `comment` VALUES ('27', '⊙∀⊙！', null, null, '17');
INSERT INTO `comment` VALUES ('28', '哇⊙∀⊙！', null, null, '2');
INSERT INTO `comment` VALUES ('29', '╯^╰', null, null, '3');
INSERT INTO `comment` VALUES ('30', '一giao我里giao giao', null, null, '20');

-- ----------------------------
-- Table structure for motherland
-- ----------------------------
DROP TABLE IF EXISTS `motherland`;
CREATE TABLE `motherland` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `detailed` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of motherland
-- ----------------------------
INSERT INTO `motherland` VALUES ('1', 'http://localhost:8080/image/tank.JPG', '坦克方队', '22辆99A坦克呈“箭”形布阵。国产主战坦克已实现火力、机动力、信息力、防护力的融合。');
INSERT INTO `motherland` VALUES ('2', 'http://localhost:8080/image/armor.JPG', '轻型装甲方队', '15式新型轻型坦克、04A式履带步战车实现机械化、信息化、能够快速部署、快速反应、快速突击，是陆上应急作战的“急先锋”。');
INSERT INTO `motherland` VALUES ('3', 'http://localhost:8080/image/assault.JPG', '两栖突击车方队', '05A式两栖突击车。');
INSERT INTO `motherland` VALUES ('4', 'http://localhost:8080/image/airborne.JPG', '空降兵战车方队', '轻型履带式步战车。');
INSERT INTO `motherland` VALUES ('5', 'http://localhost:8080/image/artillery.JPG', '自行火炮方队', '箱式火箭炮、155车载加榴炮。');
INSERT INTO `motherland` VALUES ('6', 'http://localhost:8080/image/anti-tank.JPG', '反坦克导弹方队', '红箭-10反坦克导弹。');
INSERT INTO `motherland` VALUES ('7', 'http://localhost:8080/image/special.JPG', '特战装备方队', '全地形车、空中突击旋翼机。');
INSERT INTO `motherland` VALUES ('8', 'http://localhost:8080/image/counter-terrorism.JPG', '武警反恐突击方队', '反恐突击车和防爆装甲车。');

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', 'after.mp3', 'http://106.15.37.148:8080/image/after.jpg', '后来的我们', '五月天');
INSERT INTO `music` VALUES ('2', 'ljj.mp3', 'http://106.15.37.148:8080/image/ljj.jpg', '关键词', '林俊杰');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `beforeschool` varchar(255) DEFAULT NULL,
  `kindergarten` varchar(255) DEFAULT NULL,
  `primaryschool` varchar(255) DEFAULT NULL,
  `middleschool` varchar(255) DEFAULT NULL,
  `highschool` varchar(255) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_uq` (`username`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '朋友', '狮子', '大象', '老师', '犀牛', '书');
INSERT INTO `user` VALUES ('2', 'cwz', '123', '狗', '猫', '老虎', '书', '朋友', '老师');
INSERT INTO `user` VALUES ('3', 'mike', '123', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('17', 'ljj', '123', '可以吃鱼', '我喜欢大笑', '看书', '看动物', '看书', '编程');
INSERT INTO `user` VALUES ('18', '123', '123', 'bbb', '', '', '', '', '');
INSERT INTO `user` VALUES ('19', 'li', '123', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('20', 'giao', '123', 'giao哥', '一giao我里giao giao', '一窝giao', '', '', '');

-- ----------------------------
-- Table structure for zan
-- ----------------------------
DROP TABLE IF EXISTS `zan`;
CREATE TABLE `zan` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `zan_user_fk` (`username`),
  CONSTRAINT `zan_user_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zan
-- ----------------------------
INSERT INTO `zan` VALUES ('39', 'admin');
INSERT INTO `zan` VALUES ('38', 'cwz');
INSERT INTO `zan` VALUES ('44', 'giao');
INSERT INTO `zan` VALUES ('43', 'li');
INSERT INTO `zan` VALUES ('34', 'ljj');
INSERT INTO `zan` VALUES ('40', 'mike');
