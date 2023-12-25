package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.model.Order;
import com.tulingxueyuan.order.service.OrderService;
import com.tulingxueyuan.order.service.propagation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    NestedOrderService nestedOrderService;
    @Autowired
    NestedOrderService2 nestedOrderService2;
    @Autowired
    RequiresNewOrderService requiresNewOrderService;
    @Autowired
    RequiresNewOrderService2 requiresNewOrderService2;
    @Autowired
    MandatoryOrderService mandatoryOrderService;
    @Autowired
    NotSupportOrderService notSupportOrderService;
    @Autowired
    NeverOrderService neverOrderService;
    @Autowired
    NotSupportOrderService2 notSupportOrderService2;
    @Autowired
    RequiredOrderService requiredOrderService;
    @Autowired
    RequiredOrderService2 requiredOrderService2;
    @RequestMapping("/transaction/propagation/{method}")
    public String nested(@PathVariable("method") String method) throws Exception {
        Order order = new Order();
        order.setProductId(9);
        order.setStatus(0);
        order.setTotalAmount(100);
        if (method.equalsIgnoreCase("nested")) {
            nestedOrderService.create(order);
        } else if (method.equalsIgnoreCase("nested2")) {
            nestedOrderService2.create(order);
        } else if (method.equalsIgnoreCase("new")) {
            requiresNewOrderService.create(order);
        } else if (method.equalsIgnoreCase("new2")) {
            requiresNewOrderService2.create(order);
        }else if(method.equalsIgnoreCase("mandatory")){
            mandatoryOrderService.create(order);
        }else if(method.equalsIgnoreCase("never")){
            neverOrderService.create(order);
        }else if(method.equalsIgnoreCase("not_support")){
            notSupportOrderService.create(order);
        }else if(method.equalsIgnoreCase("not_support2")){
            notSupportOrderService2.create(order);
        }else if(method.equalsIgnoreCase("required")){
            requiredOrderService.create(order);
        }else if(method.equalsIgnoreCase("required2")){
            requiredOrderService2.create(order);
        }
        return "下单成功";
    }


}
