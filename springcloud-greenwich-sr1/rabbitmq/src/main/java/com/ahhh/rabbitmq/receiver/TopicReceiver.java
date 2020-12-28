package com.ahhh.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ahhh
 * @title: TopicReceiver
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/23
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "phone")
    public void handler1(String message) {
        System.out.println("PhoneReceiver:" + message);
    }

    @RabbitListener(queues = "xiaomi")
    public void handler2(String message) {
        System.out.println("XiaoMiReceiver:" + message);
    }

    @RabbitListener(queues = "huawei")
    public void handler3(String message) {
        System.out.println("HuaWeiReceiver:" + message);
    }
}
