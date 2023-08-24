package io.itjun.basic.thread.lambda;

import org.springframework.lang.NonNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "From User ThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(@NonNull Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0, false);
        System.out.println("Factory thread Name：" + thread.getName() + " HashCode：" + r.hashCode());
        return thread;
    }
}