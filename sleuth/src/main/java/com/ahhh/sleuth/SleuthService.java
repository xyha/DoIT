package com.ahhh.sleuth;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ahhh
 * @title: AsyncService
 * @projectName eureka-server
 * @description:
 *
 * @date 2020/12/25
 */
@Component
@Slf4j
public class SleuthService {
    @Autowired
    Tracer tracer;

    /**
     * 同属于一个 TraceId，各自有各自的 SpanId
     * @throws InterruptedException
     */
    @Async
    public void backgroud() throws InterruptedException {
        log.info("background");
        int millis = new Random().nextInt(10);
        System.out.println(millis);
        TimeUnit.SECONDS.sleep(millis);
        this.tracer.currentSpan().tag("background-sleep-millis", String.valueOf(millis));
    }

    /**
     * 每次定时任务都会产生一个新的 Trace，并且调用过程中 SpanId 都是一致的
     * @throws InterruptedException
     */
    @Scheduled(fixedDelay = 36000)
    public void schedulerWork() throws InterruptedException {
        log.info("Start some work from the scheduled task");
        this.backgroud();
        log.info("End work from scheduled task");
    }
}
