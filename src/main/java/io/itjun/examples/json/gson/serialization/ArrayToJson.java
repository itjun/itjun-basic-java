package io.itjun.examples.json.gson.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArrayToJson {

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E"};
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(array);
        System.out.println(json);
    }

}
