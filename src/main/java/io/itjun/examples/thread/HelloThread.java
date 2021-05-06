package io.itjun.examples.thread;

public class HelloThread {

    public static void main(String[] args) {
        Thread.currentThread().getThreadGroup().getParent().list();

        Thread.getAllStackTraces().forEach((t, v) -> {
            System.out.println(t.getName());
        });
    }

}
