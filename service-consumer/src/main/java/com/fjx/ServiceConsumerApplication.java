package com.fjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient // 开启Eureka客户端
//@EnableCircuitBreaker  // 开启熔断器
@SpringCloudApplication  //组合注解，相当于上面的三个注解总和
@EnableFeignClients // 开启feign客户端
public class ServiceConsumerApplication {
//    @Bean
////    @LoadBalanced //开启负载均衡
////    public RestTemplate restTemplate() {
////        return new RestTemplate();
////    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }

}
