package com.yjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Yjx
 * @Data: 2021/10/31 22:17
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider_8001.class,args);
    }
}
