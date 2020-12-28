package com.ahhh.feigncommonseurekaconsumer.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ahhh
 * @title: FeignConfig
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/15
 */
@Configuration
public class FeignConfig {

    /**
     * 配置日志等级
     *
     * 第一步：
     *
     * Feign 中的日志级别一共分为四种：
     *
     * NONE ，不开启日志记录，默认即此；
     * BASIC ，记录请求方法和请求 URL ，以及响应的状态码以及执行时间；
     * HEADERS ，在第2条的基础上，再增加请求头和响应头；
     * FULL ，在第3条的基础上再增加 body 以及元数据。
     *
     * @return
     */
    @Bean
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }


    /**
     * 实现请求重试
     *
     * 不用配置application.properties
     * @return
     */
    //@Bean
    public Retryer retryer(){
        Retryer.Default retryer = new Retryer.Default();
        return retryer;
    }

}
