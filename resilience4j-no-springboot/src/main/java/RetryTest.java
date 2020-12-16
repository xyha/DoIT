import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.junit.Test;

import java.time.Duration;
import java.util.Date;

/**
 * @author ahhh
 * @title: RetryTest
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/16
 */
public class RetryTest {

    @Test
    public void test1(){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)//重试次数为3
                .waitDuration(Duration.ofMillis(500))//重试间隔 500ms
                .build();
        Retry retry = Retry.of("id", config);

        CheckedFunction0<String> stringCheckedFunction0 = Retry.decorateCheckedSupplier(retry, () -> {
            System.out.println(new Date());
            int i = 1 / 0;
            return "retry";
        });

        Try<String> recover = Try.of(stringCheckedFunction0).recover(e -> "Hello world from recovery function");
        System.out.println(recover.isSuccess());
        System.out.println(recover.get());
    }
}
