package io.itjun.examples.json.gson.deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.itjun.examples.json.jackson.Logistics;
import io.itjun.examples.json.jackson.LogisticsInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 混合数据对象序列化和解析
 */
@Slf4j
public class GsonToObject {

    public static void main(String[] args) {
        String json = "{\"resultcode\":\"200\",\"reason\":\"查询物流信息成功\",\"result\":{\"company\":\"EMS\",\"com\":\"ems\",\"no\":\"1186465887499\",\"status\":\"1\",\"list\":[{\"datetime\":\"2016-06-15 21:44:04\",\"remark\":\"离开郴州市 发往长沙市【郴州市】\",\"zone\":\"\"},{\"datetime\":\"2016-06-20 17:55:00\",\"remark\":\"投递并签收，签收人：单位收发章 *【毕节地区】\",\"zone\":\"\"}]},\"error_code\":0}";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Logistics logistic = gson.fromJson(json, Logistics.class);
        log.info("{}", logistic.getReason());

        LogisticsInfo info = logistic.getResult();
        info.getList().forEach((item) -> {
            log.info("{}", item.getDatetime());
            log.info("{}", item.getRemark());
            log.info("{}", item.getZone());
        });
    }

}
