package com.yjx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yjx.springcloud.pojo.Dept;
import com.yjx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/dept/list")
    @SentinelResource(value = "resource",fallback = "blockqueryALl",blockHandler = "exceptionQueryAll")
    public List<Dept> queryALl(){
        return deptService.queryALl();
    }

    public List<Dept> blockqueryALl(){
        List<Dept> list = new ArrayList<>();
        Dept dept = new Dept().setDeptno(1L).setDname("没有数据").setDb_source("数据库为空");
        list.add(dept);
        return list;
    }
    public List<Dept> exceptionQueryAll(BlockException blockException){
        List<Dept> list = new ArrayList<>();
        Dept dept = new Dept().setDeptno(1L).setDname(blockException.getMessage()).setDb_source("数据库为空");
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
