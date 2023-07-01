package com.hls.hlsapirider.remote;


import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.responese.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {

    @RequestMapping(method = RequestMethod.GET,value = "/numberCode/{size}")
    public ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
