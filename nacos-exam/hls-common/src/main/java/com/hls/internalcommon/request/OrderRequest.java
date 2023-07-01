package com.hls.internalcommon.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {

    private Long orderId;

    private Long userId;


    private String userPhone;

    private Long riderId;


    private String riderPhone;

    private String vehicleType;

    private String address;



    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departTime;


    private String departure;


    private String depHouseNumber;


    private String destHouseNumber;


    private String depName;


    private String destName;

    private String depPhone;


    private String destPhone;


    private String depLongitude;

    private String depLatitude;


    private String destination;


    private String destLongitude;


    private String destLatitude;

    private Integer encrypt;

    private String receiveOrderCarLongitude;


    private String receiveOrderCarLatitude;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receiveOrderTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toPickUpGoodsTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime riderArrivedDestinationTime;


    private Integer cancelOperator;


    private Integer cancelTypeCode;

    private Integer orderStatus;

    private Double price;


}