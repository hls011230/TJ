package com.hls.hlsservicepay.service;

import com.hls.hlsservicepay.remote.ServiceOrderClient;
import com.hls.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/31 18:31
 **/
@Service
public class PayService {

    @Autowired
    ServiceOrderClient serviceOrderClient;

    public void pay(Long orderId){

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pay(orderRequest);

    }



}
