package io.itjun.examples.json.netjson;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class JSONObjectToList {

    private static final String weather = "{\"data\":{\"city\":\"深圳\",\"temphigh\":\"25\",\"templow\":\"19\",\"updatetime\":\"2017-11-04 13:23:00\",\"tempnow\":\"24\",\"sendibletemp\":\"27\",\"winddirect\":\"东北风\",\"windpower\":\"2级\",\"humidity\":\"42\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"weather\":\"多云\",\"week\":\"星期六\",\"nl\":null,\"date\":\"2017-11-04\",\"index\":[{\"name\":\"化妆指数\",\"level\":\"控油\",\"msg\":\"建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。\"},{\"name\":\"感冒指数\",\"level\":\"易发\",\"msg\":\"感冒容易发生，少去人群密集的场所有利于降低感冒的几率。\"},{\"name\":\"洗车指数\",\"level\":\"不宜\",\"msg\":\"雨(雪)水和泥水会弄脏您的爱车，不适宜清洗车辆。\"},{\"name\":\"穿衣指数\",\"level\":\"舒适\",\"msg\":\"白天温度适中，但早晚凉，易穿脱的便携外套很实用。\"},{\"name\":\"紫外线强度指数\",\"level\":\"弱\",\"msg\":\"辐射较弱，涂擦SPF12-15、PA+护肤品。\"},{\"name\":\"运动指数\",\"level\":\"不适宜\",\"msg\":\"受到阵雨天气的影响，不宜在户外运动。\"}],\"pm25\":{\"aqi\":0,\"co\":8,\"o3\":42,\"pm10\":63,\"pm2_5\":64,\"quality\":\"良\",\"so2\":4,\"no2\":11,\"updatetime\":\"2017-11-04 13:00:00\"},\"daily\":[{\"date\":\"2017-11-04\",\"week\":\"星期六\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"25\",\"templow\":\"19\",\"weather\":\"多云\"},{\"date\":\"2017-11-05\",\"week\":\"星期日\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"26\",\"templow\":\"19\",\"weather\":\"多云\"},{\"date\":\"2017-11-06\",\"week\":\"星期一\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"27\",\"templow\":\"20\",\"weather\":\"多云\"},{\"date\":\"2017-11-07\",\"week\":\"星期二\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"28\",\"templow\":\"21\",\"weather\":\"多云\"},{\"date\":\"2017-11-08\",\"week\":\"星期三\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"29\",\"templow\":\"22\",\"weather\":\"多云\"},{\"date\":\"2017-11-09\",\"week\":\"星期四\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"28\",\"templow\":\"22\",\"weather\":\"多云\"},{\"date\":\"2017-11-03\",\"week\":\"星期五\",\"sunrise\":\"06:29\",\"sunset\":\"17:45\",\"temphigh\":\"28\",\"templow\":\"18\",\"weather\":\"晴\"}]},\"status\":0,\"msg\":\"ok\"}";

    public static void main(String[] args) {
        // 1、将字符串转化为json对象
        JSONObject json = JSONObject.fromObject(weather);

        // 1、JSONObject 本身就是继承Map对象
        Map<String, Object> items = JSONObject.fromObject(weather);
        items.forEach((key, value) -> {
            log.info("{} {}", key, value);
        });

        // 2、利用JSONString进行简单解析，直接读取基本对象信息
        JSONObject data = json.getJSONObject("data");
        log.info("data {}", data);
        log.info("city {}", data.getString("city"));
        log.info("temphigh {}", data.getString("temphigh"));
        log.info("templow {}", data.getString("templow"));

        // 3、利用JSONArray进行复杂解析，读取index/daily节点的数据信息
        JSONArray daily = data.getJSONArray("daily");
        List<String> dates = new ArrayList<>();
        List<String> weeks = new ArrayList<>();
        List<String> weathers = new ArrayList<>();
        for (int i = 0; i < daily.size(); i++) {
            JSONObject partDaily = daily.getJSONObject(i);
            String date = partDaily.getString("date");
            dates.add(date);

            String week = partDaily.getString("week");
            weeks.add(week);

            String weather = partDaily.getString("weather");
            weathers.add(weather);
        }
        log.info("dates {}", dates);
        log.info("weeks {}", weeks);
        log.info("weathers {}", weathers);
    }

}
