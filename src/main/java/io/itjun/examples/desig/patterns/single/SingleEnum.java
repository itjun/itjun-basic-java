package io.itjun.examples.desig.patterns.single;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用枚举实现单例模式
 */
public enum SingleEnum {

    INSTANCE;

    public final String Api_Token = "LTAI4GDkMRRBCL1N4hxvp5zb";
    private final QimenClient client = new QimenClient("30375509", "a38452a0314740c9ad92f348a765463");

    public QimenClient getClient() {
        return client;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(SingleEnum.INSTANCE));
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(() -> {
                System.out.println(SingleEnum.INSTANCE.getClient().hashCode());
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
