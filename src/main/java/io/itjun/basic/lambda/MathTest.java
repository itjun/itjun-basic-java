package io.itjun.basic.lambda;

public class MathTest {

    public static int sum(int x, int y) {
        if (x < 0 || y < 0)
            throw new RuntimeException("传入参数必须是正整数");

        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }

        int sum = 0;
        while (x <= y) {
            if (x % 2 != 0)
                sum += x;
            x++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(5, 1));
    }

}
