package io.itjun.examples.json.netjson;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.util.Map;

@Slf4j
public class JSONObjectToMap {

    private static final String Json_Map = "{\"city\":\"深圳\",\"temphigh\":\"25\",\"templow\":\"19\",\"updatetime\":\"2017-11-04 13:23:00\",\"tempnow\":\"24\",\"sendibletemp\":\"27\",\"winddirect\":\"东北风\"}";

    public static void main(String[] args) {
        // 1、JSONObject 本身就是继承Map对象
        Map<String, Object> items = JSONObject.fromObject(Json_Map);
        items.forEach((key, value) -> {
            log.info("{} {}", key, value);
        });
    }

}
