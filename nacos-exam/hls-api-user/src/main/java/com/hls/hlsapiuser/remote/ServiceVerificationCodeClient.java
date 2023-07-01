package com.hls.hlsapiuser.remote;

import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.responese.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @Description 远程调用验证码服务
 * @Author Hls
 * @Date 2023/5/22 10:54
 **/
@FeignClient("service-verificationcode")
public interface ServiceVerificationCodeClient {
    @RequestMapping(method = RequestMethod.GET,value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
