package com.yjx.springcloud;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreakerStrategy;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2021/11/7 20:41
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel_8003 {
    public static void main(String[] args) {
        initRule("resource");
        initDegradeRule("resource");
        SpringApplication.run(Sentinel_8003.class,args);
    }
    private static void initRule(String str){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource(str);
        // set limit qps to 10
        rule.setCount(2);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
//        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
//        rule.setMaxQueueingTimeMs(20 * 1000); //设置等待时间
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
        System.out.println("FlowRule rule loaded: " + rules);
    }

    private static void initDegradeRule(String str) {  //熔断规则
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule(str)
                .setGrade(CircuitBreakerStrategy.SLOW_REQUEST_RATIO.getType())
                // Max allowed response time
                .setCount(5000) //对于慢调用策略时 单位为ms
                // Retry timeout (in second)
                .setTimeWindow(10) //设置熔断时长
                // Circuit breaker opens when slow request ratio > 60%
                .setSlowRatioThreshold(0.6)
                .setMinRequestAmount(10)  //最小的异常请求数量
                .setStatIntervalMs(20000); //统计时长
        rules.add(rule);

        DegradeRuleManager.loadRules(rules);
        System.out.println("Degrade rule loaded: " + rules);
    }

}
