package com.hls.hlsserviceprice.remote;


import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import com.hls.internalcommon.responese.DirectionResponse;
import com.sun.javafx.scene.traversal.Direction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-map")
public interface ServiceMapClient {

    @RequestMapping(method = RequestMethod.GET,value = "/direction/riding")
    public ResponseResult<DirectionResponse> direction(@RequestBody ForecastPriceDTO forecastPriceDTO);
}
