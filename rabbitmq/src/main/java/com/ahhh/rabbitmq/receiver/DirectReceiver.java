package com.ahhh.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ahhh
 * @title: DirectReceiver
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/23
 */
@Component
public class DirectReceiver {
    /**
     * 通过 @RabbitListener 注解指定一个方法是一个消息消费方法，方法参数就是所接收到的消息
     * @param msg
     */
    @RabbitListener(queues = "hello-queue")
    public void handler(String msg) {
        System.out.println("DirectReceiver:" + msg);
    }
}
