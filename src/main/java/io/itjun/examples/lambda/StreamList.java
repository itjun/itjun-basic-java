package io.itjun.examples.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StreamList {

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
    }

}
