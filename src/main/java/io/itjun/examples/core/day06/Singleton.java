package io.itjun.examples.core.day06;

public class Singleton {
    private static volatile Singleton INSTANCE = null;
    public int count;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Singleton singleton = Singleton.getInstance();
        singleton.setCount(2017);

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance();
                    System.out.println(singleton.getCount());
                }
            }).start();
        }

        long end = System.currentTimeMillis();
        System.out.println("use time" + (end - start));
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}