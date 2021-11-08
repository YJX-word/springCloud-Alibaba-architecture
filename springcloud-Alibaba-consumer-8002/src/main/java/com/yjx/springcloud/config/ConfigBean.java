package com.yjx.springcloud.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.yjx.springcloud.pojo.Dept;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Yjx
 * @Data: 2021/10/29 22:25
 * @Version 1.0
 * @Project_Name: springCloud
 * @describe
 */
@Configuration
public class ConfigBean {
    @LoadBalanced
    @Bean
    @SentinelRestTemplate(blockHandler = "blockHandle",fallback = "fallHandle",blockHandlerClass = ExceptionUtil.class,fallbackClass = ExceptionUtil.class)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
