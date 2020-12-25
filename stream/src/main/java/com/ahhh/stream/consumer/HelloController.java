package com.ahhh.stream.consumer;

import com.ahhh.stream.channel.MsgChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: HelloController
 * @projectName eureka-server
 * @description: 消息生产者
 * @date 2020/12/24
 */
@RestController
public class HelloController {
    @Autowired
    private MsgChannel msgChannel;

    @GetMapping("/test1")
    public void hello() {
        msgChannel.output().send(MessageBuilder.withPayload("hello stream!!!").build());
    }
}
