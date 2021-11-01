package com.yjx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: Yjx
 * @Data: 2021/10/31 23:22
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class nacosZuul_8527 {
    public static void main(String[] args) {
        SpringApplication.run(nacosZuul_8527.class,args);
    }
}
