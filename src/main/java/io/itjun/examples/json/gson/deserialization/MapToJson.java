package io.itjun.examples.json.gson.deserialization;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 单层结构下，map和对象属性可以直接转化
 */
@Setter
@Getter
public class MapToJson {

    private String code;

    private String name;

    public static void main(String[] args) {
        MapToJson obj = new MapToJson();
        obj.setCode("A100");
        obj.setName("John");
        System.out.println(new Gson().toJson(obj));

        Map<String, String> items = new HashMap<>();
        items.put("code", "A100");
        items.put("name", "John");
        System.out.println(new Gson().toJson(items));
    }

}
