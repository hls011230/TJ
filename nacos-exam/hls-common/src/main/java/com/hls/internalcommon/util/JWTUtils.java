package com.hls.internalcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hls.internalcommon.dto.TokenResult;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description JWT工具
 * @Author ASUS
 * @Date 2023/5/25 16:35
 **/
public class JWTUtils {

    // 盐
    private static final String SIGN = "hls@www.com";

    private static final String JWT_KEY_PHONE = "phone";

    // 用户是1，骑手是2
    private static final String JWT_KEY_IDENTITY = "identity";

    private static final String JWT_TOKEN_TYPE = "tokenType";

    private static final String JWT_TOKEN_TIME = "tokenTime";

    /**
     *
     * @Description 生成token
     * @Param phone
     * @Param identity
     * @Param tokenType
     * @Author Hls.
     *
     **/
    public static String generatorToken(String phone , String identity) {
        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY_PHONE,phone);
        map.put(JWT_KEY_IDENTITY, identity);
        // 防止每次生成的token一样。
        map.put(JWT_TOKEN_TIME, Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();
        // 整合map
        map.forEach(
                (k,v) -> {
                    builder.withClaim(k,v);
                }
        );

        // 生成 token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }


    /**
     *
     * @Description 解析token
     * @Param token
     * @Author Hls.
     *
     **/
    public static TokenResult parseToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String phone = verify.getClaim(JWT_KEY_PHONE).asString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).asString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setPhone(phone);
        tokenResult.setIdentity(identity);
        return tokenResult;

    }

    /**
     *
     * @Description 判断token
     * @Param token
     * @Author Hls.
     *
     **/
    public static TokenResult checkToken(String token){
        TokenResult tokenResult = null;
        try {
            tokenResult = JWTUtils.parseToken(token);
        }catch (Exception e){

        }
        return tokenResult;
    }

    // 测试jwt
    public static void main(String[] args) {

        String s = generatorToken("18379196920" , "1");
        System.out.println("生成的token："+s);
        System.out.println("解析-----------------");
        TokenResult tokenResult = parseToken(s);
        System.out.println("手机号："+tokenResult.getPhone());
        System.out.println("身份："+tokenResult.getIdentity());
    }
}
