import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.vavr.CheckedRunnable;
import io.vavr.control.Try;
import org.junit.Test;

import java.time.Duration;
import java.util.Date;

/**
 * @author ahhh
 * @title: RateLimiterTest
 * @projectName eureka-server
 * @description: 测试限流
 * <p>
 * 限制某个请求的频率为 2QPS（每秒处理两个请求）
 * @date 2020/12/16
 */
public class RateLimiterTest {

    /**
     * 创建限流器
     */
    @Test
    public void test1() {
        RateLimiterConfig build = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofMillis(1000))
                .limitForPeriod(2)
                .timeoutDuration(Duration.ofMillis(1000))
                .build();
        RateLimiterRegistry of = RateLimiterRegistry.of(build);
        RateLimiter test1 = of.rateLimiter("test1");
        RateLimiter test2 = of.rateLimiter("test2", build);
        RateLimiter test3 = RateLimiter.of("test3", build);

    }

    @Test
    public void test2() {
        RateLimiterConfig build = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofMillis(1000))
                .limitForPeriod(2)
                .timeoutDuration(Duration.ofMillis(1000))
                .build();
        RateLimiter test = RateLimiter.of("test",build);

        CheckedRunnable checkedRunnable = RateLimiter.decorateCheckedRunnable(test, () -> {
            System.out.println(new Date());
        });

        //事件监听,限流中，我们也可以获取所有允许和拒绝执行的事件信息
        test.getEventPublisher()
                .onSuccess(event -> {
                    System.out.println(new Date()+">>>"+event.getEventType()+">>>"+event.getCreationTime());
                })
                .onFailure(event -> {
                    System.out.println(new Date()+">>>"+event.getEventType()+">>>"+event.getCreationTime());
                });

        //因为限流，一次只执行了两个方法
        Try.run(checkedRunnable).andThenTry(checkedRunnable)
                .andThenTry(checkedRunnable)
                .andThenTry(checkedRunnable)
                .andThenTry(checkedRunnable)
                .onFailure(e -> System.out.println(e.getMessage()));

        RateLimiter.Metrics metrics = test.getMetrics();
        int numberOfThreadsWaitingForPermission = metrics.getNumberOfWaitingThreads();
        int availablePermissions = metrics.getAvailablePermissions();
        System.out.println(numberOfThreadsWaitingForPermission);
        System.out.println(availablePermissions);


        //限流参数也可以随时修改，修改之后，本次限流周期内不起作用，下次限流时会生效
        test.changeLimitForPeriod(100);
        test.changeTimeoutDuration(Duration.ofMillis(100));
        //因为限流，一次只执行了两个方法
        Try.run(checkedRunnable).andThenTry(checkedRunnable)
                .andThenTry(checkedRunnable)
                .andThenTry(checkedRunnable)
                .andThenTry(checkedRunnable)
                .onFailure(e -> System.out.println(e.getMessage()));
    }
}
