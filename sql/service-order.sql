/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : service-order

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/06/2023 12:52:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `user_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `rider_id` bigint(0) NULL DEFAULT NULL COMMENT '骑手ID',
  `rider_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '骑手手机号',
  `vehicle_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发起地行政区划代码',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单发起时间',
  `depart_time` datetime(0) NULL DEFAULT NULL COMMENT '预计送货时间',
  `departure` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计发货地点',
  `dep_house_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发货人门牌号',
  `dest_house_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人门牌号',
  `dep_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发货人姓名',
  `dest_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `dep_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发货人电话',
  `dest_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `dep_longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计出发地点经度',
  `dep_latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计出发地点纬度',
  `destination` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计送货地址',
  `dest_longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计送货地址经度',
  `dest_latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计送货地址纬度',
  `encrypt` int(0) NULL DEFAULT NULL COMMENT '坐标加密标识\r\n1:GCJ-02测绘局标准\r\n2:WGS84 GPS标准\r\n3:BD-09 百度标准\r\n4:CGCS2000 北斗标准\r\n0:其他',
  `receive_order_car_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接单时车辆经度',
  `receive_order_car_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接单时车辆纬度',
  `receive_order_time` datetime(0) NULL DEFAULT NULL COMMENT '接单时间，派单成功时间',
  `to_pick_up_goods_time` datetime(0) NULL DEFAULT NULL COMMENT '骑手取货时间',
  `rider_arrived_destination_time` datetime(0) NULL DEFAULT NULL COMMENT '骑手送货到达时间',
  `cancel_time` datetime(0) NULL DEFAULT NULL COMMENT '订单撤销时间',
  `cancel_operator` int(0) NULL DEFAULT NULL COMMENT '撤销发起者：1:用户\r\n2:骑手\r\n',
  `cancel_type_code` int(0) NULL DEFAULT NULL COMMENT '撤销类型代码\r\n1:用户提前撤销\r\n2:骑手提前撤销\r\n',
  `order_status` int(0) NULL DEFAULT NULL COMMENT '订单状态1：订单开始 2：骑手接单 3：取到货物 4：派送 5：货物送达，未支付 6：发起收款 7: 支付完成 8.订单取消\'',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '订单价格',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (2, 1, '123', NULL, NULL, NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `order_info` VALUES (3, 1, '18379196920', NULL, NULL, NULL, '110000', NULL, NULL, '江西软件职业技术大学', 'D2117', '保安室', '小黄', '黄先生', '18379196920', '18379196920', '115.82271', '28.902229', '罗亭工业园', '115.82045', '28.909104', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 10.70, '2023-06-03 19:20:44', '2023-06-03 19:20:44');
INSERT INTO `order_info` VALUES (4, 1, '18379196920', NULL, NULL, NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-行政楼(行政中心)', 'D2117', '保安室', '123', '123', '123', '123', '115.82420297405962', '28.90259799647703', '南昌市红谷滩区南昌T16购物中心', '115.8751052761046', '28.90259799647703', NULL, NULL, NULL, NULL, NULL, '2023-06-03 20:10:35', '2023-06-03 20:55:50', 1, 1, 4, 167.72, '2023-06-03 20:59:09', '2023-06-03 20:59:09');
INSERT INTO `order_info` VALUES (5, 1, '18379196920', NULL, NULL, NULL, '110000', NULL, NULL, '南昌市红谷滩区江西省博物馆(新馆)', NULL, NULL, '123', '123', '123', '123', '115.8884305603741', '28.711548896896954', '南昌市新建区罗亭花溪谷', '115.81184947669048', '28.711548896896954', NULL, NULL, NULL, NULL, NULL, '2023-06-03 20:10:27', NULL, NULL, NULL, 7, 164.84, '2023-06-03 20:07:06', '2023-06-03 20:07:06');
INSERT INTO `order_info` VALUES (6, 1665200598775087000, '123456789', 1, '18379196920', NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-创客大厦', 'A404', '无印良品', '小黄', '微服务', '123', '456', '115.82350795508678', '28.89837501882358', '南昌市红谷滩区南昌铜锣湾t16购物中心', '115.87611847488897', '28.89837501882358', NULL, NULL, NULL, '2023-06-04 12:26:18', NULL, NULL, '2023-06-04 12:47:37', 1, 1, 8, 163.31, '2023-06-04 12:47:10', '2023-06-04 12:47:10');
INSERT INTO `order_info` VALUES (7, 1665200598775087000, '123456789', NULL, NULL, NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-创客大厦', 'A404', '无印良品', '小黄', '微服务', '123', '456', '115.82350795508678', '28.89837501882358', '南昌市红谷滩区南昌铜锣湾t16购物中心', '115.87611847488897', '28.89837501882358', NULL, NULL, NULL, NULL, '2023-06-04 12:26:27', '2023-06-04 15:01:48', NULL, NULL, NULL, 6, 163.31, '2023-06-04 14:44:57', '2023-06-04 14:44:57');
INSERT INTO `order_info` VALUES (8, 1665200598775087000, '123456789', NULL, NULL, NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-创客大厦', 'A404', '无印良品', '小黄', '微服务', '123', '456', '115.82350795508678', '28.89837501882358', '南昌市红谷滩区南昌铜锣湾t16购物中心', '115.87611847488897', '28.89837501882358', NULL, NULL, NULL, NULL, NULL, '2023-06-04 12:27:42', NULL, NULL, NULL, 7, 163.31, '2023-06-04 11:53:32', '2023-06-04 11:53:32');
INSERT INTO `order_info` VALUES (9, 1665200598775087000, '123456789', 1, '123', NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-创客大厦', 'A404', '无印良品', '小黄', '微服务', '123', '456', '115.82350795508678', '28.89837501882358', '南昌市红谷滩区南昌铜锣湾t16购物中心', '115.87611847488897', '28.89837501882358', NULL, NULL, NULL, '2023-06-05 13:11:33', '2023-06-05 13:21:21', '2023-06-05 13:47:53', NULL, NULL, NULL, 6, 163.31, '2023-06-05 12:58:28', '2023-06-05 12:58:28');
INSERT INTO `order_info` VALUES (10, 1665200598775087000, '123456789', NULL, NULL, NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-创客大厦', 'A404', '无印良品', '小黄', '微服务', '123', '456', '115.82350795508678', '28.89837501882358', '南昌市红谷滩区南昌铜锣湾t16购物中心', '115.87611847488897', '28.89837501882358', NULL, NULL, NULL, NULL, NULL, NULL, '2023-06-04 12:49:48', 1, 1, 8, 163.31, '2023-06-04 11:53:32', '2023-06-04 11:53:32');
INSERT INTO `order_info` VALUES (11, 1, '18379196920', 1, '123', NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学', 'D2117', '保安室', '小黄', '123', '123', '123', '115.82271008013308', '28.90222905907689', '南昌市新建区南昌市湾里管理局罗亭镇人民政府', '115.79781902259587', '28.90222905907689', NULL, NULL, NULL, '2023-06-05 13:36:14', '2023-06-05 13:36:18', '2023-06-05 13:36:23', NULL, NULL, NULL, 7, 23.19, '2023-06-05 14:12:10', '2023-06-05 14:12:10');
INSERT INTO `order_info` VALUES (12, 1, '18379196920', 1, '123', NULL, '110000', NULL, NULL, '南昌市新建区江西软件职业技术大学-北门', 'D2117', '无印良品', '小黄', '123', '18379196920', '123', '115.8222753002664', '28.909163627322236', '南昌市红谷滩区南昌铜锣湾t16购物中心', '115.87611847488897', '28.909163627322236', NULL, NULL, NULL, '2023-06-10 10:23:55', '2023-06-10 10:25:08', '2023-06-10 10:25:12', NULL, NULL, NULL, 7, 170.32, '2023-06-10 10:22:31', '2023-06-10 10:22:31');
INSERT INTO `order_info` VALUES (13, 1, '18379196920', NULL, NULL, NULL, '110000', NULL, NULL, '南昌市东湖区江西中医药大学附属医院', '', '保安室', '小黄', '123', '18379196920', '123', '115.91005672653638', '28.689387486380674', '南昌市红谷滩区南昌红谷滩万达广场', '115.85676600980226', '28.689387486380674', NULL, NULL, NULL, NULL, NULL, '2023-06-10 10:41:21', '2023-06-10 10:24:53', 1, 1, 6, 48.05, '2023-06-10 10:24:47', '2023-06-10 10:24:47');
INSERT INTO `order_info` VALUES (14, 1, '18379196920', 1, '123', NULL, '110000', NULL, NULL, '南昌市东湖区江西中医药大学附属医院', '', '保安室', '小黄', '123', '18379196920', '123', '115.91005672653638', '28.689387486380674', '南昌市红谷滩区南昌红谷滩万达广场', '115.85676600980226', '28.689387486380674', NULL, NULL, NULL, NULL, NULL, '2023-06-10 10:28:47', '2023-06-10 10:24:53', 1, 1, 5, 48.05, '2023-06-10 10:32:26', '2023-06-10 10:32:26');
INSERT INTO `order_info` VALUES (19, 1, '18379196920', 1, '123', NULL, '110000', NULL, NULL, '南昌市东湖区江西中医药大学附属医院', '', '保安室', '小黄', '123', '18379196920', '123', '115.91005672653638', '28.689387486380674', '南昌市红谷滩区南昌红谷滩万达广场', '115.85676600980226', '28.689387486380674', NULL, NULL, NULL, NULL, NULL, '2023-06-10 11:25:09', '2023-06-10 10:24:53', 1, 1, 7, 48.05, '2023-06-10 10:24:47', '2023-06-10 10:24:47');

SET FOREIGN_KEY_CHECKS = 1;
