package com.hls.hlsservicerider.service;


import com.hls.hlsservicerider.mapper.RiderWorkStatusMapper;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.RiderWorkStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RiderWorkStatusService {
    @Autowired
    RiderWorkStatusMapper riderWorkStatusMapper;

    public ResponseResult changeWorkStatus(Long driverId, Integer workStatus){

        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("driver_id",driverId);
        List<RiderWorkStatus> riderWorkStatuses = riderWorkStatusMapper.selectByMap(queryMap);
        RiderWorkStatus riderWorkStatus = riderWorkStatuses.get(0);

        riderWorkStatus.setWorkStatus(workStatus);

        riderWorkStatusMapper.updateById(riderWorkStatus);

        return ResponseResult.success("");
    }

    public ResponseResult<RiderWorkStatus> getWorkStatus(Long driverId) {
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("driver_id",driverId);
        List<RiderWorkStatus> riderWorkStatuses = riderWorkStatusMapper.selectByMap(queryMap);
        RiderWorkStatus riderWorkStatus = riderWorkStatuses.get(0);

        return ResponseResult.success(riderWorkStatus);
    }

}
