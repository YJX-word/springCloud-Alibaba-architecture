package com.yjx.springcloud.dao;

import com.yjx.springcloud.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2021/11/15 22:22
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Mapper
@Repository
public interface OrderDao {
    @Insert("insert into `order`(name,num) values(#{name},#{num})")
    public int insertOrder(Order order);

    @Update("update `order` set num = #{num} where name = #{name}")  //会在查询的行上加上X锁
    public int updateOrder(Order order);

    /*
    lock in share mode 会加上S锁
    for update 会加上X锁
    为空   则不加锁，是查询的快照，以前的旧版本
     */
    @Select("select * from `order` lock in share mode")   //会在查询的行上加上X锁
    public List<Order> findALl();
}
