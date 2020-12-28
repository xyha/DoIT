package com.ahhh.resilience4jeurekaconsumer.service;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author ahhh
 * @title: RetryService2
 * @projectName eureka-server
 * @description: 重试 编程式
 * @date 2020/12/16
 */
@Service
public class RetryService2 {

    @Autowired
    private RestTemplate restTemplate;

    public String hello(String name) {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(5000))
                .build();
        Retry retry = Retry.of("id", config);
        Try<String> result = Try.ofSupplier(Retry.decorateSupplier(retry, () -> restTemplate.getForObject("http://eureka-producer/resilience?name={1}", String.class, name)));
        return result.get();
    }

}
