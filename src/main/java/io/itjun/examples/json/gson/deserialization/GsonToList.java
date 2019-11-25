package io.itjun.examples.json.gson.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GsonToList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        log.info("原始数据 {}", json);

        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> results = gson.fromJson(json, type);
        results.forEach((item) -> {
            log.info(item);
        });
    }

}
