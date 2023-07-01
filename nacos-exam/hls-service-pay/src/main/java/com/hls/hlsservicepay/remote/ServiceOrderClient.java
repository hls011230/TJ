package com.hls.hlsservicepay.remote;

import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/31 18:30
 **/

@FeignClient("service-order")
public interface ServiceOrderClient {

    @RequestMapping(method = RequestMethod.POST, value = "/pay")
    public ResponseResult pay(@RequestBody OrderRequest orderRequest);

}
