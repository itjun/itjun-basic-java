package io.itjun.basic.json.gson.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 混合数据对象序列化和解析
 */
@Slf4j
public class ObjectToGson {

    @Getter
    @Setter
    private String platform;

    @Getter
    @Setter
    private String audience;

    @Getter
    @Setter
    private String notification;

    @Getter
    private Map<String, String> items = new HashMap<>();

    @Getter
    private List<String> list = new ArrayList<>();

    public void put(String key, String value) {
        items.put(key, value);
    }

    public void add(String str) {
        list.add(str);
    }

    public static void main(String[] args) {
        ObjectToGson obj = new ObjectToGson();
        obj.setPlatform("all");
        obj.setAudience("tag");
        obj.setNotification("android");

        obj.put("k1", "Apple");
        obj.put("k2", "Google");
        obj.put("k3", "Facebook");
        obj.put("k4", "Tencent");

        obj.add("华为");
        obj.add("小米");
        obj.add("魅族");
        obj.add("一加");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(obj);
        log.info("{}", json);

        ObjectToGson result = gson.fromJson(json, ObjectToGson.class);
        log.info("{}", result.getPlatform());

        result.getList().forEach((x) -> {
            log.info(x);
        });
    }

}
