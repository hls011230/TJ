package com.hls.hlsapiuser.service;

import com.hls.hlsapiuser.remote.ServiceOrderClient;
import com.hls.internalcommon.constant.IdentityConstants;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.dto.TokenResult;
import com.hls.internalcommon.request.OrderRequest;
import com.hls.internalcommon.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 15:02
 **/
@Service
public class OrderService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(String accessToken){
        // 解析accessToken，拿到手机号
        TokenResult tokenResult = JWTUtils.checkToken(accessToken);
        String phone = tokenResult.getPhone();
        return serviceOrderClient.getOrdersByUserPhone(phone);
    }

    public ResponseResult addOrder(OrderRequest orderRequest){
        return serviceOrderClient.addOrder(orderRequest);
    }


    public ResponseResult cancel(Integer orderId){
        return serviceOrderClient.cancel(orderId, IdentityConstants.USER_IDENTITY);
    }

}
