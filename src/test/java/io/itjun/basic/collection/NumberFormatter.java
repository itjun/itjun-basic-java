package io.itjun.basic.collection;

public class NumberFormatter {
    public static void main(String[] args) {
        // 测试
        System.out.println(buildCode(1));    // 输出 001
        System.out.println(buildCode(11));   // 输出 011
        System.out.println(buildCode(98));   // 输出 098
        System.out.println(buildCode(238));  // 输出 238
        System.out.println(buildCode(1024));  // 输出 1024
    }

    public static String buildCode(int num) {
        if (num < 10) {
            return String.format("%03d", num);  // 数字小于10时，补充两位0
        } else if (num < 100) {
            return String.format("%03d", num);  // 数字小于100时，补充一位0
        } else {
            return String.valueOf(num);         // 数字三位及以上时，直接返回
        }
    }
}
