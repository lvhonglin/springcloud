package com.tulingxueyuan.order.feign.stock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "stock-service",path = "/stock")
public interface StockFeignService {
    @RequestMapping("/reduct")
    public String reduct(@RequestBody Map<String,Integer> map);
}
