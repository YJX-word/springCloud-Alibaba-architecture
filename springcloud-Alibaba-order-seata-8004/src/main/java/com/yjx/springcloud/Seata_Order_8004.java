package com.yjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:35
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Seata_Order_8004 {
    public static void main(String[] args) {
        SpringApplication.run(Seata_Order_8004.class,args);
    }
}
