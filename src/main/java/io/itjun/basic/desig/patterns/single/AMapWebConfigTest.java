package io.itjun.basic.desig.patterns.single;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AMapWebConfigTest {
    private static final int THREAD_COUNT = 10000;
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch finishLatch = new CountDownLatch(THREAD_COUNT);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Set<AMapWebConfig> set = new HashSet<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.submit(() -> {
                try {
                    startLatch.await(); // 等待所有线程都准备好
                    AMapWebConfig config = AMapWebConfig.instance;
                    set.add(config);
                    if (set.size() > 1)
                        System.out.println("stop size " + set.size());
                    finishLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 让所有线程同时开始
        startLatch.countDown();

        // 等待所有线程执行完毕
        finishLatch.await();
        executorService.shutdownNow();
    }

}
