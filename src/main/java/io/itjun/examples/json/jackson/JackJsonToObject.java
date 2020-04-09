package io.itjun.examples.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Slf4j
public class JackJsonToObject {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        String json = "{\"resultcode\":\"200\",\"reason\":\"查询物流信息成功\",\"result\":{\"company\":\"EMS\",\"com\":\"ems\",\"no\":\"1186465887499\",\"status\":\"1\",\"list\":[{\"datetime\":\"2016-06-15 21:44:04\",\"remark\":\"离开郴州市 发往长沙市【郴州市】\",\"zone\":\"\"},{\"datetime\":\"2016-06-20 17:55:00\",\"remark\":\"投递并签收，签收人：单位收发章 *【毕节地区】\",\"zone\":\"\"}]},\"error_code\":0}";
        ObjectMapper mapper = new ObjectMapper();

        // Logistics logistic = mapper.readValue(json,Logistics.class);
        Logistics logistic = mapper.readValue(json, new TypeReference<Logistics>() {
        });
        log.info("{}", logistic.getReason());

        LogisticsInfo info = logistic.getResult();
        info.getList().forEach((item) -> {
            log.info("{}", item.getDatetime());
            log.info("{}", item.getRemark());
            log.info("{}", item.getZone());
        });

    }

    private static void objToJson() throws ParseException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632", sdf.parse("21-09-1982"), Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
        Movie movie = new Movie("tt0472043", "Mel Gibson", Arrays.asList(rudyYoungblood));
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(movie);
        log.info("{}", jsonResult);
    }

}
