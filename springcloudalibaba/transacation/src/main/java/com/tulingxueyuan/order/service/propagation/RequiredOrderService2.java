package com.tulingxueyuan.order.service.propagation;

import com.tulingxueyuan.order.dao.OrderHistoryMapper;
import com.tulingxueyuan.order.dao.OrderMapper;
import com.tulingxueyuan.order.model.Order;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RequiredOrderService2 {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderHistoryMapper orderHistoryMapper;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RequiredOrderService2 orderService;

    @Transactional
    public int create(Order order) throws Exception {
        orderMapper.insert(order);
        orderService.createHistory(order);
        notFoundException();
        System.out.println("=======================");
        return order.getProductId();
    }


    //如果加了transactional注解默认是required，如果不加就是没有事务
    @Transactional
    public int createHistory(Order order) throws Exception {
        orderHistoryMapper.insert(order);
        return order.getProductId();
    }

    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    public void exceptionZero() {
        int a = 1 / 0;
    }
    public void notFoundException() throws NotFoundException {
        throw new NotFoundException("dasd");
    }

    public void exception() throws Exception {
        throw new Exception("错了");
    }
}
