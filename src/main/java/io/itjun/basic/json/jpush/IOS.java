package io.itjun.basic.json.jpush;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iCrazyMage on 2017/5/15.
 */
public class IOS {
    private String alert;
    private String title;
    private String builder_id;
    private String sound;
    private String badge;
    private Map<String, String> extras = new HashMap<>();

    public String getAlert() {
        return alert;
    }

    public IOS setAlert(String alert) {
        this.alert = alert;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public IOS setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBuilder_id() {
        return builder_id;
    }

    public IOS setBuilder_id(String builder_id) {
        this.builder_id = builder_id;
        return this;
    }

    public String getSound() {
        return sound;
    }

    public IOS setSound(String sound) {
        this.sound = sound;
        return this;
    }

    public String getBadge() {
        return badge;
    }

    public IOS setBadge(String badge) {
        this.badge = badge;
        return this;
    }

    public IOS addExtras(String key, String value) {
        extras.put(key, value);
        return this;
    }
}
