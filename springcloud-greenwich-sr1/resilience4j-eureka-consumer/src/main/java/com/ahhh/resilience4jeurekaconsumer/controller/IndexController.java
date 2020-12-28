package com.ahhh.resilience4jeurekaconsumer.controller;

import com.ahhh.resilience4jeurekaconsumer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: IndexController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/16
 */
@RestController
public class IndexController {
    @Autowired
    private RetryService retryService;

    @Autowired
    private RetryService2 retryService2;

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @Autowired
    private CircuitBreakerService2 circuitBreakerService2;

    @Autowired
    private RateLimiterService rateLimiterService;

    @Autowired
    private RateLimiterService2 rateLimiterService2;


    /**
     * 调用AOP方式的retry
     *
     * @param name
     * @return
     */
    @GetMapping("/hello")
    public String hello(String name) {
        return retryService.hello(name);
    }

    /**
     * 调用编程式的retry
     *
     * @param name
     * @return
     */
    @GetMapping("/hello2")
    public String hello2(String name) {
        return retryService2.hello(name);
    }

    /**
     * 调用AOP方式的熔断器
     * @param name
     * @return
     */
    @GetMapping("/hello3")
    public String hello3(String name) {
        return circuitBreakerService.hello(name);
    }

    /**
     * 调用编程方式的熔断器
     * @param name
     * @return
     */
    @GetMapping("/hello4")
    public String hello4(String name) {
        return circuitBreakerService2.hello(name);
    }


    /**
     * 调用AOP方式的限流器
     * @param name
     * @return
     */
    @GetMapping("/hello5")
    public String hello5(String name) {
        //为了测试出效果，这里使用了一个 for 循环，循环中连续发送五次请求
        for (int i = 0; i < 5; i++) {
            rateLimiterService.hello(name);
        }
        return rateLimiterService.hello(name);
    }

    /**
     * 调用编程方式的限流器
     * @param name
     * @return
     */
    @GetMapping("/hello6")
    public String hello6(String name) {
        return rateLimiterService2.hello(name);
    }
}
