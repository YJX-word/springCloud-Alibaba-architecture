package com.yjx.springcloud.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.yjx.springcloud.pojo.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:43
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Service
public class SeataService {
    @Autowired
    private RestTemplate restTemplate;

    @GlobalTransactional
    public String seataService(){
        int stores = restTemplate.getForObject("http://localhost:8005/updateStore/apple", Integer.class);
        Order order = new Order(null,"apple","1");
//        String s = JSONUtils.toJSONString(order);
        int orders = restTemplate.postForObject("http://localhost:8004/insertOrder", order, Integer.class);
        return stores+orders+" ";
    }
}
