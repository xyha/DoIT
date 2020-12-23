package com.ahhh.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ahhh
 * @title: RabbitConfig
 * @projectName eureka-server
 * @description:
 * DirectExchange 的路由策略是将消息队列绑定到一个 DirectExchange 上，当一条消息到达 DirectExchange 时会被转发到与该条消息 routing key 相同的 Queue 上
 * DirectExchange和Binding两个Bean的配置可以省略掉，即如果使用DirectExchange，可以只配置一个Queue的实例即可。
 * @date 2020/12/23
 */
@Configuration
public class RabbitDirectConfig {
    public static final String DIRECTNAME = "sang-direct";

    /**
     * 提供一个消息队列Queue
     * @return
     */
    @Bean
    Queue queue(){
        return new Queue("hello-queue");
    }

    /**
     * 创建一个DirectExchange对象
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        //三个参数分别是名字，重启后是否依然有效以及长期未用时是否删除
        return new DirectExchange(DIRECTNAME,true,false);
    }

    /**
     * 创建一个Binding对象将Exchange和Queue绑定在一起
     * @return
     */
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
