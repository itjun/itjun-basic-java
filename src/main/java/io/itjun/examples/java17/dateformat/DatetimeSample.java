package io.itjun.examples.java17.dateformat;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatetimeSample {

    /**
     * NumberFormat 中添加了一个工厂方法，以便根据 Unicode 标准以紧凑的、人类可读的形式格式化数字
     * <p>
     * SHORT 格式
     */
    public static void main(String[] args) {
        shortFormat();
        longFormat();
        test_B_Date();
    }

    private static void shortFormat() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(100000));
        System.out.println(fmt.format(1000000));
    }

    private static void longFormat() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(100000));
        System.out.println(fmt.format(1000000));
    }

    private static void test_B_Date() {
        System.out.println("""
                **********************
                * Chinese formatting *
                **********************""");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");// 中文

        // 英国之夜从 23 点开始，荷兰之夜从 01 点开始
//        dtf = DateTimeFormatter.ofPattern("B").withLocale(Locale.ENGLISH);// 英语
//        dtf = DateTimeFormatter.ofPattern("B").withLocale(Locale.forLanguageTag("NL"));// 荷兰语

        System.out.println(dtf.format(LocalTime.of(8, 0)));// 上午， in the morning
        System.out.println(dtf.format(LocalTime.of(14, 0)));
        System.out.println(dtf.format(LocalTime.of(20, 0)));
        System.out.println(dtf.format(LocalTime.of(23, 0)));
        System.out.println(dtf.format(LocalTime.of(0, 0)));
    }

}
