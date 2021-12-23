package com.yjx.springcloud;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2021/10/31 22:57
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "nacos-provider-8001", configuration = FooConfiguration.class) //注解表示定制nacos-provider-8001服务配置FooConfiguration
public class NacosCommer_8002 {
    public static void main(String[] args) {
        initRule("GET:http://nacos-provider-8001");
        SpringApplication.run(NacosCommer_8002.class,args);
    }
    static void initRule(String str){
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource(str);
// set limit qps to 10
        rule.setCount(2);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
