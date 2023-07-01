package com.hls.hlsservicemap.remote;

import com.hls.internalcommon.constant.AmapConfigConstants;
import com.hls.internalcommon.responese.DirectionResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MapDirectionClient {

    @Value("${amap.key}")
    private String amapKey;

    @Autowired
    private RestTemplate restTemplate;

    public DirectionResponse direction(String depLongitude, String depLatitude, String destLongitude, String destLatitude){
        // 组装请求调用url
        StringBuilder urlBuild = new StringBuilder();
        urlBuild.append(AmapConfigConstants.DIRECTION_URL);
        urlBuild.append("?");
        urlBuild.append("origin="+depLatitude+","+depLongitude);
        urlBuild.append("&");
        urlBuild.append("destination="+destLatitude+","+destLongitude);
        urlBuild.append("&");
        urlBuild.append("ak="+amapKey);
        log.info(urlBuild.toString());
        // 调用百度接口
        log.info("百度地图：路径规划，请求信息："+urlBuild.toString());
        ResponseEntity<String> directionEntity = restTemplate.getForEntity(urlBuild.toString(), String.class);
        String directionString = directionEntity.getBody();
        log.info("百度地图：路径规划，返回信息："+directionString);
        // 解析接口
        DirectionResponse directionResponse = parseDirectionEntity(directionString);
        log.info(".....",directionResponse);

        return directionResponse;
    }

    // 解析返回参数
    private DirectionResponse parseDirectionEntity(String directionString){
        DirectionResponse directionResponse = null;
        try {
            // 最外层
            JSONObject result = JSONObject.fromObject(directionString);
            if(result.has(AmapConfigConstants.STATUS)) {
                int status = result.getInt(AmapConfigConstants.STATUS);
                if (status == 0){
                    if (result.has(AmapConfigConstants.RESULT)){
                        JSONObject resultJSONObject = result.getJSONObject(AmapConfigConstants.RESULT);
                        System.out.println(resultJSONObject);
                        JSONArray routeArray = resultJSONObject.getJSONArray(AmapConfigConstants.ROUTES);
                        JSONObject routeObject = routeArray.getJSONObject(0);
                        directionResponse = new DirectionResponse();

                        if (routeObject.has(AmapConfigConstants.DISTANCE)){
                            int distance = routeObject.getInt(AmapConfigConstants.DISTANCE);
                            directionResponse.setDistance(distance);
                        }
                        if (routeObject.has(AmapConfigConstants.DURATION)){
                            int duration = routeObject.getInt(AmapConfigConstants.DURATION);
                            directionResponse.setDuration(duration);
                        }
                    }
                }
            }
        }catch (Exception e){

        }
        return directionResponse;
    }
}
