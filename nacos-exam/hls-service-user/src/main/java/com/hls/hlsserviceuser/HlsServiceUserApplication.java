package com.hls.hlsserviceuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hls.hlsserviceuser.mapper")
public class HlsServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlsServiceUserApplication.class, args);
    }

}
