/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : service-rider

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/06/2023 12:51:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rider
-- ----------------------------
DROP TABLE IF EXISTS `rider`;
CREATE TABLE `rider`  (
  `id` bigint unsigned NOT NULL,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '骑手注册地行政区划代码',
  `rider_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '骑手姓名',
  `rider_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '骑手电话',
  `rider_gender` tinyint(0) NULL DEFAULT NULL COMMENT '1:男，2：女',
  `rider_birthday` date NULL DEFAULT NULL,
  `register_date` date NULL DEFAULT NULL COMMENT '报备日期',
  `state` tinyint(0) NULL DEFAULT NULL COMMENT '骑手状态：0：有效，1：失效',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1584359006294835203 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rider
-- ----------------------------
INSERT INTO `rider` VALUES (1, '110000', '小张', '123', 1, '2020-01-03', '2020-02-03', 1, '2023-06-05 12:45:38', '2023-06-05 12:45:38');
INSERT INTO `rider` VALUES (2, '110000', '小王', '18379196920', 1, '2020-01-03', '2020-02-03', 1, '2023-06-05 12:45:38', '2023-06-05 12:45:38');

-- ----------------------------
-- Table structure for rider_work_status
-- ----------------------------
DROP TABLE IF EXISTS `rider_work_status`;
CREATE TABLE `rider_work_status`  (
  `id` bigint(0) NOT NULL,
  `rider_id` bigint(0) NULL DEFAULT NULL,
  `work_status` int(0) NULL DEFAULT NULL COMMENT '休息：0；派送：1，暂停：2',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rider_work_status
-- ----------------------------
INSERT INTO `rider_work_status` VALUES (1584359008563953666, 1, 1, '2023-05-28 14:36:04', '2023-05-28 14:36:04');

SET FOREIGN_KEY_CHECKS = 1;
