package io.itjun.basic.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class LambdaMap {

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, String> items = new LinkedHashMap<>();
        items.put("C0004", "Tencent");
        items.put("C0003", "Facebook");
        items.put("C0002", "Google");
        items.put("C0001", "Apple");

        items.entrySet().stream().filter("C0001"::equals).forEach(e -> {
            log.info("{}-{}", e.getKey(), e.getValue());
        });

        items.forEach((k, v) -> log.info("{}-{}", k, v));

    }

}
