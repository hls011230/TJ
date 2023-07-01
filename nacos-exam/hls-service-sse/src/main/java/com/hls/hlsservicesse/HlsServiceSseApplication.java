package com.hls.hlsservicesse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HlsServiceSseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlsServiceSseApplication.class, args);
    }

}
