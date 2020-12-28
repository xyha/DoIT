package com.ahhh.feigneurekaconsumer.feignservice;

import com.ahhh.feigneurekaconsumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ahhh
 * @title: FeignService
 * @projectName eureka-server
 * @description: Feign接口
 * 使用 @FeignClient (“provider”) 注解将当前接口和 provider 服务绑定， provider 是服务名，大小写不敏感
 * @date 2020/12/15
 */
@FeignClient("eureka-producer")
public interface FeignService {
    /**
     * 使用 SpringMVC 的 @GetMapping ("/hello") 注解将 hello 方法和 provider 中的 hello 接口绑定在一起。
     * 需要注意的是，在 SpringMVC 中，在需要给参数设置默认值或者要求参数必填的情况下才需要用到 @RequestParam 注解，而在这里，这个注解一定要加。
     *
     * @param name
     * @return
     */
    @GetMapping("/index")
    String feign(@RequestParam("name") String name);

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 但是有一个地方需要强调:
     * 那就是不同于 provider ，这里的参数
     * 如果是 key/value 形式的，一定要在 @RequestParam 注解中指明 name 属性，
     * 如果是在 header 中传递的，则一定要在 @RequestHeader 注解中添加 name 属性，
     * 如果参数放在 Url 路径中，那么一定需要在 @PathVariable 注解中添加 name 属性指明参数名称。
     *
     * @param id
     */
    @DeleteMapping("/user/{id}")
    void deleteUserById(@PathVariable("id") Long id);

    @GetMapping("/user")
    User getUserByName(@RequestParam("name") String name);

    @PostMapping("/user")
    User addUser(@RequestBody User user);

    @PutMapping("/user")
    void updateUserById(@RequestHeader("name") String name, @RequestHeader("id") Long id);

}
