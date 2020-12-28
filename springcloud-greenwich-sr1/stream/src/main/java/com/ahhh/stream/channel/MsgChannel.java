package com.ahhh.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ahhh
 * @title: MsgChannel
 * @projectName eureka-server
 * @description: 自定义消息通道
 * 首先我们定义了两个消息通道的名字，两个名字是不一样的
 * 接下来定义了一个消息输出通道，什么是输出通道呢？其实就是消息发送通道
 * 最后定义了一个消息输入通道，所谓的消息输入通道就是消息接收通道
 * @date 2020/12/24
 */
public interface MsgChannel {
    String INPUT = "msgchannel-input";
    String OUTPUT = "msgchannel-output";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();
}
