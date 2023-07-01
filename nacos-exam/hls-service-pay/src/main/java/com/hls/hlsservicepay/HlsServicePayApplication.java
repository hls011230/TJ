package com.hls.hlsservicepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class HlsServicePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlsServicePayApplication.class, args);
    }

    @PostMapping("/test")
    public String test(){
        System.out.println("支付宝回调啦");
        return "外网穿透测试";
    }

}
