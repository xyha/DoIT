package com.ahhh.eurekaproducer.feign;

import com.ahhh.feigncommons.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: FeignController
 * @projectName eureka-server
 * @description: 继承feign公共接口
 * @date 2020/12/15
 */
@RestController
public class FeignController2 implements HelloService {

    @Override
    public String hello(String name) {
        return "hello " + name + " !";
    }
}
