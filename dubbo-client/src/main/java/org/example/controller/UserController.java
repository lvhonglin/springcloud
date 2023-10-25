package org.example.controller;

import com.kunpeng.dubbo.server.ILoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @DubboReference(check = false,registry = {"beijing"})
    public ILoginService loginService;

    @RequestMapping("/login")
    public Response getGoods(@RequestParam("username")String username, @RequestParam("password")String password){
        try {
            String loginRes = loginService.login(username, password);
            return new Response<String>(200,"succ",loginRes);
        }catch (Exception e){
            return new Response<String>(-200,"exception","");
        }
    }

}
