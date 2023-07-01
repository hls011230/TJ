package com.hls.internalcommon.request;

import lombok.Data;

/**
 * @Description 预估价格
 * @Author ASUS
 * @Date 2023/5/26 16:53
 **/
@Data
public class ForecastPriceDTO {
    private String depLongitude;

    private String depLatitude;

    private String destLongitude;

    private String destLatitude;

    private String cityCode;

    private String vehicleType;

    private String goodsWeight;
}
