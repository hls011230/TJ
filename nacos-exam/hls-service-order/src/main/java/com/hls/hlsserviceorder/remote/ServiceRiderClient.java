package com.hls.hlsserviceorder.remote;

import com.hls.internalcommon.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/28 15:22
 **/
@FeignClient("service-rider")
public interface ServiceRiderClient {
    @GetMapping("/city-rider/is-alailable-rider")
    public ResponseResult<Boolean> isAvailableRider(@RequestParam String cityCode);
}
