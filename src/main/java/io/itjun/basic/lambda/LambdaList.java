package io.itjun.basic.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LambdaList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("24");
        list.add("35");
        list.add("19");

        log.info("count {}", list.stream().mapToInt(Integer::parseInt).filter(k -> k > 2).count());
        log.info("max {}", list.stream().mapToInt(Integer::parseInt).max().getAsInt());
        log.info("anyMatch {}", list.stream().mapToInt(Integer::parseInt).filter(k -> k > 1).anyMatch(k -> k == 5));
        list.stream().mapToInt(Integer::parseInt).filter(k -> k > 1).sorted().forEach(System.out::println);

        // 转指定的 LinkedHashMap
        LinkedHashMap<String, String> collect = list.stream().collect(Collectors.toMap(k -> k, k -> k, (o1, o2) -> o1, LinkedHashMap::new));
        collect.forEach((key, value) -> log.info("{} {}", key, value));
    }

}
