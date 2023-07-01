package com.hls.hlsapiuser.service;

import com.hls.hlsapiuser.remote.ServicePriceClient;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import com.hls.internalcommon.responese.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/27 16:06
 **/
@Service
@Slf4j
public class ForecastPriceService {
    @Autowired
    ServicePriceClient servicePriceClient;

    public ResponseResult forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude,
                                        String cityCode, String vehicleType ,String goodsWeight){

        log.info("出发地经度："+depLongitude);
        log.info("出发地纬度："+depLatitude);
        log.info("目的地经度："+destLongitude);
        log.info("目的地纬度："+destLatitude);

        log.info("调用计价服务，计算价格");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        forecastPriceDTO.setCityCode(cityCode);
        forecastPriceDTO.setVehicleType(vehicleType);
        forecastPriceDTO.setGoodsWeight(goodsWeight);
        ResponseResult<ForecastPriceResponse> forecast = servicePriceClient.forecast(forecastPriceDTO);

        return ResponseResult.success(forecast.getData());
    }
}
