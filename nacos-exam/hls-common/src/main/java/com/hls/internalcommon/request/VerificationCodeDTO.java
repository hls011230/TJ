package com.hls.internalcommon.request;

import lombok.Data;

/**
 *
 * @Description 验证码
 * @Author Hls
 * @Date 2023/5/22 15:07
 **/

@Data
public class VerificationCodeDTO {
    private String userPhone;
    private String verificationCode;
    private String riderPhone;

}
