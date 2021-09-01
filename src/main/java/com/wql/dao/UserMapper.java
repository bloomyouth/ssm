package com.wql.dao;

import com.wql.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    Users searchUser(String username);
}
