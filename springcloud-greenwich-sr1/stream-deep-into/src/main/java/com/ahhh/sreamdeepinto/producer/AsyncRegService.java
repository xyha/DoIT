package com.ahhh.sreamdeepinto.producer;

import com.ahhh.sreamdeepinto.channel.AsyncRegChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ahhh
 * @title: RegService
 * @projectName eureka-server
 * @description: 生产者
 * @date 2020/12/25
 */
@Service
//@EnableBinding(AsyncRegChannel.class) 如果生产者消费者分开的话，这里要加个注解
public class AsyncRegService {

    @Autowired
    AsyncRegChannel regChannel;

    public Map<String, Object> reg(String email, String phone, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("phone", phone);
        regChannel.output().send(MessageBuilder.withPayload(map).build());
        map.put("msg", "验证短信已经发送，请注意查收！");
        return map;
    }

}
