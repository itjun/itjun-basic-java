package io.itjun.basic.chap02;

/**
 * 常见逻辑运算比较
 */
public class BooleanOprt {

    public static void main(String[] args) {
        // 小括号的高优先级运算调整
        int a = 10;
        int b = 88;
        boolean c = ((a + b) * a - (a - 1) * (a + b)) == (a + b);
        System.out.println(c);

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
