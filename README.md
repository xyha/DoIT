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