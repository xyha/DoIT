package com.ahhh.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: IndexController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/22
 */
@RestController
public class IndexController {
    @Value("${javaboy}")
    String value;

    @GetMapping("/index")
    public String index(){
        return value;
    }
}
