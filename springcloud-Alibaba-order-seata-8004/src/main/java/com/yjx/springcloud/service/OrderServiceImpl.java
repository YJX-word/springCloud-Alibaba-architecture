package com.yjx.springcloud.service;

import com.yjx.springcloud.dao.OrderDao;
import com.yjx.springcloud.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:29
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao;

    @Override
    public int insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }
}
