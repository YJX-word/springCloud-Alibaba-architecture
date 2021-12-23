package com.yjx.springcloud.service;

import com.yjx.springcloud.dao.OrderDao;
import com.yjx.springcloud.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Yjx
 * @Data: 2021/12/11 14:42
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Service
public class UpdateOrder {
    @Autowired
    OrderDao orderDao;
    @Transactional
    public void updateOrder(Order order) throws InterruptedException {
//        Thread.sleep(50);
        int i = orderDao.updateOrder(order);
        Thread.sleep(6000);
        System.out.println(i);
    }
}
