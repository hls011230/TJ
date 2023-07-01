package com.hls.hlsserviceorder.controller;


import com.hls.hlsserviceorder.service.OrderInfoService;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest){
        return orderInfoService.add(orderRequest);
    }

    @GetMapping("/get-orders-status/{status}")
    public ResponseResult<List<OrderInfo>> getOrdersByStatus(@PathVariable("status") String status){
        return orderInfoService.getOrdersByStatus(status);
    }


    @GetMapping("/get-orders-phone/{userPhone}")
    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(@PathVariable("userPhone") String userPhone){
        return orderInfoService.getOrdersByUserPhone(userPhone);
    }

    @GetMapping("/get-orders-rider/{userPhone}")
    public ResponseResult<List<OrderInfo>> getOrdersByRiderPhone(@PathVariable("userPhone") String userPhone){
        return orderInfoService.getOrdersByRiderPhone(userPhone);
    }

    @GetMapping("/detail")
    public ResponseResult<OrderInfo> detail(Long orderId){
        return orderInfoService.detail(orderId);
    }

    @PostMapping("/receive-order")
    public ResponseResult receiveOrder(@RequestBody OrderRequest orderRequest){
        return orderInfoService.receiveOrder(orderRequest);
    }

    @PostMapping("/pick-up-goods")
    public ResponseResult pickUpGoods(@RequestBody OrderRequest orderRequest){
        return orderInfoService.pickUpGoods(orderRequest);
    }

    @PostMapping("/deliver-goods")
    public ResponseResult deliverGoods(@RequestBody OrderRequest orderRequest){
        return orderInfoService.deliverGoods(orderRequest);
    }

    @PostMapping("/arrived-goods")
    public ResponseResult arrivedGood(@RequestBody OrderRequest orderRequest){
        return orderInfoService.arrivedGood(orderRequest);
    }

    @PostMapping("/pay")
    public ResponseResult pay(@RequestBody OrderRequest orderRequest){
        return orderInfoService.pay(orderRequest);
    }


    @PostMapping("/cancel")
    public ResponseResult cancel(Integer orderId, String identity){
        return orderInfoService.cancel(orderId,identity);
    }

}
