package com.hls.hlsapirider.remote;

import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.Rider;
import com.hls.internalcommon.dto.User;
import com.hls.internalcommon.responese.NumberCodeResponse;
import com.hls.internalcommon.responese.RiderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 9:00
 **/
@FeignClient("service-rider")
public interface ServiceRiderClient {
    @RequestMapping(method = RequestMethod.GET,value = "/check-rider/{riderPhone}")
    public ResponseResult<RiderResponse> getRiderByPhone(@PathVariable("riderPhone") String riderPhone);

    @RequestMapping(method = RequestMethod.GET, value = "/user/{phone}")
    public ResponseResult<Rider> getUserByPhone(@PathVariable("phone") String phone);}
