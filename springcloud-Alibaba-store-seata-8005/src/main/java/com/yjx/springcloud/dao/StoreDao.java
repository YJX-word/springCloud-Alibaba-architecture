package com.yjx.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author: Yjx
 * @Data: 2021/11/14 14:36
 * @Version 1.0
 * @Project_Name: springcloud-Alibaba
 * @describe
 */
@Mapper
@Repository
public interface StoreDao {
    @Update("update store set num=num-1 where name = #{name}")
    public int updateStore(@Param("name") String name);
}
