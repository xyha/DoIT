package com.ahhh.sreamdeepinto.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ahhh
 * @title: RegChannel
 * @projectName eureka-server
 * @description: 消息通道（控制异步）
 * @date 2020/12/25
 */
public interface AsyncRegChannel {
    String INPUT = "reg-input-channel";
    String OUTPUT = "reg-output-channel";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();
}
