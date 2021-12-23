package com.yjx.springcloud.controller;

import com.yjx.springcloud.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yjx
 * @Data: 2021/11/14 14:44
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@RestController
public class StoreController {

    @Autowired
    StoreDao storeDao;

    @GetMapping("/updateStore/{name}")
    @Transactional
    public int updateStore(@PathVariable("name") String name){
        return storeDao.updateStore(name);
    }
}
