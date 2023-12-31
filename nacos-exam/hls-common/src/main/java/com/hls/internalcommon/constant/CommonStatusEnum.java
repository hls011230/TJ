package com.hls.internalcommon.constant;

import lombok.Getter;

public enum CommonStatusEnum {
    /**
     *  验证码错误
     */
    VERIFICATION_CODE_ERROR(1099,"验证码不正确"),

    /**
     * Token类提示：1100-1199
     */
    TOKEN_ERROR(1199,"token错误"),

    /**
     * 用户提示：1200-1299
     */
    USER_NOT_EXISTS(1200,"当前用户不存在"),

    /**
     * 骑手提示:1300-1399
     */
    CITY_RIDER_EMPTY(1300,"当前城市无可用骑手"),
    RIDER_NOT_EXIST(1301,"骑手不存在"),
    AVAILABLE_RIDER_EMPTY(1302,"可用的骑手为空"),

    /**
     * 地图信息：1400-1499
     */
    MAP_DISTRICT_ERROR(1400,"请求地图错误"),

    /**
     * 订单：1500-1599
     */
    ORDER_CANCEL_FAIL(1500,"订单取消失败"),

    /**
     *  Succeed
     */
    SUCCESS(1,"success"),

    /**
     *  Fail
     */
    FAIL(0,"fail");

    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

}
