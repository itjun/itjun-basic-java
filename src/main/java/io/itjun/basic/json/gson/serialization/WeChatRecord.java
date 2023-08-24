package io.itjun.basic.json.gson.serialization;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 10914 on 2017/4/13.
 */
public class WeChatRecord {
    /**
     * 用户id
     **/
    @Getter
    @Setter
    private String touser;

    /**
     * 模版id
     **/
    @Getter
    @Setter
    private String template_id;

    /**
     * 消息跳转url
     **/
    @Getter
    @Setter
    private String url;

    /**
     * 消息模版内容
     **/
    @Getter
    @Setter
    private Map<String, Keynote> data = new TreeMap<>();

    public WeChatRecord(String touser, String template_id) {
        this.touser = touser;
        this.template_id = template_id;
    }

    public void put(String key, Keynote keynote) {
        this.data.put(key, keynote);
    }

}
