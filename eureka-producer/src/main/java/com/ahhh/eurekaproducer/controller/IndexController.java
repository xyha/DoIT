package com.ahhh.eurekaproducer.controller;

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

    @GetMapping("/index")
    public String index(String name){
        return "eureka:" + name;
    }
}
