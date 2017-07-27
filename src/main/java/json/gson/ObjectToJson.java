package json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.jpush.JPushRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iCrazyTeam on 2017/5/14.
 */
public class ObjectToJson {
    private String platform;
    private String audience;
    private String notification;
    private Map<String, String> items = new HashMap<>();

    public static void main(String[] args) {
        ObjectToJson push = new ObjectToJson();
        push.setPlatform("all");
        push.setAudience("tag");
        push.setNotification("android");

        push.items.put("C0001", "Apple");
        push.items.put("C0002", "Google");
        push.items.put("C0003", "Facebook");
        push.items.put("C0004", "Tencent");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(push);
        System.out.println(json);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
