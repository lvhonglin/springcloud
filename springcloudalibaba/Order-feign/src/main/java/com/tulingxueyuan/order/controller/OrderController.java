package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.feign.stock.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockFeignService service;
    @RequestMapping("/add")
    public String add(){
        String reduct = service.reduct();
        return "hello world:"+reduct;
    }
    @RequestMapping("/exception")
    public String exception(){
        String reduct = service.reduct();
        int a=1/0;
        return "hello world:"+reduct;
    }
}
