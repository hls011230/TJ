package com.hls.hlsserviceprice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.hls.hlsserviceprice.mapper.PriceRuleMapper;
import com.hls.hlsserviceprice.remote.ServiceMapClient;
import com.hls.internalcommon.constant.CommonStatusEnum;
import com.hls.internalcommon.dto.PriceRule;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import com.hls.internalcommon.responese.DirectionResponse;
import com.hls.internalcommon.responese.ForecastPriceResponse;
import com.hls.internalcommon.util.BigDecimalUtils;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PriceService {

    @Autowired
    private ServiceMapClient serviceMapClient;

    @Autowired
    private PriceRuleMapper priceRuleMapper;

    /**
     *
     * @Description 计算预估价格
     * @Param depLongitude
     * @Param depLatitude
     * @Param destLongitude
     * @Param destLatitude
     * @Param cityCode
     * @Param vehicleType
     * @Param goodsWeight
     * @Author Hls.
     *
     **/
    public ResponseResult<ForecastPriceResponse> forecastPrice(String depLongitude, String depLatitude, String destLongitude, String destLatitude,
                                        String cityCode, String vehicleType,String goodsWeight){

        log.info("出发地经度："+depLongitude);
        log.info("出发地纬度："+depLatitude);
        log.info("目的地经度："+destLongitude);
        log.info("目的地纬度："+destLatitude);

        log.info("调用地图服务，查询距离和时长");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();
        log.info(("距离："+distance+",时长："+duration));

        log.info("读取计价规则");

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("city_code",cityCode);
        queryWrapper.eq("vehicle_type",vehicleType);

        PriceRule priceRule = priceRuleMapper.selectOne(queryWrapper);

        log.info("根据距离、时长和计价规则，计算价格");

        double price = getPrice(distance, duration, priceRule,goodsWeight);


        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        forecastPriceResponse.setCityCode(cityCode);
        forecastPriceResponse.setVehicleType(vehicleType);

        return ResponseResult.success(forecastPriceResponse);
    }

    /**
     *
     * @Description 根据距离，时长，物品重量计算价格
     * @Param distance
     * @Param duration
     * @Param priceRule
     * @Param goodsWeight
     * @Author Hls.
     *
     **/
    public double getPrice(Integer distance , Integer duration,PriceRule priceRule,String goodsWeight){
        double price = 0;

        // 起步价
        double startFare = priceRule.getStartFare();
        price = BigDecimalUtils.add(price,startFare);

        // 里程费
        // 总里程 m
        double distanceMile = BigDecimalUtils.divide(distance,1000);
        // 起步里程
        double startMile = (double)priceRule.getStartMile();
        double distanceSubtract = BigDecimalUtils.substract(distanceMile,startMile);
        // 最终收费的里程数 km
        double mile = distanceSubtract<0?0:distanceSubtract;
        // 计程单价 元/km
        double unitPricePerMile = priceRule.getUnitPricePerMile();
        // 里程价格
        double mileFare = BigDecimalUtils.multiply(mile,unitPricePerMile);
        price = BigDecimalUtils.add(price,mileFare);

        // 物品重量
        // 起步重量
        int startWeight = priceRule.getStartWeight();
        int weightSubtract = Integer.parseInt(goodsWeight) - startWeight;
        // 最终物品重量
        int weight = weightSubtract<0?0:weightSubtract;
        // 物品收费
        double uintPricePerWeight = priceRule.getUnitPricePerWeight();
        double weightFare = BigDecimalUtils.multiply((double)weight,uintPricePerWeight);
        // 重量价格
        price = BigDecimalUtils.add(price,weightFare);

        // 时长费
        // 时长的分钟数
        double timeMinute = BigDecimalUtils.divide(duration,60);
        // 计时单价
        double unitPricePerMinute = priceRule.getUnitPricePerMinute();

        // 时长费用
        double timeFare = BigDecimalUtils.multiply(timeMinute,unitPricePerMinute);
        price = BigDecimalUtils.add(price,timeFare);

        BigDecimal priceBigDecimal = new BigDecimal(price);
        priceBigDecimal = priceBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);

        return priceBigDecimal.doubleValue();
    }

//    public static void main(String[] args) {
//        PriceRule priceRule = new PriceRule();
//        priceRule.setUnitPricePerMile(1.8);
//        priceRule.setUnitPricePerMinute(0.5);
//        priceRule.setStartFare(10.0);
//        priceRule.setStartMile(3);
//
//        System.out.println(getPrice(6500,1800,priceRule));
//    }
}
