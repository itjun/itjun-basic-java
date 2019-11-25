package io.itjun.examples.json.gson.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * json 反序列化成Map
 */
@Slf4j
public class GsonToMap {

    public static void main(String[] args) {
        Map<String, String> items = new HashMap<>();
        items.put("C0001", "Apple");
        items.put("C0002", "Google");
        items.put("C0003", "Facebook");
        items.put("C0004", "Tencent");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(items);
        log.info("原始数据 {}", json);

        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> results = gson.fromJson(json, type);
        results.forEach((k, v) -> {
            log.info("{} {}", k, v);
        });

    }

}
