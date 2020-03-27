package io.itjun.examples.chap02;

/**
 * Created by itjun on 2016/10/5 0005.
 */
public class Operation {
    public static void main(String[] args) {
        System.out.println(and(false, false));
        System.out.println(and(false, true));
        System.out.println(and(true, false));
        System.out.println(and(true, true));
        System.out.println(and(false, false));
    }

    public static boolean and(boolean a, boolean b) {
        return a & b;
    }

}
