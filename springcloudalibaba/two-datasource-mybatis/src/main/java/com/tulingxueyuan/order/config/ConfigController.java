package com.tulingxueyuan.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    NacosConfig nacosConfig;
    @RequestMapping("/name")
    public String add(){
        return nacosConfig.getName()+":"+nacosConfig.getUsername();
    }
}
