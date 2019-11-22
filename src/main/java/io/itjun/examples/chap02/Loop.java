package io.itjun.examples.chap02;

import java.math.BigDecimal;
import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
        System.out.println(whileText(1000, 200, 0.5));
        // doWhileText(5000, 0.5);
        System.out.println(lotteryOdds(50, 6));
        System.out.println(getDouble(1234.5677));
    }

    public static int whileText(double goal, double payment, double interestRate) {
        double balance = 0;
        int years = 0;
        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        return years;
    }

    public static void doWhileText(double payment, double interestRate) {
        double balance = 0;
        int years = 0;

        Scanner in = new Scanner(System.in);
        String input;
        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            years++;

            String output = String.format("After %s years, your balance is %.2f", years, balance);
            System.out.println(output);

            System.out.println("Are you ready to retire?(Y/N)");
            input = in.next();
        } while ("N".equals(input));

        if (in != null) {
            in.close();
        }
    }

    /**
     * @param n
     * @param k
     * @return result
     */
    public static int lotteryOdds(int n, int k) {
        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }
        return lotteryOdds;
    }

    /**
     * get setScale of dobuleType
     *
     * @param value
     * @return
     */
    public static double getDouble(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        double result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

}
