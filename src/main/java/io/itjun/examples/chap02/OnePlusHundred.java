package io.itjun.examples.chap02;

public class OnePlusHundred {
    public static void main(String[] args) {
        int i = 1;
        int j = 100;
        forPlus(i, j);
        whilePlus(i, j);
        doWhilePlus(i, j);
        gaussianPlus(i, j);
    }

    private static void forPlus(int i, int j) {
        int sum = 0;
        for (; i < j + 1; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static void whilePlus(int i, int j) {
        int sum = 0;
        while (i < j + 1) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }

    private static void doWhilePlus(int i, int j) {
        int sum = 0;
        do {
            sum += i;
            i++;
        } while (i < j + 1);
        System.out.println(sum);
    }

    private static void gaussianPlus(int i, int j) {
        int sum = 0;
        sum = (i + j) * j / 2;
        System.out.println(sum);
    }

}
