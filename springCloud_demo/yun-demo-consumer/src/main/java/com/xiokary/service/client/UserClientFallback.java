package com.xiokary.service.client;

import com.xiokary.service.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient{
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setUsername("服务器正忙。。。");
        return user;
    }
}
