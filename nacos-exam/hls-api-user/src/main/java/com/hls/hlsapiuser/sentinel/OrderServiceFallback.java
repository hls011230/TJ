package com.hls.hlsapiuser.sentinel;

import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.hls.hlsapiuser.remote.ServiceOrderClient;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.OrderRequest;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/6/5 14:21
 **/
@Component
public class OrderServiceFallback implements FallbackFactory<ServiceOrderClient> {
    @Override
    public ServiceOrderClient create(Throwable throwable) {
        return new ServiceOrderClient() {
            @Override
            public ResponseResult addOrder(OrderRequest orderRequest) {
                if (throwable instanceof FlowException) {
                    return ResponseResult.fail("");
                }

                return ResponseResult.fail("降级");
            }

            @Override
            public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(String userPhone) {
                return null;
            }

            @Override
            public ResponseResult cancel(Integer orderId, String identity) {
                if (throwable instanceof FlowException) {
                    return ResponseResult.fail("");
                }

                return ResponseResult.fail("降级");
            }
        };
    }
}
