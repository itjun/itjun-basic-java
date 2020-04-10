package io.itjun.examples.date;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * SQL -> Java
 * --------------------------
 * date -> LocalDate
 * time -> LocalTime
 * timestamp -> LocalDateTime
 */
@Slf4j
public class LocalDateTest {

    public static void main(String[] args) {
        /**
         * Java8加入了LocalDate，在使用上比Calendar更好用，写法上也更简洁
         */

        // 取当前日期：
        LocalDate today = LocalDate.now(); // -> 2014-12-24

        // 根据年月日取日期，12月就是12：
        LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25

        // 根据字符串取日期
        LocalDate endOfFeb = LocalDate.parse("2014-02-28"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
//        LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
        // 取本月第2天
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31

        LocalDate monthBof = today.withDayOfMonth(1); // 当月的第一天
        LocalDate monthEof = today.withDayOfMonth(today.lengthOfMonth()); // 当月最后一天
        log.info("月初 {}", monthBof);
        log.info("月末 {}", monthEof);

        // 取下一天
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01

        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05

        // LocalDate 转为 Date
        Date date = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        log.info("时间转换 {}", date);
    }

}
