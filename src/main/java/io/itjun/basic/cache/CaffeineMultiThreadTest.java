package io.itjun.basic.cache;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineMultiThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建 Caffeine 缓存
        Cache<String, String> cache = Caffeine.newBuilder().maximumSize(1000).build();

        int threadCount = 20; // 并发线程数
        int taskCount = 100; // 每个线程提交任务数

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount * taskCount);

        long start = System.currentTimeMillis();

        // 多线程并发访问缓存
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                for (int j = 0; j < taskCount; j++) {
                    String key = "order-001"; // 模拟热点 Key
                    String value = cache.get(key, k -> {
                        System.out.println(Thread.currentThread().getName() + " 正在回源加载...");
                        // 模拟回源耗时
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ignored) {
                        }
                        return "VALUE_" + System.currentTimeMillis();
                    });
                    // 打印获取到的值
                    System.out.println(Thread.currentThread().getName() + " -> " + value);
                    latch.countDown();
                }
            });
        }

        latch.await();
        long cost = System.currentTimeMillis() - start;
        executor.shutdown();

        System.out.println("\n=== 测试结束 ===");
        System.out.println("任务总数：" + (threadCount * taskCount));
        System.out.println("缓存大小：" + cache.estimatedSize());
        System.out.println("耗时：" + cost + " ms");
    }
}
