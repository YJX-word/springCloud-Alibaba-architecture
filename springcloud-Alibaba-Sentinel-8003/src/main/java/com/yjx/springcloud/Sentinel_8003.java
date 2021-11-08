package com.yjx.springcloud;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
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
        SpringApplication.run(Sentinel_8003.class,args);
    }
    static void initRule(String str){
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource(str);
// set limit qps to 10
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
