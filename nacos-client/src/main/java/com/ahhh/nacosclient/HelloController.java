package com.ahhh.nacosclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: HelloController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/28
 */
@RestController
public class HelloController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://nacos/hello", String.class);
    }
}
