package io.itjun.examples.desig.patterns.single;

import java.util.ArrayList;
import java.util.List;

/**
 * 懒汉式实现单例模式，双重检查模式
 */
public class Singleton {

    private static volatile QimenClient client;

    // Private constructor suppresses 
    // default public constructor
    private Singleton() {
    }

    // thread safe and performance  promote
    public static QimenClient getClient() {
        if (client == null) {
            synchronized (Singleton.class) {
                // when more than two threads run into the first null check same time,
                // to avoid instanced more than one time, it needs to be checked again.
                if (client == null) {
                    client = new QimenClient("30375509", "a38452a0314740c9ad92f348a765463");
                }
            }
        }
        return client;
    }

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(() -> {
                System.out.println(Singleton.getClient().hashCode());
            }));
        }

        list.forEach(Thread::start);

        list.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}