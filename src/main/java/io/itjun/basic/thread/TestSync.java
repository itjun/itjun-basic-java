package io.itjun.basic.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestSync implements Runnable {
    //    private static final AtomicBoolean lock = new AtomicBoolean(true);
    private static final String lock = "yes";// 锁字符串效率很低
    private static long sum;
    private int x;
    private int y;

    public TestSync(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = x; i <= y; i++) {
            synchronized (this) {
//            synchronized (lock) {
                sum += i;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new TestSync(1, 1000000)));
        }
        list.forEach(Thread::start);
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        log.info("{}", TestSync.sum);
        log.info("{}", System.currentTimeMillis() - start);
    }
}
