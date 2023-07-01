package com.hls.hlsapirider.service;

import com.hls.hlsapirider.remote.ServiceRiderClient;
import com.hls.hlsapirider.remote.ServiceVerificationcodeClient;
import com.hls.internalcommon.constant.CommonStatusEnum;
import com.hls.internalcommon.constant.IdentityConstants;
import com.hls.internalcommon.constant.RiderConstants;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.VerificationCodeDTO;
import com.hls.internalcommon.responese.NumberCodeResponse;
import com.hls.internalcommon.responese.TokenResponse;
import com.hls.internalcommon.util.JWTUtils;
import com.hls.internalcommon.util.RedisPrefixUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description 验证码服务
 * @Author HLs
 * @Date 2023/5/22 10:52
 **/
@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVerificationcodeClient serviceVerificationCodeClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @Description 生成验证码，并存入redis中
     * @Author Hls.
     *
     **/
    public ResponseResult generateCode(String userPhone){
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationCodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        // 存入redis
        // key,value,过期时间
        String key = RedisPrefixUtils.generatorKeyByPhone(userPhone, IdentityConstants.RIDER_IDENTITY) ;
        // 存入redis，设置一分钟过期
        stringRedisTemplate.opsForValue().set(key,numberCode+"",10, TimeUnit.MINUTES);

        return ResponseResult.success("");
    }

    @Autowired
    ServiceRiderClient riderClient;
    public ResponseResult checkCode(String userPhone,String code){

        //生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(userPhone,IdentityConstants.RIDER_IDENTITY);
        //从redis中获取key-value
        String codeRedis =stringRedisTemplate.opsForValue().get(key);
        System.out.println(codeRedis);

        //校验验证码
        if (!code.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        //判断用户是否存在
        if (riderClient.getRiderByPhone(userPhone).getData().getIfExists() == RiderConstants.RIDER_NOT_EXIST){
            return ResponseResult.fail(CommonStatusEnum.RIDER_NOT_EXIST.getCode(),CommonStatusEnum.RIDER_NOT_EXIST.getValue());
        }

        //颁发令牌
        String token = JWTUtils.generatorToken(userPhone,IdentityConstants.RIDER_IDENTITY);

        // 将token存到redis当中
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(userPhone , IdentityConstants.RIDER_IDENTITY);
        stringRedisTemplate.opsForValue().set(accessTokenKey , token , 30, TimeUnit.DAYS);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return ResponseResult.success(tokenResponse);
    }


}
