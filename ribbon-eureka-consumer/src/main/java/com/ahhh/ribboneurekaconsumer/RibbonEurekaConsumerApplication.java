package com.ahhh.ribboneurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RibbonEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaConsumerApplication.class, args);
    }

    /**
     * 添加一个 @LoadBalanced 注解
     * 此时的 RestTemplate 就是一个具备负载均衡功能的 RestTemplate 了
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
