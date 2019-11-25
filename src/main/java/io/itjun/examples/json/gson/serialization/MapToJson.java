package io.itjun.examples.json.gson.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iCrazyTeam on 2017/5/14.
 */
public class MapToJson {

    public static void main(String[] args) {
        Map<String, String> items = new HashMap<>();
        items.put("C0001", "Apple");
        items.put("C0002", "Google");
        items.put("C0003", "Facebook");
        items.put("C0004", "Tencent");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(items);
        System.out.println(json);
    }
}
