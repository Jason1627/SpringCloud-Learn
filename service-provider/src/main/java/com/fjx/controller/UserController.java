package com.fjx.controller;/*
@author天赋吉运-xxx
@DESCRIPTION
@create2019-12-11
*/

import com.fjx.pojo.User;
import com.fjx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Integer id) {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        /*try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return this.userService.queryById(id);
    }
}
