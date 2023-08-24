package io.itjun.basic.lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ListAndArray {

    public static void main(String[] args) {
        // 集合转数组
        Set<String> alias = new HashSet<>();
        alias.add("i_1");
        alias.add("n_2");
        alias.add("2_3");
        String[] arrays = alias.toArray(String[]::new);
        Arrays.stream(arrays).forEach(System.out::println);

        Stream<String> stringStream = Stream.of("a", "b", "c");
        String[] stringArray = stringStream.toArray(size -> new String[size]);
        Arrays.stream(stringArray).forEach(System.out::println);

        // 数组转集合
        String[] stringList = {"Bachiri", "Taoufiq", "Abderrahman"};
        Stream<String> stream = Arrays.stream(stringList);
        Stream<String> myNewStream = stream.map(String::toUpperCase);
        myNewStream.forEach(System.out::println);

        List<String> listStrings = Stream.of(arrays).toList();
        listStrings.forEach(System.out::println);
        // 传统方式
        List<String> list = Arrays.asList(stringList);
        list.forEach(System.out::println);
    }

}
