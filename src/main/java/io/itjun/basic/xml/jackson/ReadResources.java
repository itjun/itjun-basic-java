package io.itjun.basic.xml.jackson;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

@Slf4j
public class ReadResources {

    public static void main(String[] args) {
        String reqXml = readeXml("sf/1.order_request.xml");
        log.info(reqXml);
    }

    private static String readeXml(String path) {
        String xml = null;
        try {
            ClassLoader classLoader = ReadResources.class.getClassLoader();
            InputStream input = classLoader.getResourceAsStream(path);

            byte[] bs = new byte[input.available()];
            input.read(bs);
            xml = new String(bs);
            log.info(xml);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        if (xml == null) {
            throw new RuntimeException("xml 文件为空");
        }
        return xml;
    }

}
