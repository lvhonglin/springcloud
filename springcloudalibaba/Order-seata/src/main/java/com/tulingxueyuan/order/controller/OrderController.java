package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.model.Order;
import com.tulingxueyuan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/add")
    public String add() throws Exception {
        Order order = new Order();
        order.setProductId(9);
        order.setStatus(0);
        order.setTotalAmount(100);
        int id = orderService.create(order);
        return "下单成功:"+id;
    }

    @RequestMapping("/getOrders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

}
