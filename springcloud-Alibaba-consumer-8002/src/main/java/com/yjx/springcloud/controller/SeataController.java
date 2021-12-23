package com.yjx.springcloud.controller;

import com.yjx.springcloud.Service.SeataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:40
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@RestController
public class SeataController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SeataService seataService;
    @GetMapping("/seata")
    public String seata(){
       return seataService.seataService();
    }
}
