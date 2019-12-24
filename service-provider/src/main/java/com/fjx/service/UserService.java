package com.fjx.service;/*
@author天赋吉运-xxx
@DESCRIPTION
@create2019-12-11
*/

import com.fjx.mapper.UserMapper;
import com.fjx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
