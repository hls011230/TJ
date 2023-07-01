package com.hls.internalcommon.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderInfo {

    /**
     * 订单ID
     */

    private int id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 骑手ID
     */
    private Long riderId;

    /**
     * 骑手手机号
     */
    private String riderPhone;

    private String vehicleType;

    /**
     * 发起地行政区划代码
     */
    private String address;

    /**
     * 订单发起时间
     */
    private LocalDateTime orderTime;

    /**
     * 预计送货时间
     */
    private LocalDateTime departTime;

    /**
     * 预计发货地点
     */
    private String departure;

    /**
     * 发货人门牌号
     */
    private String depHouseNumber;

    /**
     * 收货人门牌号
     */
    private String destHouseNumber;

    /**
     * 发货人姓名
     */
    private String depName;

    /**
     * 收货人姓名
     */
    private String destName;

    /**
     * 发货人电话
     */
    private String depPhone;

    /**
     * 收货人电话
     */
    private String destPhone;

    /**
     * 预计出发地点经度
     */
    private String depLongitude;

    /**
     * 预计出发地点纬度
     */
    private String depLatitude;

    /**
     * 预计送货地址
     */
    private String destination;

    /**
     * 预计送货地址经度
     */
    private String destLongitude;

    /**
     * 预计送货地址纬度
     */
    private String destLatitude;

    /**
     * 坐标加密标识	1:GCJ-02测绘局标准	2:WGS84 GPS标准	3:BD-09 百度标准	4:CGCS2000 北斗标准	0:其他
     */
    private Integer encrypt;

    /**
     * 接单时车辆经度
     */
    private String receiveOrderCarLongitude;

    /**
     * 接单时车辆纬度
     */
    private String receiveOrderCarLatitude;

    /**
     * 接单时间，派单成功时间
     */
    private LocalDateTime receiveOrderTime;

    /**
     * 骑手取货时间
     */
    private LocalDateTime toPickUpGoodsTime;

    /**
     * 骑手送货到达时间
     */
    private LocalDateTime riderArrivedDestinationTime;

    /**
     * 订单撤销时间
     */
    private LocalDateTime cancelTime;

    /**
     * 撤销发起者：1:用户	2:骑手
     */
    private Integer cancelOperator;

    /**
     * 撤销类型代码	1:用户提前撤销	2:骑手提前撤销
     */
    private Integer cancelTypeCode;

    /**
     * 订单状态1：订单开始 2：骑手接单 3：取到货物 4：派送 5：货物送达，未支付 6：发起收款 7: 支付完成 8.订单取消'
     */
    private Integer orderStatus;

    /**
     * 订单价格
     */
    private Double price;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;


}
