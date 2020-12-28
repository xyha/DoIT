package com.ahhh.consulproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/index")
    public String index() {
        return "consul-producer-a";
    }
}
