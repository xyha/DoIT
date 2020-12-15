package com.ahhh.eurekaconsumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author ahhh
 * @title: RestController
 * @projectName eureka-server
 * @description: 设置拦截器
 * @date 2020/12/15
 */
@RestController
public class RestController3 {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    private static String json = "[{\"id\":\"1\",\"roleCode\":\"1\",\"orgId\":\"1\"},{\"id\":\"2\",\"roleCode\":\"1\",\"orgId\":\"1\"},{\"id\":\"3\",\"roleCode\":\"2\",\"orgId\":\"1\"},{\"id\":\"4\",\"roleCode\":\"2\",\"orgId\":\"2\"},{\"id\":\"5\",\"roleCode\":\"3\",\"orgId\":\"2\"},{\"id\":\"6\",\"roleCode\":\"3\",\"orgId\":\"2\"}]";


    @GetMapping("/interceptor")
    public String index(){
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        restTemplate.setInterceptors(Collections.singletonList(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                HttpHeaders headers = httpRequest.getHeaders();
                headers.add("cookie","just To Java");
                return clientHttpRequestExecution.execute(httpRequest,bytes);
            }
        }));
        String url = "http://" + host + ":" + port + "/postRest2";
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, json, String.class);
        String body = stringResponseEntity.getBody();

        System.out.println(body);
        return body;
    }
}
