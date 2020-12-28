import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.vavr.control.Try;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * @author ahhh
 * @title: TimeLimiter
 * @projectName eureka-server
 * @description: 限时器
 * @date 2020/12/16
 */
public class TimeLimiterTest {

    /**
     * Resilience4j 中的限时器是要结合 Future 一起来使用，开发者需要提前配置过期时间，在过期时间内要是没有获取到value，那么 Future 将会被取消
     */
    @Test
    public void test1() throws Exception {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(1))
                .cancelRunningFuture(true)
                .build();
        //首先创建了一个 TimeLimiter，
        TimeLimiter timeLimiter = TimeLimiter.of(config);
        //然后将任务放到线程池中，获取到一个 Supplier<Future> 对象，
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Supplier<Future<Integer>> futureSupplier = () -> executorService.submit(() -> {
            //Thread.sleep(2000);
            return 1;
        });
        //然后使用限时器包装该对象，当调用超时， onFailure 方法就会被触发
        Callable<Integer> integerCallable = TimeLimiter.decorateFutureSupplier(timeLimiter, futureSupplier);
        Try<Integer> integers = Try.of(integerCallable::call)
                .onFailure(e -> System.out.println("error:" + e.getMessage()));
        System.out.println(integers.get());

    }

    /**
     *将限时器和断路器结合使用，当调用超时次数过多，直接熔断
     */
    @Test
    public void test2() {

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(1))
                .cancelRunningFuture(true)
                .build();
        //首先创建了一个 TimeLimiter，
        TimeLimiter timeLimiter = TimeLimiter.of(config);
        //然后将任务放到线程池中，获取到一个 Supplier<Future> 对象，
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Supplier<Future<Integer>> futureSupplier = () -> executorService.submit(() -> {
            Thread.sleep(2000);
            return 1;
        });

        Callable restrictedCall = TimeLimiter
                .decorateFutureSupplier(timeLimiter, futureSupplier);
        //断路器
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(2)
                .ringBufferSizeInHalfOpenState(2)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("test", circuitBreakerConfig);
        Callable chainedCallable = CircuitBreaker.decorateCallable(circuitBreaker, restrictedCall);
        Try.of(chainedCallable::call)
                .onFailure(throwable -> System.out.println("We might have timed out or the circuit breaker has opened."));
        System.out.println(circuitBreaker.getState());
        Try.of(chainedCallable::call)
                .onFailure(throwable -> System.out.println("We might have timed out or the circuit breaker has opened."));
        System.out.println(circuitBreaker.getState());
    }
}
