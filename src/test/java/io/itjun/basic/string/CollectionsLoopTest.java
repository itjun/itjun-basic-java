package io.itjun.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 百万数据遍历，list、set、map 纯内容不涉及sql等网络操作
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
        list.parallelStream().forEach(k -> {
        });
        long end = System.nanoTime();
        log.info("list并行执行时间 {}", (end - start));

        long s2 = System.nanoTime();
        list.forEach(k -> {
        });
        long e2 = System.nanoTime();
        log.info("list单线执行时间 {}", (e2 - s2));
    }

    @Test
    public void test_set() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add("value" + i);
        }
        long start = System.nanoTime();
        set.parallelStream().forEach(k -> {
        });
        long end = System.nanoTime();
        log.info("set并行执行时间 {}", (end - start));

        long s2 = System.nanoTime();
        set.forEach(k -> {
        });
        long e2 = System.nanoTime();
        log.info("set单线执行时间 {}", (e2 - s2));
    }

    @Test
    public void test_map() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put("key" + i, "value" + i);
        }
        long start = System.nanoTime();
        map.forEach((k, v) -> {
        });
        long end = System.nanoTime();
        log.info("map单线执行时间 {}", (end - start));
    }

    @Test
    public void test_4() {
        // 创建一个包含 1 到 1,000,000 的整数列表
        List<Integer> largeList = IntStream.rangeClosed(1, 1_000_000_00).boxed().toList();

        // 使用并行流计算所有偶数的平方和
        long startTime = System.currentTimeMillis();
        double sumOfSquares = largeList.parallelStream()
                .filter(num -> num % 2 == 0)
                .mapToDouble(num -> num * num)
                .sum();
        long endTime = System.currentTimeMillis();

        log.info("Sum of squares: {}", sumOfSquares);
        log.info("Time taken with parallel stream: {} ms", endTime - startTime);
    }

}
