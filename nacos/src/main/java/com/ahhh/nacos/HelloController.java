package com.ahhh.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: HelloController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/28
 */
@RestController
@RefreshScope
public class HelloController {
    @Value(value = "${name}")
    String name;

    @GetMapping("/hello")
    public String hello() {
        return "hello " + name;
    }
}
