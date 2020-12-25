package com.ahhh.stream.receiver;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author ahhh
 * @title: MsgReceiver
 * @projectName eureka-server
 * @description: 消息接收器
 * 首先使用了 @EnableBinding 注解实现对消息通道的绑定，哪个消息通道呢？就是参数 Sink ，事实上，这里的参数可以有多个，Sink 是一个默认定义的消息通道。
 * 然后在 MsgReceiver 类中定义了 receive 方法，并在该方法上添加了 @StreamListener 注解，该注解表示该方法为消息中间件上数据流的事件监听器，Sink.INPUT 参数表示这是 input 消息通道上的监听处理器（在 Spring Cloud Stream 中可以有多个通道）
 * @date 2020/12/24
 */
@EnableBinding(Sink.class)
public class MsgReceiver {
    @StreamListener(Sink.INPUT)
    public void receive(Object playload) {
        System.out.println("Received:" + playload);
    }
}

