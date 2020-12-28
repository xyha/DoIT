package com.ahhh.rabbitmq;

import com.ahhh.rabbitmq.config.RabbitFanoutConfig;
import com.ahhh.rabbitmq.config.RabbitHeaderConfig;
import com.ahhh.rabbitmq.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ahhh
 * @title: RabbitmqApplicationTest
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/23
 */
@SpringBootTest
class RabbitmqApplicationTest {
    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    public void directTest(){
        rabbitTemplate.convertAndSend("hello-queue","direct!!!");
    }

    @Test
    public void fanoutTest(){
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"fanout!!!");
    }

    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news","小米新闻..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.news","华为新闻..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.phone","小米手机..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.phone","华为手机..");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"phone.new","手机新闻..");
    }

    @Test
    public void headerTest(){
        Message nameMsg = MessageBuilder.withBody("hello header! name-queue".getBytes()).setHeader("name", "sang").build();
        Message ageMsg = MessageBuilder.withBody("hello header! age-queue".getBytes()).setHeader("age", "99").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,nameMsg);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,ageMsg);
    }
}