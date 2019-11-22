package io.itjun.examples.chap08.stackTrce;

import java.util.Scanner;

/**
 * A program that displays a trace feature of a recursive method call
 * <p>
 * Created by iCrazyTeam on 2016/7/1 0026
 */
public class StrackTraceTest {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter n :");
            int n = in.nextInt();
            factorial(n);
        }
    }

    /**
     * Computes the factorial of a number
     *
     * @param n a non-negative integer
     * @return n! = 1 * 2 * .. * n
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[] items = t.getStackTrace();
        for (StackTraceElement item : items) {
            System.out.println(item);
        }
        int r;
        if (n <= 1) {
            return r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }
}
