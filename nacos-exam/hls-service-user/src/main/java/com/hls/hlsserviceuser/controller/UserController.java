package com.hls.hlsserviceuser.controller;

import com.hls.hlsserviceuser.service.UserService;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/25 15:49
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String userPhone = verificationCodeDTO.getUserPhone();
        System.out.println("手机号："+userPhone);
        return userService.loginOrRegister(userPhone);

    }

    @GetMapping("/user/{phone}")
    public ResponseResult getUser(@PathVariable("phone") String userPhone){
        System.out.println("service-user: phone:"+userPhone);
        return userService.getUserByPhone(userPhone);
    }
}
