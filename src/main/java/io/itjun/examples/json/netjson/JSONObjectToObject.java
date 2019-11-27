package io.itjun.examples.json.netjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.itjun.examples.json.jackjson.Logistics;
import io.itjun.examples.json.jackjson.LogisticsInfo;
import io.itjun.examples.json.jackjson.LogisticsTrace;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.util.List;

@Slf4j
public class JSONObjectToObject {

    public static void main(String[] args) {
        String logisticJson = "{\"resultcode\":\"200\",\"reason\":\"查询物流信息成功\",\"result\":{\"company\":\"EMS\",\"com\":\"ems\",\"no\":\"1186465887499\",\"status\":\"1\",\"list\":[{\"datetime\":\"2016-06-15 21:44:04\",\"remark\":\"离开郴州市 发往长沙市【郴州市】\",\"zone\":\"\"},{\"datetime\":\"2016-06-20 17:55:00\",\"remark\":\"投递并签收，签收人：单位收发章 *【毕节地区】\",\"zone\":\"\"}]},\"error_code\":0}";

        JSONObject json = JSONObject.fromObject(logisticJson);
        Logistics logistics = (Logistics) JSONObject.toBean(json, Logistics.class);
        log.info("{}", logistics.getReason());

        LogisticsInfo info = logistics.getResult();
        List<LogisticsTrace> traces = info.getList();
        for (LogisticsTrace item : traces) {
            log.info("{}", item.getDatetime());
            log.info("{}", item.getRemark());
            log.info("{}", item.getZone());
        }
    }

}
