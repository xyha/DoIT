package com.ahhh.resilience4jeurekaconsumer.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: RateLimeterService
 * @projectName eureka-server
 * @description: 限流器 AOP方式
 * @date 2020/12/17
 */
@Service
@RateLimiter(name = "limitBackendA")
public class RateLimiterService {
    @Autowired
    RestTemplate restTemplate;

    public String hello(String name) {
        return restTemplate.getForObject("http://eureka-producer/resilience?name={1}", String.class, name);
    }
}
