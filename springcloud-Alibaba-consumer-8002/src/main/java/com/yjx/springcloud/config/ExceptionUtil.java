package com.yjx.springcloud.config;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yjx.springcloud.pojo.Dept;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2021/11/8 16:19
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
public class ExceptionUtil {
    public static SentinelClientHttpResponse blockHandle(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException be) {
        be.printStackTrace();
        Dept dept = new Dept().setDeptno(1l).setDname("服务流量控制处理-托底数据").setDb_source("错误");
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        return new SentinelClientHttpResponse(JSON.toJSONString(list));
    }

    // 服务熔断降级处理
    public static ClientHttpResponse fallHandle(HttpRequest request,
                                                byte[] body,
                                                ClientHttpRequestExecution execution,
                                                BlockException exception) {
        exception.printStackTrace();
        Dept dept = new Dept().setDeptno(1l).setDname("服务熔断降级处理-托底数据").setDb_source("错误");
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        return new SentinelClientHttpResponse(JSON.toJSONString(list));   //接口要返回什么数据就需要返回什么数据
    }
}
