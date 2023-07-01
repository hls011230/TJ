package com.hls.internalcommon.request;

import lombok.Data;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 16:16
 **/
@Data
public class PushRequest {
    private Long userId;
    private String identity;
    private String content;

}
