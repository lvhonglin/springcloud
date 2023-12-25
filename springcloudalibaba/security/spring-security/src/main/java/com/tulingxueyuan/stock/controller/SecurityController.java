package com.tulingxueyuan.stock.controller;

import com.tulingxueyuan.stock.model.SysUser;
import com.tulingxueyuan.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @Autowired
    UserService userService;
    @GetMapping("hello")
    public String hello(){
        return "hello security";
    }

    @GetMapping("getUser")
    public SysUser getUser(@RequestParam("username")String username,
                           @RequestParam("password")String password){
        SysUser user = userService.getUser(username, password);
        return user;
    }
}
