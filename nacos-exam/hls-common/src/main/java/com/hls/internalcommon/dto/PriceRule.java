package com.hls.internalcommon.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PriceRule implements Serializable {

    private String cityCode;

    private String vehicleType;

    private Double startFare;

    private Integer startMile;

    private Integer startWeight;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;

    private Double unitPricePerWeight;


}
