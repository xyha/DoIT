1、服务注册与发现
Eureka:
    eureka-server-a
    eureka-server-b
    eureka-server-c
    
Consul:
    consul-consumer
    consul-producer-a
    consul-producer-b

2、服务注册和消费
Eureka:
    eureka-server
    eureka-producer
    eureka-consumer
    
RestTemplate:
    eureka-server
    eureka-producer
    eureka-consumer

负载均衡:
    ribbon-eureka-consumer
    eureka-server
    eureka-producer(多个实例，修改端口号)
    
3、服务消费OpenFeign
声明式服务调用Feign:
    feign-eureka-consumer
    eureka-server
    eureka-producer(多个实例，修改端口号)
    
Feign中的继承、日志、请求重试与数据压缩:
    继承:
        建立feign-commons项目，定义公共接口（install项目）
        在 provider 中实现接口；
        在 feign-consumer 中去调用接口。
    feign-commons
    feign-commons-eureka-consumer
    eureka-server
    eureka-producer
    
4、服务容错保护Resilience4j
基本用法:
    resilience4j-no-springboot
    
在微服务中的应用：
    resilience-eureka-springboot
    
Micrometer实现微服务监控：(Prometheus、Grafana、Alertmanger用法)
    micrometer-actuator

5、服务网关Gateway
Gateway的使用：
    gateway
    
Gateway和Eureka配合使用：
    gateway-eureka
    eureka-server
    eureka-producer
    feign-eureka-consumer
    
6、配置中心 Config
配置中心的简单使用：
    config-server
    config-client
    
配置中心的安全管理和文件加解密：
    config-server-encrypt-asymmetry
    config-client

    加密：http://127.0.0.1:8001/encrypt
    解密：http://127.0.0.1:8001/decrypt

    加密：不可逆加密、可逆加密
    不可逆加密：
        例： Spring Security 或者 Shiro，常见的算法如 MD5 消息摘要算法以及 SHA 安全散列算法
    可逆加密：对称加密、非对称加密
        例：对称加密，常见的算法有 DES、3DES、AES 等
            非对称加密不仅可以用来做加密，也可以用来做签名，使用场景还是非常多的，常见的加密算法是 RSA 
            
Spring Cloud Config 服务化、动态刷新、重试
    config-eureka-server
    config-eureka-client
    eureka-server

7、消息总线 Bus
RabbitMQ的简单使用：
    rabbitmq

Spring Cloud Bus 动态刷新配置:
    bus-config-eureka-server
    bus-config-eureka-client
    eureka-server
    
8、数据流 stream
构建消息驱动的微服务：
    steam
stream深入实践:(异步处理、定时任务（需要在rabbit中启动插件）、限流削峰)
    stream-deep-into
    
9、数据跟踪 Sleuth
    sleuth
    (实践了 Sleuth 在 Web 调用、异步调用、定时任务中的方式)
    (一般不会单独的使用 Spring Cloud Sleuth ，往往是结合 ZipKin 等图形界面软件一起使用)
    
10、链路跟踪 Zipkin(docker中部署zipin服务端 + rabbitMq + elasticsearch)
    zipkin-producer
    zipkin-consumer
    
11、微服务监控 Admin
    admin-server
    admin-client
    
    admin-eureka-server
    admin-eureka-client
    
12、spring cloud alibaba 
    nacos:
        nacos
        nacos-client
    sentinel:
        sentinel
        sentinel-nacos