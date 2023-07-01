package com.hls.hlsservicerider.controller;

import com.hls.hlsservicerider.service.CityRiderService;
import com.hls.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/28 15:11
 **/
@RestController
@RequestMapping("/city-rider")
public class CityRiderController {
    @Autowired
    CityRiderService cityRiderService;

    @GetMapping("/is-alailable-rider")
    public ResponseResult isAvailableRider(String cityCode){
        return cityRiderService.isAvailableRider(cityCode);
    }


}
