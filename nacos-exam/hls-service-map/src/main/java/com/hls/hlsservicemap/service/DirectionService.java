package com.hls.hlsservicemap.service;


import com.hls.hlsservicemap.remote.MapDirectionClient;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.responese.DirectionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService {

    @Autowired
    private MapDirectionClient mapDirectionClient;

   /**
    *
    * @Description  根据起点和终点的经纬度请求百度地图接口获取，距离和时长
    * @Param depLongitude
    * @Param depLatitude
    * @Param destLongitude
    * @Param destLatitude
    * @Author Hls.
    *
    **/
    public ResponseResult riding(String depLongitude, String depLatitude, String destLongitude, String destLatitude){

        // 调用第三方地图接口
        DirectionResponse direction = mapDirectionClient.direction(depLongitude, depLatitude, destLongitude, destLatitude);

        return ResponseResult.success(direction);
    }
}