package com.ahhh.ribboneurekaconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ahhh
 * @title: RibbonConfig
 * @projectName eureka-server
 * @description: 负载均衡策略配置
 *
 * RandomRule 表示随机策略
 * RoundRobinRule 表示轮询策略
 * WeightedResponseTimeRule 表示加权策略（即将过期，功能和 ResponseTimeWeightedRule 一致）
 * ResponseTimeWeightedRule 也是加权，它是根据每一个 Server 的平均响应时间动态加权，响应时间越长，权重越小，处理请求的机会也越小
 * RetryRule 表示一个具备重试功能的负载均衡策略，内部默认使用了 RoundRobinRule 这个内部也可以自己传其他的负载均衡策略进去
 * BestAvailableRule 策略表示使用并发数最小的服务
 *
 * @date 2020/12/15
 */
@Configuration
public class RibbonConfig {
    /**
     * 设置为随机策略
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
