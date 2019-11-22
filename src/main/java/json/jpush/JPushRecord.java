package json.jpush;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iCrazyTeam on 2017/5/13.
 */
public class JPushRecord {
    private String platform;
    private Audience audience;
    private Map<String, Object> notification = new HashMap();
    private Message message;
    private Sms_message sms_message;
    private Options options;

    public static void main(String[] args) {
        JPushRecord push = new JPushRecord();
        push.setPlatform("all");
        push.setAudience(new Audience().addTag("深圳").addTag("北京"));
        push.addNotification("android", new Android().setAlert("Hi, JPush!").setTitle("Send to Android").setBuilder_id(1).addExtras("newsid", "321"));
        push.addNotification("ios", new IOS().setAlert("Hi, JPush!").setSound("default").setBadge("+1").addExtras("newsid", "321"));

        push.setMessage(new Message().setMsg_content("Hi,JPush").setContent_type("text").setTitle("msg").addExtras("key", "value"));
        push.setSms_message(new Sms_message().setContent("sms msg content").setDelay_time(3600));
        push.setOptions(new Options().setTime_to_live(60).setApns_production(false));

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

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public void addNotification(String key, Object value) {
        notification.put(key, value);
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Sms_message getSms_message() {
        return sms_message;
    }

    public void setSms_message(Sms_message sms_message) {
        this.sms_message = sms_message;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }
}
