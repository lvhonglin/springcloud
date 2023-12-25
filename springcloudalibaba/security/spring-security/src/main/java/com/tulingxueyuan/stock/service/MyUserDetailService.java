package com.tulingxueyuan.stock.service;

import com.mysql.cj.util.StringUtils;
import com.tulingxueyuan.stock.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    //该方法返回一个userDetail对象，该对象包含了用户名和密码等信息，
    // 该对象就是过滤器UsernamePasswordAuthenticationFilter来获得指定用户账号密码进行校验的对象
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isNullOrEmpty(username)){
            return null;
        }
        SysUser userByName = userService.getUserByName(username);
        if(userByName==null){
            return null;
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("user");
        User user=new User(username,userByName.getPassword(),auths);
        return user;
    }
}
