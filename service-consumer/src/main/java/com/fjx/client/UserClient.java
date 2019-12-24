package com.fjx.client;/*
@author天赋吉运-Jason
@DESCRIPTION
@create2019-12-16
*/

import com.fjx.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider",fallback = UserClientFallback.class) // 标注该类是一个feign接口
public interface UserClient {
    // 该方法和服务提供者的一致
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Integer id);
}
