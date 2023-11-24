package com.tulingxueyuan.stock.controller;

import com.tulingxueyuan.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;
    @RequestMapping("/reduct")
    public String reduct(@RequestBody Map<String,Integer> map, HttpServletRequest httpServletRequest){
        stockService.reduct(map.get("productId"));
        return "hello world";
    }
}
