package com.hls.hlsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class HlsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlsGatewayApplication.class, args);
    }

}
