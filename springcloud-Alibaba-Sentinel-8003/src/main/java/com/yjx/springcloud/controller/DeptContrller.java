package com.yjx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.AbstractRule;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yjx.springcloud.pojo.Dept;
import com.yjx.springcloud.service.DeptService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Yjx
 * @Data: 2021/10/29 20:42
 * @Version 1.0
 * @Project_Name: springCloud
 * @describe
 */
@RestController
public class DeptContrller {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public Boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @SneakyThrows
    @GetMapping("/dept/list")
    //fallback可以处理所有的异常除了（exceptionsToIgnore排除的异常），而bockHandler只能处理blockException定点异常
    @SentinelResource(value = "resource",fallback = "blockQueryAll",blockHandler = "exceptionQueryAll")
    public List<Dept> queryALl(){
        Random random = new Random();
//        Thread.sleep(4000);
        if(random.nextInt(3)==0){
            System.out.println("出现了自定义的异常");
            throw new Exception("出现随机数异常");
        }
        return deptService.queryALl();
    }
    //处理其他任何异常
    public List<Dept> blockQueryAll(Throwable e){
        List<Dept> list = new ArrayList<>();
        Dept dept = new Dept().setDeptno(1L).setDname(e.getMessage()).setDb_source("数据库为空");
        list.add(dept);
        return list;
    }
    //熔断和流量控制的等sentinel中包含的异常都会经过该方法，则在方法中需要自行判断属于什么异常
    public List<Dept> exceptionQueryAll(BlockException blockException){
        List<Dept> list = new ArrayList<>();
        Dept dept = new Dept().setDeptno(1L).setDname(String.valueOf(blockException.getRule())).setDb_source("出现异常，数据库为空");
        list.add(dept);
        return list;
    }


    @GetMapping("/dept/discovery")
    public Object disCovery(){

        //获取所有的服务
        List<String> services = client.getServices();
        System.out.println("discovery=>services"+services);

        //得到具体的微服务信息，通过具体的微服务Id,
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for(ServiceInstance instance:instances){
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }

        return this.client;
    }
}
