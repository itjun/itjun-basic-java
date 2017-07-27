package json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.wechat.Keynote;
import json.wechat.WeChatRecord;

import java.util.Map;

/**
 * Created by 10914 on 2017/4/23.
 */
public class WeChatPushGson {
    public static void main(String[] args) {
        WeChatRecord wechat = new WeChatRecord("openid", "userid");
        wechat.setUrl("FrmMessages.show");

        // 添加data内容
        wechat.addData("first", new Keynote("恭喜你购买成功！", "#173177"));
        wechat.addData("keynote1", new Keynote("巧克力", "#173177"));
        wechat.addData("keynote2", new Keynote("39.8元", "#173177"));
        wechat.addData("keynote3", new Keynote("2014年9月22日", "#173177"));
        wechat.addData("remark", new Keynote("欢迎再次购买！", "#173177"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(wechat);
        System.out.println(json);

        jsonToObject(json);
    }

    public static void jsonToObject(String json) {
        Gson gson = new Gson();
        WeChatRecord wechat = gson.fromJson(json, WeChatRecord.class);
        System.out.println(wechat.getTouser());
        System.out.println(wechat.getTemplate_id());

        Map<String, Keynote> map = wechat.getData();
        System.out.println(map);
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println("key " + map.get(key).getColor());
            System.out.println("value " + map.get(key).getValue());
        }
    }
}
