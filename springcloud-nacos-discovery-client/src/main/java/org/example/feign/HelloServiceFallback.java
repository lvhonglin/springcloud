package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


public class HelloServiceFallback implements HelloService {
    @Override
    public String echo(String string) {
        return "调用失败了";
    }


}
