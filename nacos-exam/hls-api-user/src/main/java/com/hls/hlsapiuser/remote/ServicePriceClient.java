package com.hls.hlsapiuser.remote;

import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import com.hls.internalcommon.responese.ForecastPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/27 16:01
 **/
@FeignClient("service-price")
public interface ServicePriceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/forecast-price")
    public ResponseResult<ForecastPriceResponse> forecast(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
