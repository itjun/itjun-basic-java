package chap03;

/**
 * Created by iCrazyTeam on 2016/10/5 0005.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib1(5));
        System.out.println(fib2(100));
        System.out.println(fib3(64));

        int n = 2000;
        long[] fib = generateFibonaccis(n);
        for (int i = 0; i < n; i++) {
            System.out.print(Long.toUnsignedString(fib[i]) + " ");
        }
    }

    /**
     * 递归计算斐波那契数--性能最差
     *
     * @param n
     * @return
     */
    public static long fib1(long n) {
        if (n < 2)
            return 1;
        else
            return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 迭代方法计斐波那契数
     *
     * @return
     */
    public static long fib2(long n) {
        int x = 0, y = 1;
        for (int i = 0; i < n; i++) {
            y = x + y;
            x = y - x;
        }
        return y;
    }

    /**
     * 通用公式项计算--算出来的结果差异很大
     *
     * @param n
     * @return
     */
    public static double fib3(long n) {
        double z = Math.sqrt(5.0);
        double x = (1 + z) / 2;
        double y = (1 - z) / 2;
        return (Math.pow(x, n) - Math.pow(y, n)) / z + 0.5;
    }

    public static long[] generateFibonaccis(int n) {
        long[] fib = new long[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; ++i) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib;
    }

}
