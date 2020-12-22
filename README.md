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
