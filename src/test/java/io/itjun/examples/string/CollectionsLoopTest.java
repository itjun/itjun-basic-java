package io.itjun.examples.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 百万数据遍历，list、set、map 查找速度
 */
@Slf4j
public class CollectionsLoopTest {

    private static final int size = 1000000;

    @Test
    public void test_list() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("value" + i);
        }
        long start = System.nanoTime();
        boolean result = list.contains("value" + (size - 1));
        long end = System.nanoTime();
        log.info("list执行时间 {}, {}", (end - start), result);
    }

    @Test
    public void test_set() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add("value" + i);
        }
        long start = System.nanoTime();
        boolean result = set.contains("value" + (size - 1));
        long end = System.nanoTime();
        log.info("set执行时间 {}, {}", (end - start), result);
    }

    @Test
    public void test_map() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put("key" + i, "value" + i);
        }
        long start = System.nanoTime();
        boolean result = map.containsKey("key" + (size - 1));
        long end = System.nanoTime();
        log.info("map执行时间 {}, {}", (end - start), result);
    }

}
