package com.tulingxueyuan.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

//表示是否每次查询时都动态刷新
@RefreshScope
@Service
public class NacosConfig {
    @Value("${name:lucy}")
    private String name;
    @Value("${user1.name1:lucy}")
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
