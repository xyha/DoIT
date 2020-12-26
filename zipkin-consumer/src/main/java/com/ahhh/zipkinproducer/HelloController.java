package com.ahhh.zipkinproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: HelloController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/26
 */
@RestController
@Slf4j
public class HelloController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(String name) {
        String s = restTemplate.getForObject("http://localhost:8001/hello?name={1}", String.class, name);
        log.info(s);
        return s;
    }
}