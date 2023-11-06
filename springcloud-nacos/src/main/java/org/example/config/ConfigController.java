package org.example.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigController {
    @Value("${info:hello Mic}")
    private String info;
    @GetMapping("/get")
    public String get(){
        return info;
    }

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "Hello Nacos Discovery " + string;
    }

}
