package io.itjun.examples.json.jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.itjun.examples.config.AppConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class JackJsonToArray {

    public static void main(String[] args) throws JsonProcessingException {
        // 字符串数据
        String[] array = {"A", "B", "C", "D", "E"};

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(array);
        log.info("{}", json);

        String[] string2 = mapper.readValue(json, String[].class);
        Arrays.stream(string2).forEach((x) -> {
            log.info("{}", x);
        });

        log.info(AppConfig.Split_Line);

        List<String> results = mapper.readValue(json, new TypeReference<List<String>>() {
        });
        results.forEach((item) -> {
            log.info("{}", item);
        });

        log.info(AppConfig.Split_Line);

        // 数据类数据
        int[] ints = {1, 2, 3, 4, 5};
        log.info(mapper.writeValueAsString(ints));     // ==> [1,2,3,4,5]

        int[] ints2 = mapper.readValue("[1,2,3,4,5]", int[].class);
        Arrays.stream(ints2).forEach((x) -> {
            log.info("{}", x);
        });

    }

}
