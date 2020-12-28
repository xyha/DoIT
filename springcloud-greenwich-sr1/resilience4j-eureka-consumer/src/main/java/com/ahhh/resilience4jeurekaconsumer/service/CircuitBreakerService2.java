package com.ahhh.resilience4jeurekaconsumer.service;

import com.ahhh.resilience4jeurekaconsumer.util.CircuitBreakerUtil;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author ahhh
 * @title: CircuitBreakerService2
 * @projectName eureka-server
 * @description: 断路器 编程式
 * @date 2020/12/16
 */
@Service
public class CircuitBreakerService2 {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CircuitBreakerRegistry circuitBreakerRegistry;


    public String hello(String name) {
        //首先利用 Java 代码创建一个 CircuitBreakerConfig 出来，然后配置一下故障率阈值，等待时间以及环形缓冲区大小等；
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .ringBufferSizeInHalfOpenState(20)
                .ringBufferSizeInClosedState(20)
                .build();
        //根据第一步创建出来的 CircuitBreakerConfig ，再去创建一个 CircuitBreaker 对象；
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("backendB", circuitBreakerConfig);
        CircuitBreakerUtil.getCircuitBreakerStatus("服务调用前：",circuitBreaker);
        //通过 Try.ofSupplier 方法去发送一个请求，如果请求抛出异常，则在 recover 方法中进行服务降级处理，recover 可以写多个。
        Try<String> recover = Try.ofSupplier(CircuitBreaker
                .decorateSupplier(circuitBreaker,
                        () -> restTemplate.getForObject("http://eureka-producer/resilience?name={1}", String.class, name)))
                .recover(Exception.class, "有异常，访问失败");
        return recover.get();
    }
}
