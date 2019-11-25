package io.itjun.examples.json.gson.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * 1、Array、List、Set 的序列化数据结构一致
 * 2、同样的数据结构可反序列化为 Array、List、Set
 */
@Slf4j
public class GsonToArray {

    public static void main(String[] args) {
        // 字符串数据
        String[] array = {"A", "B", "C", "D", "E"};
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(array);
        log.info("{}", json);

        String[] string2 = gson.fromJson(json, String[].class);
        Arrays.stream(string2).forEach((x) -> {
            log.info("{}", x);
        });

        log.info("------分割线------");
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> results = gson.fromJson(json, type);
        results.forEach((item) -> {
            log.info("{}", item);
        });

        // 数据类数据
        int[] ints = {1, 2, 3, 4, 5};
        log.info(gson.toJson(ints));     // ==> [1,2,3,4,5]
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        Arrays.stream(ints2).forEach((x) -> {
            log.info("{}", x);
        });

    }

}
