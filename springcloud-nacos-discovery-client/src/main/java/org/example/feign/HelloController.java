package org.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Autowired
    private HelloService service;
    @GetMapping("/feigntest/{str}")
    public String feigntest(@PathVariable("str")String str){
        //springcloud-nacos模块往nacos上注册，当前模块进行调用
        return service.echo(str);
    }

}
