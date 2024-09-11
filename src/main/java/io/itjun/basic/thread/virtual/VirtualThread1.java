package io.itjun.basic.thread.virtual;

public class VirtualThread1 {

    public static void main(String[] args) throws InterruptedException {
        Thread.ofPlatform().start(() -> System.out.println(Thread.currentThread()));
        Thread virtual = Thread.ofVirtual().start(() -> System.out.println(Thread.currentThread()));

        // 等待虚拟线程执行完成以后再退出主程序
        virtual.join();
    }

}
