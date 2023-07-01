package com.hls.hlsapirider.controller;

import com.hls.hlsapirider.service.OrderService;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 13:42
 **/

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/get-orders")
    public ResponseResult<List<OrderInfo>> gerOrders(){
        return orderService.getOrdersByStatus();
    }

    @GetMapping("/get-my-orders")
    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(HttpServletRequest request){
        // 从http请求中获取 accessToken
        String accessToken = request.getHeader("Authorization");
        return orderService.getOrdersByUserPhone(accessToken);
    }

    @PostMapping("/receive-order")
    public ResponseResult receiveOrder(@RequestBody OrderRequest orderRequest){
        return orderService.receiveOrder(orderRequest);
    }

    @PostMapping("/pick-up-goods")
    public ResponseResult pickUpGoods(@RequestBody OrderRequest orderRequest){
        return orderService.pickUpGoods(orderRequest);
    }

    @PostMapping("/deliver-goods")
    public ResponseResult deliverGoods(@RequestBody OrderRequest orderRequest){
        return orderService.deliverGoods(orderRequest);
    }

    @PostMapping("/arrived-goods")
    public ResponseResult arrivedGoods(@RequestBody OrderRequest orderRequest){
        return orderService.arrivedGood(orderRequest);
    }


}
