package io.itjun.basic.json.jpush;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itjun on 2017/5/15.
 */
public class Audience {
    private List<String> tag = new ArrayList<>();

    public Audience addTag(String value) {
        tag.add(value);
        return this;
    }
}
