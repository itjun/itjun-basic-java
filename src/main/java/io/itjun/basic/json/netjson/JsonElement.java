package io.itjun.basic.json.netjson;

import net.sf.json.JSONObject;

public class JsonElement {

    public static void main(String[] args) {
        JSONObject content = new JSONObject();
        content.element("service", "SvrMessage.search");
        content.element("timer", "127182718");
        content.element("process", 1);
        System.out.println(content.toString());

        JSONObject json = new JSONObject();
        json.put("service", "SvrMessage.search");
        json.put("timer", "127182718");
        json.put("process", 1);
        System.out.println(json.toString());

    }

}
