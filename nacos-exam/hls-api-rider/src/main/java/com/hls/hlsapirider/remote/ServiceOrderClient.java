package com.hls.hlsapirider.remote;

import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.OrderRequest;
import com.hls.internalcommon.responese.RiderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 10:03
 **/
@FeignClient("service-order")
public interface ServiceOrderClient {
    @RequestMapping(method = RequestMethod.GET,value = "/get-orders-status/{status}")
    public ResponseResult getOrdersByStatus(@PathVariable("status") String status);

    @RequestMapping(method = RequestMethod.POST,value = "/receive-order")
    public ResponseResult receiveOrder(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/pick-up-goods")
    public ResponseResult pickUpGoods(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/deliver-goods")
    public ResponseResult deliverGoods(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.POST,value = "/arrived-goods")
    public ResponseResult arrivedGood(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/get-orders-rider/{userPhone}")
    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(@PathVariable("userPhone") String userPhone);
}
