package com.yjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Yjx
 * @Data: 2021/11/14 14:44
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */

@SpringBootApplication
@EnableDiscoveryClient
public class Seata_Store_8005 {
    public static void main(String[] args) {
        SpringApplication.run(Seata_Store_8005.class,args);
    }
}
