package io.itjun.examples.date;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

/**
 * LocalTime 只包含时间，不包含日期
 */
@Slf4j
public class LocalTimeTest {

    public static void main(String[] args) {

        // LocalTime 包含毫秒
        LocalTime time_now = LocalTime.now();
        log.info("{}", time_now);

        // LocalTime 清除毫秒
        LocalTime now = LocalTime.now().withNano(0);
        log.info("{}", now);

        // 构造时间也很简单：
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
        /**
         * 时间也是按照ISO格式识别，但可以识别以下3种格式：
         * 12:00
         * 12:01:02
         * 12:01:02.345
         */
    }

}
