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
public class RequiresNewOrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderHistoryMapper orderHistoryMapper;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RequiresNewOrderService orderService;

    @Transactional
    public int create(Order order) throws Exception {
        orderMapper.insert(order);
        try {
            //因为是new，会新起一个事务，所以事务报错不会导致主事务回滚
            orderService.createHistory(order);
        }catch (Exception e){
        }
        return order.getProductId();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
