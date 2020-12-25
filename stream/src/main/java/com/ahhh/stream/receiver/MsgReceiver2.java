package com.ahhh.stream.receiver;

import com.ahhh.stream.channel.MsgChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author ahhh
 * @title: MsgReceiver2
 * @projectName eureka-server
 * @description: 消息接收器
 * 消费我们自己通道上的消息
 * @date 2020/12/24
 */
@EnableBinding(MsgChannel.class)
public class MsgReceiver2 {
    @StreamListener(MsgChannel.INPUT)
    public void receiver(Object playload) {
        System.out.println("Received2:" + playload);
    }
}
