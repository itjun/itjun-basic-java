package io.itjun.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        AtomicInteger sum = new AtomicInteger();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int a = i;
            executor.execute(() -> {
                System.out.println(a);
                sum.incrementAndGet();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        }
        executor.shutdown();
        System.out.println("final sum = " + sum);
    }

}
