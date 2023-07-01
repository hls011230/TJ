package com.hls.hlsapiuser.controller;

import com.hls.hlsapiuser.service.VerificationCodeService;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description 验证码服务
 * @Author Hls
 * @Date 2023/5/22 9:16
 **/

@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String userEmail = verificationCodeDTO.getUserPhone();
        return verificationCodeService.generateCode(userEmail);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult verificationCodeCheck(@RequestBody VerificationCodeDTO verificationCodeDTO){
        return verificationCodeService.checkCode(verificationCodeDTO.getUserPhone(),verificationCodeDTO.getVerificationCode());
    }


}
