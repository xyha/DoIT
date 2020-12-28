package com.ahhh.sreamdeepinto.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ahhh
 * @title: DelayMsgChannel
 * @projectName eureka-server
 * @description: 消息通道（控制定时）
 * @date 2020/12/25
 */
public interface DelayMsgChannel {
    String INPUT = "delay_msg_input";
    String OUTPUT = "delay_msg_output";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();
}
