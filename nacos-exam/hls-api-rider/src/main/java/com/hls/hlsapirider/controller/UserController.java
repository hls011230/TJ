package com.hls.hlsapirider.controller;

import com.hls.hlsapirider.service.UserService;
import com.hls.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 8:54
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
