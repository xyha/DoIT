package com.ahhh.eurekaconsumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ahhh
 * @title: RestController2
 * @projectName eureka-server
 * @description: POST 请求
 * @date 2020/12/14
 */
@RestController
public class RestController2 {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    private static String json = "[{\"id\":\"1\",\"roleCode\":\"1\",\"orgId\":\"1\"},{\"id\":\"2\",\"roleCode\":\"1\",\"orgId\":\"1\"},{\"id\":\"3\",\"roleCode\":\"2\",\"orgId\":\"1\"},{\"id\":\"4\",\"roleCode\":\"2\",\"orgId\":\"2\"},{\"id\":\"5\",\"roleCode\":\"3\",\"orgId\":\"2\"},{\"id\":\"6\",\"roleCode\":\"3\",\"orgId\":\"2\"}]";

    /**
     * postForEntity（）
     * 传递key/value
     * @param name
     * @return
     */
    @GetMapping("/postRest1")
    public String postRest1(String name){
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        //参数传递的第一种方式：第二个参数 map 对象中存放着请求参数 key/value
        String url = "http://" + host + ":" + port + "/postRest1";
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("name",name);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, map, String.class);

        /**

         //参数传递的第二种方式：在 post 请求中，也可以按照 get 请求的方式去传递 key/value 形式的参数
         //此时第二个参数可以直接传一个 null。
         String url = "http://" + host + ":" + port + "/postRest1?name={1}";
         ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class,name);

         */
        String body = stringResponseEntity.getBody();

        System.out.println(body);
        return body;
    }

    /**
     * postForEntity（）
     * 传递json
     * 和传递key/value相比：
     * 唯一的区别就是第二个参数的类型不同，这个参数如果是一个 MultiValueMap 的实例，则以 key/value 的形式发送，
     * 如果是一个普通对象，则会被转成 json 发送。
     * @return
     */
    @GetMapping("/postRest2")
    public String postRest2(){
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();

        String url = "http://" + host + ":" + port + "/postRest2";
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, json, String.class);
        String body = stringResponseEntity.getBody();

        System.out.println(body);
        return body;
    }




}
