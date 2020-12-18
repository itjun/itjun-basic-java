package io.itjun.examples.chap02;

public class SimpleTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long num = start + 1000;
        long count = 0;
        while (true) {
            Math.sqrt(num);4`
            if (num < System.currentTimeMillis()) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
