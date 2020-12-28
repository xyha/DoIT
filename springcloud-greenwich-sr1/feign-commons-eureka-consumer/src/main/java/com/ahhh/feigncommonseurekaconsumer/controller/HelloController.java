package com.ahhh.feigncommonseurekaconsumer.controller;

import com.ahhh.feigncommonseurekaconsumer.feignservice.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: HelloController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/15
 */
@RestController
public class HelloController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/hello")
    public String hello(String name){
        return feignService.hello(name);
    }
}
