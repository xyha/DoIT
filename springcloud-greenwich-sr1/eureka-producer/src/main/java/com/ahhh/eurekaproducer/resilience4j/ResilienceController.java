package com.ahhh.eurekaproducer.resilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ahhh
 * @title: ResilienceController
 * @projectName eureka-server
 * @description: 测试Resilience4j
 * @date 2020/12/16
 */
@RestController
public class ResilienceController {

    @GetMapping("/resilience")
    public String hello(String name){
        String s = "hello " + name + " !";
        System.out.println(s+">>>>>"+new Date());
        //int i = 1 / 0;
        return s;
    }
}
