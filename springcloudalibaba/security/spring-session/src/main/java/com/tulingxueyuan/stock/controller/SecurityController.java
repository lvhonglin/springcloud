package com.tulingxueyuan.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SecurityController {
    @GetMapping("login")
    public String hello(@RequestParam("name") String name, HttpServletRequest request) {
        //session在进行set的时候就会生成一个sessionId
        HttpSession session = request.getSession(true);
        session.setAttribute("name", name);
        session.setMaxInactiveInterval(20);
        return "登陆成功:" + name;
    }

    @GetMapping("get")
    public String hello(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Object name = session.getAttribute("name");

        return "获取用户名:" + (String) name+",到期时间:"+session.getMaxInactiveInterval();
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "session销毁成功";
    }
}
