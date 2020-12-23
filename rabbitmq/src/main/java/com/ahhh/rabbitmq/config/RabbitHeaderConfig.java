package com.ahhh.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ahhh
 * @title: RabbitHeaderConfig
 * @projectName eureka-server
 * @description:
 * HeadersExchange 是一种使用较少的路由策略，HeadersExchange 会根据消息的 Header 将消息路由到不同的 Queue 上，这种策略也和 routing key 无关
 * @date 2020/12/23
 */
@Configuration
public class RabbitHeaderConfig {
    public final static String HEADERNAME = "sang-header";

    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange(HEADERNAME, true, false);
    }

    @Bean
    Queue queueName() {
        return new Queue("name-queue");
    }
    @Bean
    Queue queueAge() {
        return new Queue("age-queue");
    }

    /**
     * whereAny 表示消息的 Header 中只要有一个 Header 匹配上 map 中的 key/value ，就把该消息路由到名为 “name-queue” 的 Queue 上。
     * 这里也可以使用 whereAll 方法，表示消息的所有 Header 都要匹配。whereAny 和 whereAll 实际上对应了一个名为 x-match 的属性
     * @return
     */
    @Bean
    Binding bindingName(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","sang");
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    /**
     * 表示只要消息的 Header 中包含 age ，不管 age 的值是多少，都将消息路由到名为 “age-queue” 的 Queue 上
     * @return
     */
    @Bean
    Binding bindingAge(){
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();
    }
}
