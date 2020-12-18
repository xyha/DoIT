package com.ahhh.resilience4jeurekaconsumer.service;

import com.ahhh.resilience4jeurekaconsumer.util.CircuitBreakerUtil;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: CircuitBreakerService
 * @projectName eureka-server
 * @description: 断路器 AOP方式
 * 目前没法进行服务容错降级，如果希望进行服务容错降级，那么还是需要通过编程实现断路器功能
 *
 * 后面的版本支持：
 *    1、首先在连接器方法上使用@CircuitBreaker(name="",fallbackMethod="")注解，其中name是要使用的熔断器的名称，fallbackMethod是要使用的降级方法，
 *    降级方法必须和原方法放在同一个类中，且降级方法的返回值需要和原方法相同，输入参数需要添加额外的exception参数
 *    2、可使用多个降级方法，保持方法名相同，同时满足的条件的降级方法会触发最接近的一个（这里的接近是指类型的接近，先会触发离它最近的子类异常），
 *    例如如果process()方法抛出CallNotPermittedException，将会触发fallBack(CallNotPermittedException e)方法而不会触发fallBack(Throwable throwable)方法。
 * @date 2020/12/16
 */
@Service
@CircuitBreaker(name = "backendA")
public class CircuitBreakerService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    public String hello(String name) {
        CircuitBreakerUtil.getCircuitBreakerStatus("服务调用前：",circuitBreakerRegistry.circuitBreaker("backendA"));
        String result = restTemplate.getForObject("http://eureka-producer/resilience?name={1}", String.class, name);
        return result;
    }
}
