package io.itjun.examples.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test implements Runnable {

    @Getter
    private static AtomicLong sum = new AtomicLong();

    private int x;
    private int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = x; i <= y; i++) {
            sum.addAndGet(i);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new Test(1, 1000000)));
        }
        list.forEach(t -> {
            t.start();
        });
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("{}", Test.getSum());
        log.info("{}", System.currentTimeMillis() - start);
    }
}
