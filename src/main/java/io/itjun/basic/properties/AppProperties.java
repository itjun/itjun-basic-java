package io.itjun.basic.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AppProperties {

    public static void main(String[] args) {
        try {
            String file = "/application.properties";
            InputStream inputStream = AppProperties.class.getResourceAsStream(file);
            final Properties properties = new Properties();
            if (inputStream == null) {
                System.out.println("file is empty.");
                return;
            }
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            properties.forEach((k, v) -> System.out.println(k + "=" + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
