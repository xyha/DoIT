package com.ahhh.sleuth;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ahhh
 * @title: SleuthController
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/25
 */
@RestController
@Slf4j
public class SleuthController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @Autowired
    SleuthService asyncService;

    @Value("${server.port}")
    int port;

    @GetMapping("/hello")
    public String hello() {
        log.info("Doing some work");
        return "hello world";
    }

    //------------------------------同步调用------------------------------------

    /**
     * 同属于一个 TraceId，各自有各自的 SpanId
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/hi1")
    public String hi1() throws InterruptedException {
        log.info("hi1!");
        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        String s = this.restTemplate.getForObject("http://localhost:" + this.port + "/hi2", String.class);
        return "hi1/" + s;
    }

    @RequestMapping("/hi2")
    public String hi2() throws InterruptedException {
        log.info("hi2!");
        int millis = new Random().nextInt(1000);
        System.out.println(millis);
        Thread.sleep(millis);
        this.tracer.currentSpan().tag("random-sleep-millis", String.valueOf(millis));
        return "hi2";
    }


    //------------------------------异步调用------------------------------------

    @GetMapping("/async")
    public String async() throws InterruptedException {
        log.info("async");
        asyncService.backgroud();//不能方法内部调用，否则async不会异步
        return "async";
    }


}
