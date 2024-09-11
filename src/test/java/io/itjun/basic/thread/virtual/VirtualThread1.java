package io.itjun.basic.thread.virtual;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class VirtualThread1 {

    @Test
    public void test_1() throws InterruptedException {
        Thread.ofPlatform().start(() -> System.out.println(Thread.currentThread()));
        Thread virtual = Thread.ofVirtual().start(() -> System.out.println(Thread.currentThread()));
        // 等待虚拟线程执行完成以后再退出主程序
        virtual.join();
    }

    /**
     * 测试实际虚拟线程有多少个真实线程
     */
    @Test
    public void test_2() {
        StopWatch watch = new StopWatch();
        Set<String> threads = ConcurrentHashMap.newKeySet();
        watch.start();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 1_000_000).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                String threadInfo = Thread.currentThread().toString();// VirtualThread[#31]/runnable@ForkJoinPool-1-worker-1
                String workerName = threadInfo.split("@")[1];//ForkJoinPool-1-worker-1
                threads.add(workerName);
                return i;
            }));
            executor.shutdown();
            if (!executor.isTerminated())
                executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        watch.stop();
        log.info("Platform Threads: {}", threads.size());
        System.out.println(watch.prettyPrint());
    }

}
