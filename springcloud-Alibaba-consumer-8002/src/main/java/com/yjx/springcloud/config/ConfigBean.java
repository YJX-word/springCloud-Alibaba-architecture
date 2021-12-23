package com.yjx.springcloud.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
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
    //IRule
    /*
    AvailabilityFilteringRule :会过滤掉，崩溃的服务，对剩下的进行轮询
    RoundRobinRule ：轮询 默认
    RoundRobinRule ：随机
    WeightedResponseTimeRule ：权重
    RetryRule: 会按照轮询服务，会在一定的时间内重试故障的服务
     */
//    @LoadBalanced
    @Bean
    @SentinelRestTemplate(blockHandler = "blockHandle",fallback = "fallHandle",blockHandlerClass = ExceptionUtil.class,fallbackClass = ExceptionUtil.class)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RoundRobinRule(); //使用随机算法
    }
}
