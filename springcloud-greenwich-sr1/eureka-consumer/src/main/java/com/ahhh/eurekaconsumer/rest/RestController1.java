package com.ahhh.eurekaconsumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

/**
 * @author ahhh
 * @title: RestController1
 * @projectName eureka-server
 * @description: GET 请求
 * @date 2020/12/14
 */
@RestController
public class RestController1 {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * getForEntity（）
     *
     * @param name
     * @return
     */
    @GetMapping("/getRest1")
    public String getRest1(String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        //参数传递的第一种方式：占位符
        String url = "http://" + host + ":" + port + "/getRest1?name={1}";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, name);

        /**

         //参数传递的第二种方式：使用map
         Map<String, Object> map = new HashMap<>();
         String url = "http://" + host + ":" + port + "/getRest1?name={name}";
         map.put("name", name);
         ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);

         //参数传递的第二种方式：使用uri。需要注意的是，这种传参方式，参数如果是中文的话，需要对参数进行编码，使用 URLEncoder.encode 方法来实现。
         String url = "http://" + host + ":" + port + "/getRest1?name="+ URLEncoder.encode(name,"UTF-8");
         URI uri = URI.create(url);
         ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

         */

        StringBuilder sb = new StringBuilder();
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        sb.append("statusCode：")
                .append(statusCode)
                .append("</br>")
                .append("body：")
                .append(body)
                .append("</br>");
        HttpHeaders headers = responseEntity.getHeaders();

        Set<String> strings = headers.keySet();
        for (String s : strings) {
            sb.append(s)
                    .append(":")
                    .append(headers.get(s))
                    .append("</br>");
        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    /**
     * getForObject（）
     *
     * @param name
     * @return
     */
    @GetMapping("/getRest2")
    public String getRest2(String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        //参数传递的第一种方式：占位符
        String url = "http://" + host + ":" + port + "/getRest1?name={1}";
        String result = restTemplate.getForObject(url, String.class, name);
        System.out.println(result);
        return result;
    }
}
