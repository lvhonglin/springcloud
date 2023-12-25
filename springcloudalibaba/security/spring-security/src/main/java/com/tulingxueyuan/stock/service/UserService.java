package com.tulingxueyuan.stock.service;

import com.tulingxueyuan.stock.dao.UserMapper;
import com.tulingxueyuan.stock.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public SysUser getUser(String username,String password){
        SysUser user = userMapper.getUser(username, password);
        return user;
    }
    public SysUser getUserByName(String username){
        SysUser user = userMapper.getUserByName(username);
        return user;
    }
}
