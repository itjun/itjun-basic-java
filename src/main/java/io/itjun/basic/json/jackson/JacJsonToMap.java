package io.itjun.basic.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class JacJsonToMap {

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, String> items = new LinkedHashMap<>();
        items.put("C0004", "Tencent");
        items.put("C0003", "Facebook");
        items.put("C0002", "Google");
        items.put("C0001", "Apple");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items);
        log.info("{}", json);

        TypeFactory typeFactory = mapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(LinkedHashMap.class, String.class, String.class);

        LinkedHashMap<String, String> map = mapper.readValue(json, mapType);
        map.forEach((k, v) -> log.info("{} {}", k, v));
    }

}
