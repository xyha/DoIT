package com.ahhh.sreamdeepinto.receiver;

import com.ahhh.sreamdeepinto.channel.DelayMsgChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.Date;

/**
 * @author ahhh
 * @title: DelayMsgChannel
 * @projectName eureka-server
 * @description: 消费者
 * @date 2020/12/25
 */
@EnableBinding(DelayMsgChannel.class)
public class DelayMsgReceiver {

    @StreamListener(DelayMsgChannel.INPUT)
    public void receiver(String msg) {
        System.out.println("receive:" + msg + ">>>" + new Date());
    }

}
