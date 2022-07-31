package io.itjun.examples.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class MapTest {

    /**
     * 传统写法删除 map
     */
    @Test
    public void test_1() {
        Map<String, String> items = new HashMap<>();
        items.put("A", "a1");
        items.put("B", "a2");
        items.put("C", "a3");
        items.put("D", "b1");
        items.keySet().forEach(log::info);

        // 迭代器删除
        Iterator<Map.Entry<String, String>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().contains("a")) {
                iterator.remove();
            }
        }
        items.keySet().forEach(log::info);
    }

    @Test
    public void test_2() {
        Map<String, String> items = new HashMap<>();
        items.put("A", "a1");
        items.put("B", "a2");
        items.put("C", "a3");
        items.put("D", "b1");
        items.keySet().forEach(log::info);

        items.entrySet().removeIf(entry -> entry.getValue().contains("a"));
        items.keySet().forEach(log::info);
    }

    @Test
    public void test_3() {
        Map<String, String> items = new HashMap<>();
        items.put("A", "a1");
        items.put("B", "a2");
        items.put("C", "a3");
        items.put("D", "b1");
        items.keySet().forEach(log::info);

        items.values().removeIf(v -> v.contains("a"));
        items.keySet().forEach(log::info);
    }

}
