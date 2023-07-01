package com.hls.hlsapiuser.controller;

import com.hls.hlsapiuser.service.UserService;
import com.hls.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Description 用户服务
 * @Author Hls
 * @Date 2023/5/25 14:24
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseResult getUser(HttpServletRequest request){

        // 从http请求中获取 accessToken
        String accessToken = request.getHeader("Authorization");

        return userService.getUserByAccessToken(accessToken);

    }
}
