package io.itjun.examples.thread;

public class StopALittle {

    public static void main(String[] args) throws InterruptedException {
        printSlowly("太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天，我们故事的主人公睡眼惺忪的起来 \n ....", 300);
    }

    private static void printSlowly(String s, int interval) throws InterruptedException {
        for (char c : s.toCharArray()) {
            Thread.sleep(interval);
            System.out.print(c);
        }
    }

}
