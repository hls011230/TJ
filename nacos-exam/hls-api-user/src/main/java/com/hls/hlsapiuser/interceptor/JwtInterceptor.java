package com.hls.hlsapiuser.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.TokenResult;
import com.hls.internalcommon.util.JWTUtils;
import com.hls.internalcommon.util.RedisPrefixUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean result = true;
        String resutltString = "";

        String token = request.getHeader("Authorization");

        // 解析token
        TokenResult tokenResult = JWTUtils.checkToken(token);

        if (tokenResult == null){
            resutltString = "access token invalid";
            result = false;
        }else{

            // 拼接key
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();

            String tokenKey = RedisPrefixUtils.generatorTokenKey(phone,identity);
            // 从redis中取出token
            String tokenRedis = stringRedisTemplate.opsForValue().get(tokenKey);
            if ((!token.trim().equals(tokenRedis.trim()))){
                System.out.println(tokenRedis);
                System.out.println(token);
                resutltString = "access token invalid";
                result = false;
            }
        }

        if (!result){
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resutltString)).toString());
        }

        return result;
    }
}