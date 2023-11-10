package io.itjun.basic.desig.patterns.single;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 高德地图 Web服务key<br>
 * <p>
 * 用于坐标获取，静态地图等服务
 */
public enum AMapWebConfig {
    instance;
    private final List<String> list;
    private static final AtomicInteger counter = new AtomicInteger();

    private AMapWebConfig() {
        this.list = getList();
    }

    private List<String> getList() {
        String value = "9a2699c11a7f8fe7382e97fe5d60ecf,7aac08b959dce9eb39b51956b23951b";
        return List.of(value.split(","));
    }

    private String getNext() {
        int index = counter.getAndIncrement() % list.size();
        return list.get(index);
    }

    public static String getKey() {
        return instance.getNext();
    }

}
