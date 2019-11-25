package io.itjun.examples.json.gson.serialization;

import lombok.Getter;
import lombok.Setter;

public class Keynote {

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

}
