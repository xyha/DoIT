package com.ahhh.feigneurekaconsumer.controller;

import com.ahhh.feigneurekaconsumer.feignservice.FeignService;
import com.ahhh.feigneurekaconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahhh
 * @title: FeignController
 * @projectName eureka-server
 * @description: Feign测试
 * @date 2020/12/15
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;
    @GetMapping("/hello2")
    public void hello2() {
        feignService.deleteUserById(99L);
        User u2 = feignService.getUserByName("纯洁的微笑");
        System.out.println(u2);
        u2.setId(98L);
        u2.setAddress("深圳");
        User u3 = feignService.addUser(u2);
        System.out.println(u3);
        feignService.updateUserById("lenve", 99L);
    }
}
