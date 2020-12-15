package com.ahhh.eurekaproducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: IndexController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/14
 */
@RestController
public class IndexController {
    @Value("${server.port}")
    private Integer port;
    @GetMapping("/index")
    public String index(String name){
        return "eureka:" + name + "  port:" + port;
    }
}
