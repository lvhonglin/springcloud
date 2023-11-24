package com.tulingxueyuan.order.dao;

import com.tulingxueyuan.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//如果配置了mapperScan就不需要配置mapper
//@Mapper
public interface OrderMapper {
//    public int insert(Order order);
    public List<Order> getOrders();
}
