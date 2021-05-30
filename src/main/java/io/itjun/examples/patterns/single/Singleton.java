package io.itjun.examples.patterns.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    private static volatile Singleton INSTANCE = null;

    // Private constructor suppresses 
    // default public constructor
    private Singleton() {
    }

    // thread safe and performance  promote
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                // when more than two threads run into the first null check same time,
                // to avoid instanced more than one time, it needs to be checked again.
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton.getInstance().hashCode())).start();
        }
    }

}