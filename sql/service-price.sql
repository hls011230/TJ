/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : service-price

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/06/2023 12:52:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for price_rule
-- ----------------------------
DROP TABLE IF EXISTS `price_rule`;
CREATE TABLE `price_rule`  (
  `city_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '城市代码',
  `vehicle_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车辆类型',
  `start_fare` double(4, 2) NULL DEFAULT NULL COMMENT '起步价',
  `start_mile` int(0) NULL DEFAULT NULL,
  `start_weight` int(0) NULL DEFAULT NULL,
  `unit_price_per_mile` double(4, 2) NULL DEFAULT NULL,
  `unit_price_per_minute` double(4, 2) NULL DEFAULT NULL,
  `unit_price_per_weight` double(4, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`city_code`, `vehicle_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of price_rule
-- ----------------------------
INSERT INTO `price_rule` VALUES ('110000', '1', 3.00, 3, 5, 0.50, 1.00, 1.00);
INSERT INTO `price_rule` VALUES ('110000', '2', 13.00, 3, 5, 3.00, 2.00, 2.00);

SET FOREIGN_KEY_CHECKS = 1;
