package io.itjun.basic.json.gson.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.itjun.basic.config.AppConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 微信公众号消息推送格式
 */
@Slf4j
public class WeChatPushGson {

    public static void main(String[] args) {
        WeChatRecord obj = new WeChatRecord("openid", "userid");
        obj.setUrl("FrmMessages.show");

        // 添加data内容
        obj.put("first", new Keynote("恭喜你购买成功！", "#173177"));
        obj.put("keynote1", new Keynote("巧克力", "#173177"));
        obj.put("keynote2", new Keynote("39.8元", "#173177"));
        obj.put("keynote3", new Keynote("2014年9月22日", "#173177"));
        obj.put("remark", new Keynote("欢迎再次购买！", "#173177"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(obj);
        log.info("{}", json);

        log.info(AppConfig.Split_Line);

        WeChatRecord item = gson.fromJson(json, WeChatRecord.class);
        log.info("目标用户 {}", item.getTouser());
        log.info("模板编号 {}", item.getTemplate_id());
        log.info("详情地址 {}", item.getUrl());

        log.info(AppConfig.Split_Line);
        Map<String, Keynote> map = item.getData();
        item.getData().forEach((k, v) -> {
            log.info("{}-> {} {}", k, v.getColor(), v.getValue());
        });

    }

}
