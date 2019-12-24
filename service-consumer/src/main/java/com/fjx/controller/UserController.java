package com.fjx.controller;/*
@author天赋吉运-xxx
@DESCRIPTION
@create2019-12-11
*/

import com.fjx.client.UserClient;
import com.fjx.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallbackMethod") //定义全局的熔断方法
public class UserController {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息
    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    @HystrixCommand //声明熔断的方法
    public String queryUserById(@RequestParam("id") Integer id) {
        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
        //List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // 因为只有一个Service-provider。所以获取第一个实例
        //ServiceInstance instance = instances.get(0);
//        if(id==41){
//            throw new RuntimeException("我太忙了");
//        }
//
//        // 获取ip和端口信息，拼接成服务地址
//        String baseUrl = "http://service-provider/user/" + id;
//        return this.restTemplate.getForObject(baseUrl, String.class);
        return this.userClient.queryById(id).toString();
    }

    public String fallbackMethod(){
        return "服务器忙，稍后重试！！！！";
    }
}
