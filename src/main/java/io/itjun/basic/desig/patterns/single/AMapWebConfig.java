package io.itjun.basic.desig.patterns.single;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 高德地图 Web服务key<br>
 * <p>
 * 用于坐标获取，静态地图等服务
 */
public enum AMapWebConfig {

    INSTANCE;

    private final List<String> list;
    private static final AtomicInteger counter = new AtomicInteger();

    private AMapWebConfig() {
        this.list = getList();
    }

    private List<String> getList() {
        String value = "";
        return List.of(value.split(","));
    }

    private String getNext() {
        int index = counter.getAndIncrement() % list.size();
        return list.get(index);
    }

    public static String getKey() {
        return AMapWebConfig.INSTANCE.getNext();
    }

}
