package com.ahhh.feigneurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaConsumerApplication.class, args);
    }

}
