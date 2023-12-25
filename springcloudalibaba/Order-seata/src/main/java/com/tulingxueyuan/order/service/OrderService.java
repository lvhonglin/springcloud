package com.tulingxueyuan.order.service;

import com.tulingxueyuan.order.dao.OrderMapper;
import com.tulingxueyuan.order.feign.stock.StockFeignService;
import com.tulingxueyuan.order.model.Order;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderService orderService;
    @Autowired
    StockFeignService stockFeignService;

    @GlobalTransactional
    @GlobalLock
    public int create(Order order) throws Exception {
        //插入是否成功
        orderMapper.insert(order);
//        exceptionZero();
        //扣减库存能否成功
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("productId", order.getProductId());
        stockFeignService.reduct(map);
//        String msg = restTemplate.postForObject("http://stock-service/stock/reduct", map, String.class);
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
