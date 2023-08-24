package io.itjun.basic.json.jpush;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by itjun on 2017/5/15.
 */
public class Android {
    private String alert;
    private String title;
    private int builder_id;
    private Map<String, String> extras = new HashMap<>();

    public String getAlert() {
        return alert;
    }

    public Android setAlert(String alert) {
        this.alert = alert;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Android setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getBuilder_id() {
        return builder_id;
    }

    public Android setBuilder_id(int builder_id) {
        this.builder_id = builder_id;
        return this;
    }

    public Android addExtras(String key, String value) {
        extras.put(key, value);
        return this;
    }
}
