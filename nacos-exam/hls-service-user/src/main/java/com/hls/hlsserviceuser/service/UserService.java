package com.hls.hlsserviceuser.service;

import com.hls.hlsserviceuser.mapper.UserMapper;
import com.hls.internalcommon.constant.CommonStatusEnum;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author Hls
 * @Date 2023/5/25 15:51
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResponseResult loginOrRegister(String userPhone){

        // 根据手机号查找用户信息
        Map<String,Object> map = new HashMap<>();
        map.put("user_phone",userPhone);
        List<User> users = userMapper.selectByMap(map);

        // 判断用户信息是否存在
        if (users.size() == 0){
            // 如果不存在，插入用户信息
            User user = new User();
            user.setUserName("用户"+userPhone);
            user.setUserGender((byte) 0);
            user.setUserPhone(userPhone);
            user.setState((byte) 0);

            LocalDateTime now = LocalDateTime.now();
            user.setGmtCreate(now);
            user.setGmtModified(now);

            userMapper.insert(user);
        }
        return ResponseResult.success();
    }


    public ResponseResult getUserByPhone(String userPhone){
        // 根据手机号查询用户信息
        Map<String,Object> map = new HashMap<>();
        map.put("user_phone",userPhone);
        List<User> users = userMapper.selectByMap(map);
        if (users.size() == 0){
            return ResponseResult.fail(CommonStatusEnum.USER_NOT_EXISTS.getCode(),CommonStatusEnum.USER_NOT_EXISTS.getValue());
        } else {
            User user = users.get(0);
            return ResponseResult.success(user);

        }
    }


}
