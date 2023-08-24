package io.itjun.basic.json.netjson;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
public class MapToJSONObject {

    public static void main(String[] args) {
        /**
         * JSONObject 本质就是Map，构建json数据集需要一个个手动设置值
         */
        JSONObject json = new JSONObject();
        json.put("city", "深圳");
        json.put("temphigh", "25");
        json.put("templow", "19");
        json.put("tempnow", "24");
        log.info("{}", json.toString());
    }

}
