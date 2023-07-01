/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : service-user

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/06/2023 12:51:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint unsigned NOT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `user_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_gender` tinyint(1) NULL DEFAULT NULL COMMENT '0：未知，1：男，2：女',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '0：有效，1：失效',
  `profile_photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像图片地址的url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1665200598775087106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2023-05-30 13:50:41', '2023-05-30 13:50:41', '18379196920', '用户18379196920', 0, 0, NULL);
INSERT INTO `user` VALUES (1664508665954144257, '2023-06-02 13:46:06', '2023-06-02 13:46:06', NULL, '用户null', 0, 0, NULL);
INSERT INTO `user` VALUES (1665200598775087105, '2023-06-04 11:35:35', '2023-06-04 11:35:35', '123456789', '用户123456789', 0, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
