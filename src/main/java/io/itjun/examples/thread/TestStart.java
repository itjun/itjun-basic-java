package io.itjun.examples.thread;

import java.util.ArrayList;
import java.util.List;

public class TestStart extends Thread {
    private static int sum;
    private int x;
    private int y;

    public TestStart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = x; i <= y; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.getClass()) {
                sum += i;
            }
        }
    }

    public static void main(String[] args) {
        List<TestStart> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            TestStart t = new TestStart(1, 100);
            threads.add(t);
        }
        threads.forEach(t -> {
            t.start();
        });
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(TestStart.sum);
    }
}
