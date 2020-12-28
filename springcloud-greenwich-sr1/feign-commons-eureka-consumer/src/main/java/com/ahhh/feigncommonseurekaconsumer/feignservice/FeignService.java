package com.ahhh.feigncommonseurekaconsumer.feignservice;

import com.ahhh.feigncommons.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author ahhh
 * @title: FeignService
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/15
 */
@FeignClient("eureka-producer")
public interface FeignService extends HelloService {

}
