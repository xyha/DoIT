package com.ahhh.eurekaconsumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ahhh
 * @title: RestController4
 * @projectName eureka-server
 * @description: 通用方法 exchange
 * @date 2020/12/15
 */
@RestController
public class RestController4 {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    private static String json = "[{\"id\":\"1\",\"roleCode\":\"1\",\"orgId\":\"1\"},{\"id\":\"2\",\"roleCode\":\"1\",\"orgId\":\"1\"},{\"id\":\"3\",\"roleCode\":\"2\",\"orgId\":\"1\"},{\"id\":\"4\",\"roleCode\":\"2\",\"orgId\":\"2\"},{\"id\":\"5\",\"roleCode\":\"3\",\"orgId\":\"2\"},{\"id\":\"6\",\"roleCode\":\"3\",\"orgId\":\"2\"}]";

    @GetMapping("/exchange")
    public String index() {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("cookie", "Just To Java");
        HttpEntity<String> request = new HttpEntity<>(json, httpHeaders);

        String url = "http://" + host + ":" + port + "/postRest2";
        ResponseEntity<String> stringResponseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        String body = stringResponseEntity.getBody();

        System.out.println(body);
        return body;
    }
}
