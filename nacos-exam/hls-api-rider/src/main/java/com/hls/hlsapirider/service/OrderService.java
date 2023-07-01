package com.hls.hlsapirider.service;

import com.hls.hlsapirider.remote.ServiceOrderClient;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.TokenResult;
import com.hls.internalcommon.request.OrderRequest;
import com.hls.internalcommon.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 10:04
 **/
@Service
public class OrderService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult<List<OrderInfo>> getOrdersByStatus(){
        return serviceOrderClient.getOrdersByStatus("1");
    }

    public ResponseResult receiveOrder(OrderRequest orderRequest){
        return serviceOrderClient.receiveOrder(orderRequest);
    }

    public ResponseResult pickUpGoods(OrderRequest orderRequest){
        return serviceOrderClient.pickUpGoods(orderRequest);
    }

    public ResponseResult deliverGoods(OrderRequest orderRequest){
        return serviceOrderClient.deliverGoods(orderRequest);
    }

    public ResponseResult arrivedGood(OrderRequest orderRequest){
        return serviceOrderClient.arrivedGood(orderRequest);
    }

    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(String accessToken){
        // 解析accessToken，拿到手机号
        TokenResult tokenResult = JWTUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        return serviceOrderClient.getOrdersByUserPhone(phone);
    }


}
