package com.tulingxueyuan.stock.dao;


import com.tulingxueyuan.stock.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

//如果配置了mapperScan就不需要配置mapper
//@Mapper
public interface UserMapper {
    public SysUser getUser(@Param("username")String username,
                           @Param("password")String password);
    public SysUser getUserByName(@Param("username")String username);
}
