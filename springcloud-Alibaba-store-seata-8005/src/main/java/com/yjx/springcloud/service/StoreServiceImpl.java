package com.yjx.springcloud.service;

import com.yjx.springcloud.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yjx
 * @Data: 2021/11/14 14:40
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreDao storeDao;

    @Override
    public int updateStore(String name) {
        return storeDao.updateStore(name);
    }
}
