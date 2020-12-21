package com.ahhh.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author ahhh
 * @title: GatewayConfig
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/18
 */
//@Configuration
public class GatewayConfig {
    /**
     * 配置了一个 id 为 path_route 的路由规则，当访问地址 http://localhost:8080/get 时会自动转发到地址：http://httpbin.org/get
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/get").uri("http://httpbin.org"))
                .build();
    }
}
