package com.hls.hlsservicemap.controller;


import com.hls.hlsservicemap.service.DirectionService;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direction")
public class DriectionController {

    @Autowired
    private DirectionService directionService;

    @GetMapping("/riding")
    public ResponseResult driving(@RequestBody ForecastPriceDTO forecastPriceDTO){

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();

        return directionService.riding(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
