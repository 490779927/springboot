/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : crk5

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 24/05/2019 11:22:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `del_flag` int(1) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES (1, '标题一', '这个是第一个秒速', 0, '2019-05-20 15:11:31', '2019-05-20 15:11:31');
INSERT INTO `title` VALUES (2, '标题二', '撒旦靠近离开房间啊将打破', 0, '2019-05-20 15:12:06', '2019-05-20 15:12:06');
INSERT INTO `title` VALUES (3, '标题三', '测试试用的', 0, '2019-05-24 10:24:17', '2019-05-24 10:24:17');
INSERT INTO `title` VALUES (4, '测试测试测试', '12312312312', 0, '2019-05-24 10:40:49', '2019-05-24 10:40:49');

SET FOREIGN_KEY_CHECKS = 1;
