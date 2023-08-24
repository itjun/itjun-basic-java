package io.itjun.basic.time;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeTest {

    public static void main(String[] args) {
        LocalDateTime n1 = LocalDateTime.now();
        System.out.println(n1);
        System.out.println(n1.getHour());
        System.out.println(n1.getMinute());

        // 生成指定的时分
        LocalTime now = LocalTime.of(1, 3);
        System.out.println(now.toString());
    }

}
