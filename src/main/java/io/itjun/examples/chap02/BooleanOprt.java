package io.itjun.examples.chap02;

/**
 * 常见逻辑运算比较
 */
public class BooleanOprt {

    public static void main(String[] args) {
        boolean t = true;
        boolean f = false;

        System.out.println(t && f);
        System.out.println(t & f);

        System.out.println(t || f);
        System.out.println(t | f);

        // 逻辑或运算，短路或，不会计算后面的类型了
        System.out.println(t || (10 / 0 > 1));

        // 位或，会计算后面的类型
        System.out.println(t | (10 / 0 > 0));
    }

}
