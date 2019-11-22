package io.itjun.examples.json.jpush;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iCrazyMage on 2017/5/15.
 */
public class Message {
    private String msg_content;
    private String content_type;
    private String title;
    private Map<String, String> extras = new HashMap<>();

    public String getMsg_content() {
        return msg_content;
    }

    public Message setMsg_content(String msg_content) {
        this.msg_content = msg_content;
        return this;
    }

    public String getContent_type() {
        return content_type;
    }

    public Message setContent_type(String content_type) {
        this.content_type = content_type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public Message addExtras(String key, String value) {
        extras.put(key, value);
        return this;
    }

}
