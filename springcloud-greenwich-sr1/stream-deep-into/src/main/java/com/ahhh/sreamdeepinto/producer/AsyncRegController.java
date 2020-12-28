package com.ahhh.sreamdeepinto.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ahhh
 * @title: RegController
 * @projectName eureka-server
 * @description: 注册接口
 * @date 2020/12/25
 */
@RestController
public class AsyncRegController {
    @Autowired
    AsyncRegService regService;

    @PostMapping("/doReg")
    public Map<String, Object> reg(String email, String phone, String password) {
        return regService.reg(email, phone, password);
    }

}
