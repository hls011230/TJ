package com.hls.hlsservicerider.controller;


import com.hls.hlsservicerider.service.RiderWorkStatusService;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.RiderWorkStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

@RestController
public class RiderWorkStatusController {
    @Autowired
    RiderWorkStatusService riderWorkStatusService;

    @PostMapping("/rider-work-status")
    public ResponseResult changeWorkStatus(@RequestBody RiderWorkStatus riderWorkStatus){

        return riderWorkStatusService.changeWorkStatus(riderWorkStatus.getRiderId(), riderWorkStatus.getWorkStatus());
    }

    @GetMapping("/work-status")
    public ResponseResult getWorkStatus(Long driverId){
        return riderWorkStatusService.getWorkStatus(driverId);
    }
}
