package io.itjun.examples.json.gson.deserialization;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GsonToString {

    public static void main(String[] args) {
        String result = "{\"code\":2000,\"msg\":\"景区数据获取成功\",\"data\":{\"pageInfo\":{\"curPage\":\"1\",\"nextPage\":2,\"countPage\":225},\"senicList\":[{\"senic_id\":\"2753\",\"name\":\"欢乐海岸海洋奇梦馆\",\"address\":\"广东省深圳市南山区白石路东8号欢乐海岸购物中心二楼东端\",\"longitude\":\"113.996161\",\"latitude\":\"22.532679\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-29/298c974e32e.jpg\",\"short_description\":\"海洋奇梦馆地址广东省深圳市南山区欢乐海岸内，占地面积2800平方米。\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"4A级景区\",\"distance\":3.404,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"1354\",\"name\":\"青青世界\",\"address\":\"广东省深圳市南山区月亮湾\",\"longitude\":\"113.905251\",\"latitude\":\"22.507011\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-29/86875a7174f.jpg\",\"short_description\":\"青青世界是一家以休闲度假为主题的观光农场，为“鹏城十景”之一。园区占地面积约20万平方米，景区为分侏罗纪公园、蝴蝶谷、瓜果园、陶艺馆、园艺馆等，另建有欧陆风情的木屋别墅、酒店客户、中餐厅、游泳池、钓鱼池等。青青世界的“蝴蝶谷”是一个让生活轻松，让生命飞舞的昆虫乐园。占地几千平方米，利用自然山谷建成，以网连接，将山谷封闭起来，延绵数百米，谷中植被参差错落，有近几十种数千只蝴蝶在里面生息繁衍，品种主要\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"4A级景区\",\"distance\":13.138,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"3234\",\"name\":\"羊台山龙之谷游乐园\",\"address\":\"广东省深圳市宝安区石岩街道龙腾路\",\"longitude\":\"113.954222\",\"latitude\":\"22.670963\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-06-01/56be8cb35b1.png\",\"short_description\":\"龙之谷游乐园位于深圳市宝安区石岩街道龙腾路13号（羊台山高尔夫练习场），风景秀丽，空气清新。景区内有太空飞碟、飓风飞椅、海盗船、疯狂碰碰车、自控飞机、立环跑车、青蛙跳、旋转木马等几十种娱乐项目。\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"3A景区\",\"distance\":15.721,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"2790\",\"name\":\"九龙山花仙谷\",\"address\":\"观澜九龙山高尔夫球会内\",\"longitude\":\"114.015257\",\"latitude\":\"22.716297\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-06-01/0c97c638da0.jpg\",\"short_description\":\"观澜九龙山花仙谷，一个隐秘在深圳的世外桃源。这里森林植被覆盖，原始生态环境优美，人工栽培大片花卉，打造成浪漫的原生态花卉主题乐园，有缤纷花海、奇妙恐龙世界、欢乐天地、花仙谷大剧院等游玩区供您赏玩。在这里，您可以在绿荫与浪漫花海间畅游，在花海中邂逅多种多样的仿真恐龙，带着小朋友认识远古时期地球霸主，满足探险的欲望，亦可畅玩游乐设施，尽情享受美妙的假期。 \",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"3A景区\",\"distance\":18.962,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"4380\",\"name\":\"流星谷欢乐世界\",\"address\":\"广东省深圳市宝安区沙井镇洪田火山公园\",\"longitude\":\"113.863340\",\"latitude\":\"22.708604\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-26/6b94cd0e4c7.jpg\",\"short_description\":\"\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"4A级景区\",\"distance\":24.603,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"3270\",\"name\":\"深圳光明农场农科大观园\",\"address\":\"广东省深圳市宝安区深圳宝安光明街道\",\"longitude\":\"113.942728\",\"latitude\":\"22.754413\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-31/ad1b80a2dba.jpg\",\"short_description\":\"光明农场位于深圳西北部，距市区30分种车程，占地55平方公里，拥有31平方公里山林，上万亩果园，森林覆盖率达70％，七个姿态各异大小水库和众多的鱼塘明珠般地洒落其中，到处青山绿水，仿若世外桃园。回归自然，返璞归真已成为人们新的休闲心态的今天，作为深圳一个绿色环保的天堂，常有港及国内外旅游团体来光明农场品尝乳鸽的美味、牛奶的淳香、水果的鲜甜、观览奶牛的风姿及“落地皇鸽”的神采。农场的旅游开发规划已纳\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"3A景区\",\"distance\":24.693,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"2722\",\"name\":\"龙凤山庄影视度假村\",\"address\":\"广东省东莞市凤岗镇官井头嘉辉路龙凤山庄渡假村 \",\"longitude\":\"114.200411\",\"latitude\":\"22.721688\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-29/ba2c2b12c26.jpg\",\"short_description\":\"亚热带海洋气候覆盖下，龙凤山庄气候宜人、全年无霜，加上纯天然的山林地貌，环境幽雅、空气清新、上百种珍稀植物，高达百分之七十五的绿色覆盖，是闹市中的世外桃源，钢铁森林里的天然氧吧。庄内客侨风情园、欧式风情园、南亚风情园、日式风情园等四大“风情园”交相映衬，古堡倩影、圣泉证盟、仙鹊归巢、金盆献花、客侨流韵、童话奇缘、佛台夕照、湖岸夜泊等龙凤八大景各为特色、蜜月休闲、餐饮娱乐、旅游度假为一体的一站式影视\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"4A级景区\",\"distance\":26.494,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"4385\",\"name\":\"喜悦滑冰\",\"address\":\"深圳市龙岗区爱南路666号COCOParK购物中心\",\"longitude\":\"114.235128\",\"latitude\":\"22.697469\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-31/8b84998ad12.jpg\",\"short_description\":\"\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"4A级景区\",\"distance\":27.282,\"passport_type_name\":\"[黄金版]\"},{\"senic_id\":\"2654\",\"name\":\"东部华侨城茶溪谷\",\"address\":\"深圳市盐田区大梅沙东部华侨城 \",\"longitude\":\"114.299739\",\"latitude\":\"22.623307\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-06-02/d7d0c78c836.jpg\",\"short_description\":\"东部华侨城茶溪谷 茶溪谷体现中西文化交融的休闲度假旅游文化，并兼有“茶、禅、花、竹”等主要元素，包括茵特拉根、湿地花园、茶翁古镇和三洲茶园四个游览区，融合西方山地小镇的风情、湿地花海的浪漫、茶禅文化的融合和岭南茶田的幽雅。\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"5A级景区\",\"distance\":29.39,\"passport_type_name\":\"[豪华版]\"},{\"senic_id\":\"2742\",\"name\":\"海上田园\",\"address\":\"广东省深圳市宝安区沙井镇\",\"longitude\":\"113.811930\",\"latitude\":\"22.744954\",\"thumbnail\":\"http://zslyadmin.yytxlyw.com/Uploads/Picture/2018-05-29/d84a03ef5c9.jpg\",\"short_description\":\"2005年海上田园已成为一个大型会议接待中心，拥有四星级标准客房280间。\",\"advance\":1,\"cate_name\":\"自然风光\",\"level_name\":\"4A级景区\",\"distance\":31.171,\"passport_type_name\":\"[黄金版]\"}]}}";

        // 获取指定的数据，可取代 net.json 反序列化
        JsonObject json = JsonParser.parseString(result).getAsJsonObject();
        log.info("msg {}", json.get("msg").getAsString());
        log.info("senicList {}", json.get("data").getAsJsonObject().get("senicList").toString());
    }

}
