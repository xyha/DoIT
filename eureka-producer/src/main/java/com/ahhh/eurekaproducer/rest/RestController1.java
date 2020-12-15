package com.ahhh.eurekaproducer.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: RestController1
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/14
 */
@RestController
public class RestController1 {
    @GetMapping("/getRest1")
    public String getRest1(String name) {
        return "Get1 : " + name;
    }

    @PostMapping("/postRest1")
    public String postRest1(String name) {
        return "Post1 : " + name;
    }

    @PostMapping("/postRest2")
    public String postRest2(@RequestBody String json) {
        return "Post2 : " + json;
    }
}
