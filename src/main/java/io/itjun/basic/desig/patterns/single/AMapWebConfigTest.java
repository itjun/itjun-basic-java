package io.itjun.basic.desig.patterns.single;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class AMapWebConfigTest {
    private static final int THREAD_COUNT = 3000;
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch finishLatch = new CountDownLatch(THREAD_COUNT);
    private static final AtomicReference<AMapWebConfig> last = new AtomicReference<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
                    startLatch.await(); // 等待所有线程都准备好
                    AMapWebConfig config = AMapWebConfig.getInstance();
                    if (last.get() != config)
                        last.set(config);
                    finishLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 让所有线程同时开始
        startLatch.countDown();

        // 等待所有线程执行完毕
        finishLatch.await();
    }

}
