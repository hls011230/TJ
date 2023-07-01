package com.hls.hlsserviceprice.controller;

import com.hls.hlsserviceprice.service.PriceService;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import com.hls.internalcommon.responese.ForecastPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastPriceController {

    @Autowired
    private PriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult<ForecastPriceResponse> forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();
        String cityCode = forecastPriceDTO.getCityCode();
        String vehicleType = forecastPriceDTO.getVehicleType();
        String goodsWeight = forecastPriceDTO.getGoodsWeight();

        return forecastPriceService.forecastPrice(depLongitude,depLatitude,destLongitude,destLatitude,cityCode,vehicleType,goodsWeight);
    }

}
