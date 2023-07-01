package com.hls.hlsservicerider.service;

import com.hls.hlsservicerider.mapper.RiderMapper;
import com.hls.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityRiderService {

    @Autowired
    RiderMapper riderMapper;

    public ResponseResult<Boolean> isAvailableRider(String cityCode){
        int i = riderMapper.selectRiderCountByCityCode(cityCode);
        if (i > 0){
            return ResponseResult.success(true);
        }else{
            return ResponseResult.success(false);
        }
    }
}
