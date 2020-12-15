package com.ahhh.eurekaproducer.model;

import lombok.Data;

/**
 * @author ahhh
 * @title: User
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/15
 */
@Data
public class User {
    private Long id;
    private String username;
    private String address;
}
