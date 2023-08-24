package io.itjun.basic.chap02;

/**
 * 按位运算符
 */
public class BitCalc {

    public static void main(String[] args) {
        // 1111 1000
        int a = 0xF8;
        // 1111 0100
        int b = 0xF4;
        // 1111 1111
        int c = 0xFF;

        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~c);
    }

}
