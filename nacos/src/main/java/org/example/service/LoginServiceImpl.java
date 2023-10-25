package org.example.service;


import com.kunpeng.dubbo.server.ILoginService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(registry = {"beijing"})
public class LoginServiceImpl implements ILoginService {

    public String login(String username, String password) {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        if(username.equals("test")&&password.equals("admin")){
            return "succ";
        }else{
            return "fail";
        }
    }
}