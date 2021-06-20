package io.itjun.examples.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class TestLocker implements Runnable {

    private static long sum;

    private static final Lock locker = new ReentrantLock();

    private int x;
    private int y;

    public TestLocker(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        locker.lock();
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        locker.unlock();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new TestLocker(1, 1000000)));
        }
        list.forEach(Thread::start);
        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("{}", TestLocker.sum);
        log.info("{}", System.currentTimeMillis() - start);
    }

}
