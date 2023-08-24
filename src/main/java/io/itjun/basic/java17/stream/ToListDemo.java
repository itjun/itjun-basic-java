package io.itjun.basic.java17.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToListDemo {

    public static void main(String[] args) {
        oldStyle();
        streamToList();
    }

    /**
     * 为了将 Stream 转换为 List，您需要使用 collect 的 Collectors.toList() 方法。
     * <p>
     * 这非常冗长
     */
    private static void oldStyle() {
        System.out.println("""
                *************
                * Old style *
                *************""");
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    private static void streamToList() {
        System.out.println("""
                *****************
                * stream toList *
                *****************""");
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.toList();
        for (String s : stringList) {
            System.out.println(s);
        }
    }

}
