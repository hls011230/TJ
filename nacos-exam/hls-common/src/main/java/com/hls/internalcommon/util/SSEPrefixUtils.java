package com.hls.internalcommon.util;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 16:18
 **/
public class SSEPrefixUtils {
    public static  final String sperator = "$";

    public  static String generatorSseKey(Long userId , String identity){
        return userId+sperator+identity;
    }
}
