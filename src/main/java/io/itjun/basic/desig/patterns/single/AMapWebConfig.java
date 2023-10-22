package io.itjun.basic.desig.patterns.single;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 高德地图 Web服务key<br>
 * <p>
 * 用于坐标获取，静态地图等服务
 */
public class AMapWebConfig {
    private final List<String> list;
    private static final AtomicInteger counter = new AtomicInteger();
    private static volatile AMapWebConfig instance;

    private AMapWebConfig() {
        this.list = getList();
    }

    public static AMapWebConfig getInstance() {
        if (instance == null) {
            synchronized (AMapWebConfig.class) {
                if (instance == null)
                    instance = new AMapWebConfig();
            }
        }
        return instance;
    }

    protected AMapWebConfig(List<String> list) {
        this.list = list;
    }

    private List<String> getList() {
        String value = "9a2699c11a7f8fe7382e97fe5d60ecf,7aac08b959dce9eb39b51956b23951b";
        return List.of(value.split(","));
    }

    protected String getNext() {
        int index = counter.getAndIncrement() % list.size();
        return list.get(index);
    }

    public static String getKey() {
        return AMapWebConfig.instance.getNext();
    }

}
