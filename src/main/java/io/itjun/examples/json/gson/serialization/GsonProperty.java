package io.itjun.examples.json.gson.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 如果只是单纯的添加key和value，还不如直接使用Map
 */
public class GsonProperty {

    public static void main(String[] args) {
        JsonObject user_auth = new JsonObject();
        user_auth.addProperty("user_name", "itjun");
        user_auth.addProperty("password", "123456");
        System.out.println(user_auth);
        System.out.println(String.valueOf(user_auth));
        System.out.println(new Gson().toJson(user_auth));

        JsonObject rest_data = new JsonObject();
        rest_data.addProperty("user_auth", String.valueOf(user_auth));
        rest_data.addProperty("application", "Apple Music");

        Gson gson = new Gson();
        String payload = gson.toJson(rest_data);
        System.out.println(payload);
    }

}
