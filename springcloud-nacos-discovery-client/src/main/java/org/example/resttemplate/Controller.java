package org.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/echo/{str}",method = RequestMethod.GET)
    public String echo(@PathVariable String str){
        //springcloud-nacos模块往nacos上注册，当前模块进行调用
        return restTemplate.getForObject("http://springcloud-dubbo/echo/"+str,String.class);
    }
}
