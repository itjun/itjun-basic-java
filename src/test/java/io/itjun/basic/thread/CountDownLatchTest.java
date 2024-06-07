package io.itjun.basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch 多线程同时执行
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        AtomicInteger atomic = new AtomicInteger();
        int threadCount = 30000;
        CountDownLatch ready = new CountDownLatch(threadCount);
        CountDownLatch start = new CountDownLatch(1);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                ready.countDown();
                try {
                    start.await(); // 等待所有线程准备好
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(atomic.incrementAndGet() + " - " + Thread.currentThread().getName());
            });
        }

        System.out.println("start");
        Thread.sleep(1000);

        ready.await();
        start.countDown(); // 启动所有线程
        executor.shutdown(); // 关闭线程池

        if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
            if (executor.isTerminated())
                System.out.println("end");
        }
    }

}