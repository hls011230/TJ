package com.hls.hlsapiuser.controller;

import com.hls.hlsapiuser.service.ForecastPriceService;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description 估价服务
 * @Author Hls
 * @Date 2023/5/27 15:57
 **/
@RestController
public class ForecastPriceController {

    @Autowired
    ForecastPriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){

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
