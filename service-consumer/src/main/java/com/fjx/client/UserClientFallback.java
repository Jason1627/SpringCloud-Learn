package com.fjx.client;/*
@author天赋吉运-Jason
@DESCRIPTION
@create2019-12-16
*/

import com.fjx.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setUsername("服务器忙");
        return user;
    }
}
