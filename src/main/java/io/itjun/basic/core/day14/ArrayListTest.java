package io.itjun.basic.core.day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 去除ArrayList集合中的重复元素。
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java01");
        list.add("java02");
        list.add("java01");
        list.add("java02");
        list.add("java01");
        list.stream().distinct().toList().forEach(System.out::println);
    }

}
