package com.ahhh.eurekaconsumer.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ahhh
 * @title: IndexController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/14
 */
@RestController
public class IndexController {
    /**
     * 注入一个 RestTemplate 的实例，这个 RestTemplate 将用来发送 HTTP 请求，这个工具发送 HTTP 请求比较省事一些，
     * 当然读者在这里也可以选择使用 Java 自带的 HttpUrlConnection 或者其他第三方工具来发送 HTTP 请求。
     */
    @Resource
    private RestTemplate restTemplate;

    /**
     * 首先注入一个 DiscoveryClient，DiscoveryClient 可以用来从 Eureka 或者 Consul 上根据服务名查询一个服务的详细信息，
     * 注意 DiscoveryClient 的全路径是 org.springframework.cloud.client.discovery.DiscoveryClient ，大家不要导错包。
     * 至于这个 DiscoveryClient 从哪里来，下个小节和大家细说。
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/index")
    public String index(String name) {
        //首先调用 DiscoveryClient 实例的 getInstances 方法，方法的参数就是要调用的微服务的名字，返回结果是一个 List 集合中放着 ServiceInstance 。
        //之所以是 List 集合，那是因为 provider 可能是单机部署，也可能是集群部署，如果是集群部署的话，provider 实例就会有多个。
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        //ServiceInstance 中则保存了一个实例的详细信息，例如 host、port、schema、instanceId 等，
        // ServiceInstance 也是一个接口，它有多个实现，这里使用的实现类是 EurekaServiceInstance。
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        //RestTemplate 的 getForObject 方法接收三个参数。
        //第一个参数是请求地址，请求地址中的 {1} 表示一个参数占位符，第二个参数 String.class 表示返回的参数类型，第三个参数则是一个第一个占位符的具体值。
        String result = restTemplate.getForObject("http://" + host + ":" + port + "/index?name={1}", String.class, name);
        System.out.println(result);
        return result;
    }

}
