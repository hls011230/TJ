package com.hls.internalcommon.constant;


public class OrderConstants {
    // 0：订单无效
    public static final int ORDER_INVALID = 0;
    // 1：订单开始
    public static final int ORDER_START = 1;
    // 2：骑手接单
    public static final int RIDER_RECEIVE_ORDER = 2;
    // 3：骑手取货
    public static final int RIDER_TO_PICK_UP_GOODS = 3;
    // 4：骑手送货
    public static final int RIDER_TO_DELIVER_GOODS = 4;
    // 5: 骑手送达
    public static final int RIDER_ARRIVED = 5;
    // 6：乘客未支付
    public static final int USER_GETOFF = 6;
    // 8: 支付完成
    public static final int SUCCESS_PAY = 7;
    // 9.订单取消
    public static final int ORDER_CANCEL = 8;

    /**
     * 撤销类型代码
     */

    // 1.用户提前取消
    public static final int CANCEL_USER_BEFORE = 1;

}
