package com.ahhh.resilience4jeurekaconsumer.service;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: RetryService
 * @projectName eureka-server
 * @description: 重试 AOP 方式
 *
 * @Retry(name = “retryBackendA”) 注解表示在当前所有类中开启请求失败重试功能，请求失败重试策略就是 retryBackendA ，
 * 当然这个注解也可以加在某一个具体的方法上，表示只有该方法开启请求失败重试功能。
 * @date 2020/12/16
 */
@Service
@Retry(name = "retryBackendA")
public class RetryService {
    @Autowired
    private RestTemplate restTemplate;

    public String hello(String name){
        return restTemplate.getForObject("http://eureka-producer/resilience?name={1}", String.class, name);
    }
}
