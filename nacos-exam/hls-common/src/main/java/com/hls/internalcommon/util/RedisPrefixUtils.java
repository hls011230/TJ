package com.hls.internalcommon.util;

/**
 * TODO
 *
 * @Description
 * @Author Hls.
 * @Date 2023/5/24 9:41
 **/
public class RedisPrefixUtils {
    // 乘客验证码的前缀
    public static String verificationCodePrefix = "verification-code-";

    // token存储的前缀
    public static String tokenPrefix = "token-";

    // 黑名单设备号
    public static String blackDeviceCodePrefix = "black-device-";

    /*
     * @Description
     * @Param email
     * @Param identity
     * @Author Hls.
     **/
    public static String generatorKeyByPhone(String phone, String identity){
        return verificationCodePrefix + identity+ "-" + phone;
    }

    /**
     * 根据手机号和身份标识，生成token
     * @param phone
     * @param identity
     * @return
     */

    public static String generatorTokenKey(String phone , String identity){
        return tokenPrefix + phone + "-" + identity;
    }
}
