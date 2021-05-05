package io.itjun.examples.thread;

public class TestStart extends Thread {
    private static volatile int sum;
    private int x;
    private int y;

    public TestStart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void run() {
        for (int i = x; i <= y; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum = sum + i;
        }
    }

    public static void main(String[] args) throws Exception {
        TestStart t1 = new TestStart(1, 100);
        TestStart t2 = new TestStart(1, 100);

        t1.run();
        t2.run();

        System.out.println(TestStart.sum);
        System.out.println(TestStart.sum);
    }
}
