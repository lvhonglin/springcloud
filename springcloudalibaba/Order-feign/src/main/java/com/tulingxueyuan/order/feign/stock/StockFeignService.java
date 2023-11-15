package com.tulingxueyuan.order.feign.stock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service",path = "/stock")
public interface StockFeignService {
    @RequestMapping("/reduct")
    public String reduct();
}
