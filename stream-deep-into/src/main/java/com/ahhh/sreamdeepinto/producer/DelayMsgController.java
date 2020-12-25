package com.ahhh.sreamdeepinto.producer;

import com.ahhh.sreamdeepinto.channel.DelayMsgChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ahhh
 * @title: DelayMsgController
 * @projectName eureka-server
 * @description: 消息生产者
 * @date 2020/12/25
 */
@RestController
public class DelayMsgController {
    @Autowired
    DelayMsgChannel delayMsgChannel;

    @GetMapping("/delay")
    public void hello() {
        System.out.println("message send：" + new Date());
        //这里的消息生产者多了一个延迟的头字段
        delayMsgChannel.output().send(MessageBuilder.withPayload("delay message!").setHeader("x-delay", 3000).build());
    }
}
