package com.tulingxueyuan.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/stock")
public class StockController {
    public static AtomicInteger num=new AtomicInteger();
    @RequestMapping("/reduct")
    public String reduct(HttpServletRequest httpServletRequest){
        System.out.println("扣减库存:"+num);
        return "hello world";
    }
}
