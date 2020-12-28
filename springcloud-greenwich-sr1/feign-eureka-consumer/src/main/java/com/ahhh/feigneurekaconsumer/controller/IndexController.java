package com.ahhh.feigneurekaconsumer.controller;

import com.ahhh.feigneurekaconsumer.feignservice.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: IndexController
 * @projectName eureka-server
 * @description: Feign的简单使用
 * @date 2020/12/15
 */
@RestController
public class IndexController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/feign")
    public String index(String name){
        return feignService.feign(name);
    }
}
