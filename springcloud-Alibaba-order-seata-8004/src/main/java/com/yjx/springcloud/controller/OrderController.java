package com.yjx.springcloud.controller;

import com.yjx.springcloud.pojo.Order;
import com.yjx.springcloud.service.FindAllOrder;
import com.yjx.springcloud.service.OrderService;
import com.yjx.springcloud.service.UpdateOrder;
import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:31
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    FindAllOrder findAllOrder;

    @Autowired
    UpdateOrder updateOrder;

    @PostMapping("/insertOrder")
    @Transactional
    public int insertOrder(@RequestBody Order order){
        System.out.println(order.toString());
        System.out.println("#######################");
        return orderService.insertOrder(order);
    }

    @GetMapping("/t1")
    public void getT1() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                updateOrder.updateOrder(new Order("1","apple","7"));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                findAllOrder.findAllOrder();
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
