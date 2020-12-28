package com.ahhh.sentinel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author ahhh
 * @title: HelloControllerTest
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Test
    public void contextLoads(){
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0;i<15;i++){
            String s = restTemplate.getForObject("http://localhost:8081/hello", String.class);
            System.out.println(i + ":" + s+":"+new Date());
        }
    }
}
