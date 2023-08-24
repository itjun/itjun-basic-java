package io.itjun.basic.json.gson.deserialization;

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
        // 格式化显示数据
        // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(list);
        log.info("{}", json);

        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> results = gson.fromJson(json, type);
        results.forEach((item) -> {
            log.info(item);
        });
    }

}
