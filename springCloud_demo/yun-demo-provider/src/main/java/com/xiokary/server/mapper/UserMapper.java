package com.xiokary.server.mapper;

import com.xiokary.server.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    public List<User> findAll();

    public User findUserById(Integer id);
}
