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
    feign-eureka-consumer
    eureka-server
    eureka-producer(多个实例，修改端口号)