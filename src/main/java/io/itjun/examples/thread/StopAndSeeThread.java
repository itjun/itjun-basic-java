package io.itjun.examples.thread;

public class StopAndSeeThread {

    public static void main(String[] args) {
        f1();
    }

    private static void f1() {
        f2();
    }

    private static void f2() {
        f3();
    }

    private static void f3() {
        int a = 300;
        f4();
    }

    private static void f4() {
        f5();
    }

    private static void f5() {
        int a = 500;
        f6();
    }

    private static void f6() {
        System.out.println("Debug ..");
    }
}
