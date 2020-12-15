package com.ahhh.eurekaproducer.feign;

import com.ahhh.eurekaproducer.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author ahhh
 * @title: FeignConteoller
 * @projectName eureka-server
 * @description: Feign测试
 * 在开发中，参数传递无非就是 key/value 形式的参数、放在 body 中的参数、放在 Url 路径上的参数以及放在请求头上的参数，这四种是较为常见的四种传参方式
 * @date 2020/12/15
 */
@RestController
public class FeignConteoller {
    /**
     * 将参数放在 Url 路径中
     * @param id
     */
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        System.out.println(id);
    }

    /**
     * 将参数以 key/value 的形式传递
     * @param name
     * @return
     */
    @GetMapping("/user")
    public User getUserByName(@RequestParam String name) {
        User user = new User();
        user.setUsername(name);
        return user;
    }

    /**
     * 参数将以请求体的方式传递
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return user;
    }

    /**
     * 参数以请求头的方式传递，这种传递方式注意不能传递中文，
     * 如果是中文参数，在传递之前，可以使用 URLEncoder.encode () 方法对参数进行编码，在接收到参数之后，使用 URLDecoder.decode () 方法对参数进行解码
     * @param name
     * @param id
     */
    @PutMapping("/user")
    public void updateUserById(@RequestHeader String name, @RequestHeader Long id) {
        System.out.println("name:" + name + ";id:" + id);
    }
}
