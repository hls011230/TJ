package com.hls.hlsapiuser.remote;

import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.User;
import com.hls.internalcommon.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/25 15:26
 **/
@FeignClient("service-user")
public interface ServiceUserClient {
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/user/{phone}")
    public ResponseResult<User> getUserByPhone(@PathVariable("phone") String phone);
}
