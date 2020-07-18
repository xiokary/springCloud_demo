package com.xiokary.server.service;

import com.xiokary.server.domain.User;
import com.xiokary.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Transactional
    public User findUserById(Integer id){
        return userMapper.findUserById(id);
    }

}
