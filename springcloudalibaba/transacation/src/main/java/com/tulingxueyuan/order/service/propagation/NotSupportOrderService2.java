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
public class NotSupportOrderService2 {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderHistoryMapper orderHistoryMapper;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    NotSupportOrderService2 orderService;

    @Transactional
    public int create(Order order) throws Exception {
        orderMapper.insert(order);
        try {
            orderService.createHistory(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return order.getProductId();
    }

    //如下如果不加not_supported，
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
