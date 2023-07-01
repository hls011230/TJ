package com.hls.hlsapiuser.service;

import com.hls.hlsapiuser.remote.ServiceUserClient;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.TokenResult;
import com.hls.internalcommon.dto.User;
import com.hls.internalcommon.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Description 用户服务
 * @Author Hls
 * @Date 2023/5/25 15:25
 **/
@Service
@Slf4j
public class UserService {
    @Autowired
    ServiceUserClient serviceUserClient;

    public ResponseResult getUserByAccessToken(String accessToken) {
        log.info("accessToken:" + accessToken);
        // 解析accessToken，拿到手机号
        TokenResult tokenResult = JWTUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        log.info("手机号：" + phone);

        // 根据手机号查询用户信息
        ResponseResult<User> userByPhone = serviceUserClient.getUserByPhone(phone);

        return ResponseResult.success(userByPhone.getData());
    }
}
