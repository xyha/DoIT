package com.ahhh.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ahhh
 * @title: RabbitTopicConfig
 * @projectName eureka-server
 * @description:
 * TopicExchange 是比较复杂但也是比较灵活的一种路由策略，在 TopicExchange 中，Queue 通过 routing key 绑定到 TopicExchange 上，当消息到达 TopicExchange 后，TopicExchange 根据消息的 routing key 将消息路由到一个或者多个 Queue上
 * @date 2020/12/23
 */
@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME = "sang-topic";

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }

    @Bean
    Queue xiaomi() {
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawei() {
        return new Queue("huawei");
    }

    @Bean
    Queue phone() {
        return new Queue("phone");
    }

    /**
     * Binding 中的 “xiaomi.#” 表示消息的 routing key 凡是以 “xiaomi” 开头的，都将被路由到名称为 “xiaomi” 的 Queue 上
     * @return
     */
    @Bean
    Binding xiaomiBinding() {
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                .with("xiaomi.#");
    }

    /**
     * Binding 中的 “huawei.#” 表示消息的 routing key 凡是以 “huawei” 开头的，都将被路由到名称为 “huawei” 的 Queue 上
     * @return
     */
    @Bean
    Binding huaweiBinding() {
        return BindingBuilder.bind(huawei()).to(topicExchange())
                .with("huawei.#");
    }

    /**
     * Binding 中的 “#.phone.#” 则表示消息的 routing key 中凡是包含 “phone” 的，都将被路由到名称为 “phone” 的 Queue 上
     * @return
     */
    @Bean
    Binding phoneBinding() {
        return BindingBuilder.bind(phone()).to(topicExchange())
                .with("#.phone.#");
    }
}
