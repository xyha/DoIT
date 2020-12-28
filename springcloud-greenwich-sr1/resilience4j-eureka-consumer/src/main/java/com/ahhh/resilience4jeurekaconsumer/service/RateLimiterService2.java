package com.ahhh.resilience4jeurekaconsumer.service;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * @author ahhh
 * @title: RateLimiterService2
 * @projectName eureka-server
 * @description: 限流器 编程式
 * @date 2020/12/17
 */
@Service
public class RateLimiterService2 {
    @Autowired
    RestTemplate restTemplate;

    public String hello(String name) {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofMillis(5000))
                .limitForPeriod(1)
                .timeoutDuration(Duration.ofMillis(6000))
                .build();
        RateLimiter limitBackendB = RateLimiter.of("limitBackendB", config);
        Supplier<String> stringSupplier = RateLimiter.decorateSupplier(limitBackendB, () -> restTemplate.getForObject("http://eureka-producer/resilience?name={1}", String.class, name));
        String str = "";
        //使用 Try.of 方法执行调用，且调用多次。
        for (int i = 0; i < 5; i++) {
            Try<String> strings = Try.ofSupplier(stringSupplier);
            str = strings.get();
            System.out.println(str);
        }
        return str;
    }
}
