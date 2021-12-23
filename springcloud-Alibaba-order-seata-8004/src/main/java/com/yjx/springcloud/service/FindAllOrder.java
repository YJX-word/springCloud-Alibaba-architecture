package com.yjx.springcloud.service;

import com.yjx.springcloud.dao.OrderDao;
import com.yjx.springcloud.pojo.Order;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2021/12/11 14:42
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Service
public class FindAllOrder {
    @Autowired
    OrderDao orderDao;

    @SneakyThrows
    @Transactional
    public void findAllOrder(){
        List<Order> aLl = orderDao.findALl();
//        Thread.sleep(5000);
        for(Order order:aLl){
            System.out.println(order.toString());
        }
    }
}
