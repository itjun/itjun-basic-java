package json.wechat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 10914 on 2017/4/13.
 */
public class WeChatRecord {
    /**
     * 用户id
     **/
    private String touser;

    /**
     * 模版id
     **/
    private String template_id;

    /**
     * 消息跳转url
     **/
    private String url;

    /**
     * 消息模版内容
     **/
    private Map<String, Keynote> data = new TreeMap<>();

    public WeChatRecord(String touser, String template_id) {
        this.touser = touser;
        this.template_id = template_id;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Keynote> getData() {
        return data;
    }

    public void addData(String key, Keynote value) {
        data.put(key, value);
    }

}
