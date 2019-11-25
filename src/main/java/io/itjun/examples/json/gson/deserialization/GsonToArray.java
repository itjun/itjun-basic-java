package io.itjun.examples.json.gson.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class GsonToArray {

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E"};
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(array);
        log.info("{}", json);

        String[] string2 = gson.fromJson(json, String[].class);
        Arrays.stream(string2).forEach((x) -> {
            log.info("{}", x);
        });

        int[] ints = {1, 2, 3, 4, 5};
        log.info(gson.toJson(ints));     // ==> [1,2,3,4,5]
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        Arrays.stream(ints2).forEach((x) -> {
            log.info("{}", x);
        });
    }

}
