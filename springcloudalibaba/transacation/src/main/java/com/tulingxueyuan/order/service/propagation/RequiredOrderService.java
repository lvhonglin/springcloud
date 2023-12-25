package com.tulingxueyuan.order.service.propagation;

import com.tulingxueyuan.order.dao.OrderHistoryMapper;
import com.tulingxueyuan.order.dao.OrderMapper;
import com.tulingxueyuan.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RequiredOrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderHistoryMapper orderHistoryMapper;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RequiredOrderService orderService;

    @Transactional
    public int create(Order order) throws Exception {
        orderMapper.insert(order);
        try {
            //如果createHistory加了transactional注解，createHistory报错了，
            //create方法会抛出UnexpectedRollbackException异常，因为createHistory和create都是同一个事务，
            //会打印======，然后在create方法的上一层抛出异常
            orderService.createHistory(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=======================");
        return order.getProductId();
    }


    //如果加了transactional注解默认是required，如果不加就是没有事务
    @Transactional
    public int createHistory(Order order) throws Exception {
        orderHistoryMapper.insert(order);
        exceptionZero();
        return order.getProductId();
    }

    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    public void exceptionZero() {
        int a = 1 / 0;
    }

    public void exception() throws Exception {
        throw new Exception("错了");
    }
}
