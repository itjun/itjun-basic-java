package io.itjun.basic.json.gson.serialization;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Keynote {

    private static final Map<String, Keynote> items = new HashMap<>();
    static {
        items.put("1",new Keynote("a1","b"));
        items.put("2",new Keynote("a2","b"));
        items.put("3",new Keynote("a3","b"));
        items.put("4",new Keynote("a4","b"));
    }
    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String color;

    public Keynote(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(items));
    }

}
