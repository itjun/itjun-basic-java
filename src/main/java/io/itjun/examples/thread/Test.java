package io.itjun.examples.thread;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test implements Runnable {
    @Getter
    @Setter
    private int sum;

    private final int x;
    private final int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        this.sum++;
        log.info("{}", this.sum);
    }

    public static void main(String[] args) {
        Test t1 = new Test(1, 100);
        Thread thread1 = new Thread(t1);
//        Test t2 = new Test(1, 100);

//        thread1.run();
        thread1.start();
//        t2.start();
        log.info("{}", t1.sum);
        log.info("{}", t1.getSum());
        log.info("{}", t1.getSum());
    }
}
