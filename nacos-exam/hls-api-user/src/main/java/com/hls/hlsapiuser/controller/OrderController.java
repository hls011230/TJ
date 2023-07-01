package com.hls.hlsapiuser.controller;

import com.hls.hlsapiuser.service.OrderService;
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
 * @Date 2023/5/29 15:01
 **/
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/get-orders")
    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(HttpServletRequest request){
        // 从http请求中获取 accessToken
        String accessToken = request.getHeader("Authorization");
        return orderService.getOrdersByUserPhone(accessToken);
    }

    @PostMapping("/add-order")
    public ResponseResult addOrder(@RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest);
        return orderService.addOrder(orderRequest);
    }

    @PostMapping("/cancel-order")
    public ResponseResult cancel(@RequestParam Integer orderId){
        return orderService.cancel(orderId);
    }


}
