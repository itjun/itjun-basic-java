package io.itjun.examples.chap02;

/**
 * 验证低级的整型超出结果范围后会不会自动升级到更高级
 */
public class IntegerExample {

    public static void main(String[] args) {
        byte b1 = 127;
        byte b2 = 127;
        int value = b1 + b2;
        System.out.println(b1 + b2);
        System.out.println(value);
    }

}
