package io.itjun.examples.thread;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class TestAtomic implements Runnable {

    @Getter
    private static final AtomicLong sum = new AtomicLong();

    private int x;
    private int y;

    public TestAtomic(int x, int y) {
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
            list.add(new Thread(new TestAtomic(1, 1000000)));
        }
        list.forEach(Thread::start);
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("{}", TestAtomic.getSum());
        log.info("{}", System.currentTimeMillis() - start);
    }
}
