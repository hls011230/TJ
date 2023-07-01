package com.hls.internalcommon.responese;

import lombok.Data;

@Data
public class ForecastPriceResponse {
    private double price;

    private String cityCode;

    private String vehicleType;
    
}
