package com.hls.hlsserviceorder.remote;

import com.hls.internalcommon.request.PushRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/31 19:07
 **/
@FeignClient("service-sse")
public interface ServiceSSEClient {
    @PostMapping(value = "/push")
    public String push(@RequestBody PushRequest pushRequest);
}
