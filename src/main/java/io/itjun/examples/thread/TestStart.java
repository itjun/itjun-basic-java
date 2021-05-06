package io.itjun.examples.thread;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestStart implements Runnable {
    private static long sum;
    private int x;
    private int y;

    public TestStart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = x; i <= y; i++) {
            synchronized (this.getClass()) {
                sum += i;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new TestStart(1, 1000000)));
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

        log.info("{}", TestStart.sum);
        log.info("{}", System.currentTimeMillis() - start);
    }
}