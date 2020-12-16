import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.junit.Test;

/**
 * @author ahhh
 * @title: BulkheadTest
 * @projectName eureka-server
 * @description: 测试请求隔离
 * @date 2020/12/16
 */
public class BulkheadTest {

    /**
     * 创建Bulkhead实例
     */
    @Test
    public void test1() {
        //基于默认配置创建一个 BulkheadRegistry
        BulkheadRegistry bulkheadRegistry = BulkheadRegistry.ofDefaults();
        //自定义最大并行数和进入饱和态 Bulkhead 时线程的最大阻塞时间
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(150)
                .maxWaitTime(100)
                .build();
        BulkheadRegistry bulkheadRegistry2 = BulkheadRegistry.of(config);

        Bulkhead foo = bulkheadRegistry2.bulkhead("foo");
        Bulkhead bar = bulkheadRegistry2.bulkhead("bar", config);

        //直接创建 Bulkhead 的实例
        Bulkhead bulkhead1 = Bulkhead.ofDefaults("foo");
        Bulkhead bulkhead2 = Bulkhead.of(
                "bar",
                BulkheadConfig.custom()
                        .maxConcurrentCalls(50)
                        .build()
        );
    }

    @Test
    public void test2() {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(1)
                .maxWaitTime(100)
                .build();
        Bulkhead bulkhead = Bulkhead.of("testName", config);

        CheckedFunction0<String> stringCheckedFunction0 = Bulkhead.decorateCheckedSupplier(bulkhead, () -> "Hello ");
        Try<String> map = Try.of(stringCheckedFunction0).map(v -> v + "World");
        System.out.println(map.isSuccess());
        System.out.println(map.get());
    }

}
