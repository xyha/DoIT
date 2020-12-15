package com.ahhh.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ahhh
 * @title: CallController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/14
 */
@RestController
public class CallController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(serviceInstance.getUri().toString() + "/index", String.class);
        System.out.println("调用返回结果：" + result);
        return result;
    }
}
