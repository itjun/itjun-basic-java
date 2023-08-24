package io.itjun.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class JsonToolTest {
    @Test
    public void test_1() {
        String value = "{\"data\":{\"_dataFrom\":\"waybill\",\"adsInfo\":{\"adId\":\"1732\",\"advertisementType\":\"COMMERCIAL\",\"bannerUrl\":\"http://ad-cdn.cainiao.com/1179/1619833399390.PNG\",\"miniBannerUrl\":\"http://ad-cdn.cainiao.com/1179/1619833388073.PNG\",\"trackUrl\":\"https://ad.cainiao.com/8ek6DbA\"},\"cpCode\":\"YTO\",\"needEncrypt\":false,\"packageInfo\":{\"items\":[{\"count\":6,\"name\":\"进口100米渔线\"},{\"count\":6,\"name\":\"德岛轮VM2000\"},{\"count\":1,\"name\":\"德岛鱼钩丸世10.0号\"}]},\"parent\":false,\"recipient\":{\"address\":{\"city\":\"杭州市\",\"detail\":\"笕桥镇 机场路190号草庄景墅14幢1201\",\"district\":\"江干区\",\"province\":\"浙江省\",\"town\":\"笕桥街道\"},\"mobile\":\"13221085372\",\"name\":\"陈红英\"},\"routingInfo\":{\"blockCode\":\"草庄景墅\",\"consolidation\":{\"code\":\"571930\"},\"endCode\":\"ADX\",\"endCodeId\":\"424428\",\"endCodeType\":\"1\",\"origin\":{\"code\":\"755060\",\"name\":\"广东省深圳市宝安区石岩\"},\"receiveBranch\":{\"code\":\"571019\",\"name\":\"浙江省杭州市彭埠\"},\"routeCode\":\"350-123-00 024\",\"sortation\":{\"name\":\"350石桥\"},\"startCenter\":{},\"terminalCenter\":{}},\"sender\":{\"address\":{\"city\":\"东莞市\",\"detail\":\"石潭埔工业区建业二路25号德岛渔具有限公司\",\"province\":\"广东省\"},\"mobile\":\"18128032739\",\"name\":\"东莞市德岛渔具有限公司\"},\"shippingOption\":{\"code\":\"STANDARD_EXPRESS\",\"title\":\"标准快递\"},\"waybillCode\":\"YT5432692308478\"},\"signature\":\"MD:p1FvzMhqk9imSemMK3MeNg==\",\"templateURL\":\"http://cloudprint.cainiao.com/template/standard/290659/35\"}";
        value = value.replaceAll("\\\\", "");
        log.info("去掉反斜杠 {}", value);
        value = value.replace("\"{", "{");
        log.info("去掉头部引号 {}", value);
        value = value.replace("}\"", "}");
        log.info("去掉尾巴引号 {}", value);
        System.out.println(value);
    }

}
