package com.hls.hlsapiuser.remote;

import com.hls.hlsapiuser.sentinel.OrderServiceFallback;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/29 15:02
 **/

@FeignClient(value =  "service-order",fallbackFactory = OrderServiceFallback.class)
public interface ServiceOrderClient {
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseResult addOrder(@RequestBody OrderRequest orderRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/get-orders-phone/{userPhone}")
    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(@PathVariable("userPhone") String userPhone);

    @RequestMapping(method = RequestMethod.POST, value = "/cancel")
    public ResponseResult cancel(@RequestParam Integer orderId , @RequestParam String identity);

}
