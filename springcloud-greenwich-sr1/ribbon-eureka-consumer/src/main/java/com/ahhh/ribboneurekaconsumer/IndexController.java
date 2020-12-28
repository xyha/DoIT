package com.ahhh.ribboneurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: IndexController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/15
 */
@RestController
public class IndexController{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadBalancer")
    public String load(String name){
        return restTemplate.getForObject("http://eureka-producer/index?name={1}",String.class,name);
    }

}
