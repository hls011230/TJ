package com.hls.hlsservicerider.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hls.hlsservicerider.mapper.RiderMapper;
import com.hls.internalcommon.constant.CommonStatusEnum;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class RiderService {
    @Autowired
    RiderMapper riderMapper;


    public ResponseResult<Rider> getRiderByPhone(String riderPhone) {
        QueryWrapper<Rider> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rider_phone",riderPhone);
        Rider rider = riderMapper.selectOne(queryWrapper);
        if (rider != null){
            return ResponseResult.success(rider);
        }
        return ResponseResult.fail(CommonStatusEnum.RIDER_NOT_EXIST.getCode(),CommonStatusEnum.RIDER_NOT_EXIST.getValue());
    }

}
