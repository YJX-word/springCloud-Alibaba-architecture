package com.yjx.springcloud.pojo;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:23
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
public class Order {
    private String id;
    private String name;
    private String num;

    public Order(String id, String name, String num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }


}
