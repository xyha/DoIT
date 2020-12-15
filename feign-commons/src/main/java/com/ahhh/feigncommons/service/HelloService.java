package com.ahhh.feigncommons.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ahhh
 * @title: HelloController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/15
 */
public interface HelloService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
