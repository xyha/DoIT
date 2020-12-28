package com.ahhh.configserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ahhh
 * @title: SecurityConfig
 * @projectName eureka-server
 * @description: 由于给 config_server 中的所有接口添加了保护，因此 /actuator/bus-refresh 是无法直接访问的，
 * 需要再添加一个 Spring Security 的配置类，在配置类中对权限再做一些配置
 * @date 2020/12/23
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 这里的配置首先是配置所有的请求都必须登录后才能访问，然后配置允许 HttpBasic 登录，
     * 这样我们在发起 /actuator/bus-refresh 请求时，就可以直接通过 HttpBaisc 来配置认证信息了
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }
}
