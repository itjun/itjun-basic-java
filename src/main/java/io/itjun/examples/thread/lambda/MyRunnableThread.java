package io.itjun.examples.thread.lambda;

public class MyRunnableThread implements Runnable {

    public MyRunnableThread() {
        System.out.println("MyRunnableThread constructor is called " + this.hashCode());
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(100);
            System.out.println(name + hashCode());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}