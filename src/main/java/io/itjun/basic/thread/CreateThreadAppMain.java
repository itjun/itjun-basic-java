package io.itjun.basic.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建自己的线程
 * 1、主线程先执行，也可能先结束，和其他线程互不打扰
 * 2、主线程启动其他线程，其他线程的start()是无序的
 * 3、run就是个普通的方法体，被多个线程拷贝执行
 * 4、多个线程可以执行相同或者不同的内容
 * 5、Thread.currentThread() 可以获取每个线程的信息
 */
public class CreateThreadAppMain {

    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天，我们故事的主人公睡眼惺忪的起来 \n ....";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始，当前线程 " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new PrintStoryRunnable(TEXT, 10), "故事线程-" + i);
            thread.start();
        }
        System.out.println("程序结束，当前线程 " + Thread.currentThread().getName());
    }

    static class PrintStoryRunnable implements Runnable {
        private String text;
        private int interval;
        private static AtomicInteger increase = new AtomicInteger();

        public PrintStoryRunnable(String text, int interval) {
            this.text = text;
            this.interval = interval;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行这段线程的名字叫做 " + Thread.currentThread().getName());
//                synchronized (PrintStoryRunnable.class) {
                printSlowly(text, interval);
//                }
                increase.incrementAndGet();
                System.out.println("线程结束 " + Thread.currentThread().getName() + "，计数器 " + increase);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static void printSlowly(String text, int interval) throws InterruptedException {
            for (char c : text.toCharArray()) {
                Thread.sleep(interval);
                System.out.print(c);
            }
        }
    }

}
