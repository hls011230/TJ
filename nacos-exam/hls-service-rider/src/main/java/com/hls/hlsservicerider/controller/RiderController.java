package com.hls.hlsservicerider.controller;


import com.hls.hlsservicerider.service.RiderService;
import com.hls.internalcommon.constant.CommonStatusEnum;
import com.hls.internalcommon.constant.RiderConstants;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.Rider;
import com.hls.internalcommon.responese.RiderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hls
 * @since 2023-05-28
 */
@RestController
public class RiderController {
    @Autowired
    RiderService riderService;

    @GetMapping("/check-rider/{riderPhone}")
    public ResponseResult getUser(@PathVariable("riderPhone") String riderPhone){

        ResponseResult<Rider> rider = riderService.getRiderByPhone(riderPhone);

        RiderResponse riderResponse = new RiderResponse();

        int isExist = RiderConstants.RIDER_EXIST;

        if (rider == null){
            riderResponse.setDriverPhone(riderPhone);
            isExist = RiderConstants.RIDER_NOT_EXIST;
            riderResponse.setIfExists(isExist);
        }else {
            riderResponse.setIfExists(isExist);
            riderResponse.setDriverPhone(riderPhone);
        }

        return ResponseResult.success(riderResponse);
    }

    @GetMapping("/user/{phone}")
    public ResponseResult getRiderByPhone(@PathVariable("phone") String userPhone){
        System.out.println("service-user: phone:"+userPhone);
        return riderService.getRiderByPhone(userPhone);
    }


}
