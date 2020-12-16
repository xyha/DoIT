import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.CheckedFunction0;
import io.vavr.CheckedFunction1;
import io.vavr.control.Try;
import org.junit.Test;

import java.time.Duration;

/**
 * @author ahhh
 * @title: CircuitBreakerTest
 * @projectName eureka-server
 * @description: 测试断路器
 * @date 2020/12/16
 */
public class CircuitBreakerTest {

    /**
     * 断路器初始化
     */
    @Test
    public void test1() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)//故障率阈值百分比，超过这个阈值，断路器就会打开
                .waitDurationInOpenState(Duration.ofMillis(1000))//断路器保持打开的时间，在到达设置的时间之后，断路器会进入到 half open 状态
                .ringBufferSizeInHalfOpenState(2)//当断路器处于 half open 状态时，环形缓冲区的大小
                .ringBufferSizeInClosedState(2)//当断路器关闭时，环形缓冲区的大小
                .build();
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("otherName");
        CircuitBreaker uniqueName = circuitBreakerRegistry.circuitBreaker("uniqueName", circuitBreakerConfig);
        //不使用 CircuitBreakerRegistry 来管理断路器
        CircuitBreaker defaultCircuitBreaker = CircuitBreaker.ofDefaults("testName1");
        CircuitBreaker customCircuitBreaker = CircuitBreaker.of("testName2", circuitBreakerConfig);

    }

    /**
     * 断路器使用案例1:(断路器关闭)
     * 两个函数使用了相同的断路器
     */
    @Test
    public void test2() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");
        CheckedFunction0<String> stringCheckedFunction0 = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> "This can be any method which returns: 'Hello");
        Try<String> map = Try.of(stringCheckedFunction0).map(value -> value + " world'");
        System.out.println(map.isSuccess());
        System.out.println(map.get());
    }

    /**
     * 断路器使用案例2:(断路器关闭)
     * 两个函数使用不相同的断路器
     */
    @Test
    public void test3() {
        CircuitBreaker circuitBreaker1 = CircuitBreaker.ofDefaults("testName1");
        CircuitBreaker circuitBreaker2 = CircuitBreaker.ofDefaults("testName2");
        CheckedFunction0<String> stringCheckedFunction0 = CircuitBreaker.decorateCheckedSupplier(circuitBreaker1, () -> "Hello");
        CheckedFunction1<Object, String> objectStringCheckedFunction1 = CircuitBreaker.decorateCheckedFunction(circuitBreaker2, value -> value + "World");
        Try<String> strings = Try.of(stringCheckedFunction0).mapTry(objectStringCheckedFunction1::apply);
        System.out.println(strings.isSuccess());
        System.out.println(strings.get());
    }

    /**
     * 断路器使用案例3:(断路器打开)
     * 手动模拟错误
     */
    @Test
    public void test4() {
        CircuitBreakerConfig build = CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(2)//断路器关闭状态下的环形缓冲区大小为 2 ，即当有两条数据时就可以去统计故障率了，这里没有设置故障率，默认的故障率是 50%
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("testName", build);
        //当第一次调用 onError 方法后，打印断路器当前状态，发现断路器还是处于关闭状态，并未打开，
        circuitBreaker.onError(0, new RuntimeException());
        System.out.println(circuitBreaker.getState());
        //接下来再次调用 onError 方法，然后再去查看断路器状态，此时发现断路器已经打开了，因为满足了 50% 的故障率了。
        circuitBreaker.onError(0, new RuntimeException());
        System.out.println(circuitBreaker.getState());
        Try<String> map = Try.of(CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> "Hello")).map(v -> v + " World");
        System.out.println(map.isSuccess());
        System.out.println(map.get());
    }

    /**
     * 断路器使用案例4:(断路器重置)
     */
    @Test
    public void test5() {
        CircuitBreakerConfig build = CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(2)//断路器关闭状态下的环形缓冲区大小为 2 ，即当有两条数据时就可以去统计故障率了，这里没有设置故障率，默认的故障率是 50%
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("testName", build);
        //当第一次调用 onError 方法后，打印断路器当前状态，发现断路器还是处于关闭状态，并未打开，
        circuitBreaker.onError(0, new RuntimeException());
        System.out.println(circuitBreaker.getState());
        //接下来再次调用 onError 方法，然后再去查看断路器状态，此时发现断路器已经打开了，因为满足了 50% 的故障率了。
        circuitBreaker.onError(0, new RuntimeException());
        System.out.println(circuitBreaker.getState());
        //断路器也支持重置，重置之后数据清空，恢复到初始状态
        circuitBreaker.reset();
        System.out.println(circuitBreaker.getState());
        Try<String> map = Try.of(CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> "Hello")).map(v -> v + " World");
        System.out.println(map.isSuccess());
        System.out.println(map.get());
    }

    /**
     * 断路器使用案例5:(服务降级)
     */
    @Test
    public void test6(){
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");
        CheckedFunction0<Object> bam = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> {
            throw new RuntimeException("BAM");
        });
        Try<Object> recover = Try.of(bam).recover(throwable -> "Hello Recovery");
        System.out.println(recover.isSuccess());
        System.out.println(recover.get());
    }

    /**
     * 断路器使用案例6:(状态监听)
     */
    @Test
    public void test7(){
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .ringBufferSizeInClosedState(2)
                .ringBufferSizeInHalfOpenState(2)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .recordFailure(e -> (e instanceof ArithmeticException))
                .build();
        CircuitBreaker test = CircuitBreaker.of("test", circuitBreakerConfig);
        CheckedFunction0<Object> bam = CircuitBreaker.decorateCheckedSupplier(test, () -> {
            throw new ArithmeticException("BAM");
        });
        Try<Object> recover = Try.of(bam).recover(throwable -> "Hello Recovery");
        Try<Object> recover2 = Try.of(bam).recover(throwable -> "Hello Recovery");
        CircuitBreaker.Metrics metrics = test.getMetrics();
        //获取故障率
        float failureRate = metrics.getFailureRate();
        //当前缓冲的呼叫数
        int numberOfBufferedCalls = metrics.getNumberOfBufferedCalls();
        //获取调用失败次数
        int numberOfFailedCalls = metrics.getNumberOfFailedCalls();
        System.out.println(failureRate);
        System.out.println(numberOfBufferedCalls);
        System.out.println(numberOfFailedCalls);

    }
}
