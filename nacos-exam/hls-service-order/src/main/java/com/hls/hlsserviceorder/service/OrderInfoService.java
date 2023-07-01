package com.hls.hlsserviceorder.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hls.hlsserviceorder.mapper.OrderInfoMapper;
import com.hls.hlsserviceorder.remote.ServicePriceClient;
import com.hls.hlsserviceorder.remote.ServiceRiderClient;
import com.hls.hlsserviceorder.remote.ServiceSSEClient;
import com.hls.internalcommon.constant.CommonStatusEnum;
import com.hls.internalcommon.constant.IdentityConstants;
import com.hls.internalcommon.constant.OrderConstants;
import com.hls.internalcommon.constant.RiderConstants;
import com.hls.internalcommon.dto.OrderInfo;
import com.hls.internalcommon.dto.ResponseResult;
import com.hls.internalcommon.request.ForecastPriceDTO;
import com.hls.internalcommon.request.OrderRequest;
import com.hls.internalcommon.request.PushRequest;
import com.hls.internalcommon.responese.ForecastPriceResponse;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author ASUS
 * @Date 2023/5/30 12:23
 **/

@Service
@Slf4j
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    ServiceRiderClient serviceRiderClient;

    @Autowired
    ServicePriceClient servicePriceClient;

    @Autowired
    ServiceSSEClient serviceSSEClient;


    public ResponseResult add(@RequestBody OrderRequest orderRequest){

        // 查看当前城市是否有可用的骑手
        ResponseResult<Boolean> availableDriver = serviceRiderClient.isAvailableRider(orderRequest.getAddress());
        log.info("测试城市是否有司机结果："+availableDriver.getData());
        if (!availableDriver.getData()){
            return ResponseResult.fail(CommonStatusEnum.CITY_RIDER_EMPTY.getCode(),CommonStatusEnum.CITY_RIDER_EMPTY.getValue());
        }

        System.out.println(orderRequest);

        // 创建订单
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderRequest,orderInfo);

        orderInfo.setOrderStatus(OrderConstants.ORDER_START);
        LocalDateTime now = LocalDateTime.now();
        orderInfo.setGmtCreate(now);
        orderInfo.setGmtModified(now);
        orderInfoMapper.insert(orderInfo);

        return ResponseResult.success();
    }


    public ResponseResult<List<OrderInfo>> getOrdersByStatus(@PathVariable("status") String status){

        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_status",status);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        return ResponseResult.success(orderInfos);
    }



    public ResponseResult<List<OrderInfo>> getOrdersByUserPhone(@PathVariable("userPhone") String userPhone){

        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_phone",userPhone);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        return ResponseResult.success(orderInfos);
    }

    public ResponseResult<List<OrderInfo>> getOrdersByRiderPhone(@PathVariable("userPhone") String userPhone){

        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rider_phone",userPhone);
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(queryWrapper);

        return ResponseResult.success(orderInfos);
    }


    public ResponseResult<OrderInfo> detail(Long orderId){
        OrderInfo orderInfo =  orderInfoMapper.selectById(orderId);
        return ResponseResult.success(orderInfo);
    }


    public ResponseResult receiveOrder(@RequestBody OrderRequest orderRequest){

        Long orderId = orderRequest.getOrderId();
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        LocalDateTime now = LocalDateTime.now();
        orderInfo.setRiderId(orderRequest.getRiderId());
        orderInfo.setRiderPhone(orderRequest.getRiderPhone());
        orderInfo.setReceiveOrderTime(now);
        orderInfo.setOrderStatus(OrderConstants.RIDER_RECEIVE_ORDER);
        orderInfoMapper.updateById(orderInfo);

        return ResponseResult.success();
    }


    public ResponseResult pickUpGoods(@RequestBody OrderRequest orderRequest){

        Long orderId = orderRequest.getOrderId();
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        LocalDateTime now = LocalDateTime.now();
        orderInfo.setOrderStatus(OrderConstants.RIDER_TO_PICK_UP_GOODS);
        orderInfo.setToPickUpGoodsTime(now);
        orderInfoMapper.updateById(orderInfo);

        return ResponseResult.success();
    }


    public ResponseResult deliverGoods(@RequestBody OrderRequest orderRequest){

        Long orderId = orderRequest.getOrderId();
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        orderInfo.setOrderStatus(OrderConstants.RIDER_TO_DELIVER_GOODS);
        orderInfoMapper.updateById(orderInfo);

        return ResponseResult.success();
    }


    public ResponseResult arrivedGood(@RequestBody OrderRequest orderRequest){

        Long orderId = orderRequest.getOrderId();
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        LocalDateTime now = LocalDateTime.now();
        orderInfo.setOrderStatus(OrderConstants.RIDER_ARRIVED);
        orderInfo.setRiderArrivedDestinationTime(now);
        orderInfoMapper.updateById(orderInfo);

        // 货物送达后发送支付链接
        // 封装消息
        JSONObject message = new JSONObject();
        message.put("price",orderInfo.getPrice());
        message.put("orderId",orderId);

        // 修改订单状态
        orderInfo.setOrderStatus(OrderConstants.USER_GETOFF);
        orderInfoMapper.updateById(orderInfo);
        PushRequest pushRequest = new PushRequest();
        pushRequest.setContent(message.toString());
        pushRequest.setUserId(orderInfo.getUserId());
        pushRequest.setIdentity(IdentityConstants.USER_IDENTITY);

        // 推送消息
        serviceSSEClient.push(pushRequest);
        return ResponseResult.success();

    }

    public ResponseResult pay(OrderRequest orderRequest){
        Long orderId = orderRequest.getOrderId();
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);

        orderInfo.setOrderStatus(OrderConstants.SUCCESS_PAY);
        orderInfoMapper.updateById(orderInfo);
        return ResponseResult.success();
    }

    public ResponseResult cancel(Integer orderId, String identity){
        // 查询订单当前状态
        OrderInfo orderInfo = orderInfoMapper.selectById(orderId);
        Integer orderStatus = orderInfo.getOrderStatus();

        LocalDateTime cancelTime = LocalDateTime.now();
        Integer cancelOperator = null;
        Integer cancelTypeCode = null;

        // 正常取消
        int cancelType = 1;

        // 更新订单的取消状态
        // 如果是乘客取消
        if (identity.trim().equals(IdentityConstants.USER_IDENTITY)){
            switch (orderStatus){
                // 订单开始
                case OrderConstants.ORDER_START:
                    cancelTypeCode = OrderConstants.CANCEL_USER_BEFORE;
                    break;
                default:
                    log.info("乘客取消失败");
                    cancelType = 0;
                    break;
            }
        }



        if (cancelType == 0){
            return ResponseResult.fail(CommonStatusEnum.ORDER_CANCEL_FAIL.getCode(),CommonStatusEnum.ORDER_CANCEL_FAIL.getValue());
        }

        orderInfo.setCancelTypeCode(cancelTypeCode);
        orderInfo.setCancelTime(cancelTime);
        orderInfo.setCancelOperator(Integer.parseInt(identity));
        orderInfo.setOrderStatus(OrderConstants.ORDER_CANCEL);

        orderInfoMapper.updateById(orderInfo);
        return ResponseResult.success();
    }

}
