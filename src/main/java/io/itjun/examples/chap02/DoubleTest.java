package io.itjun.examples.chap02;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 浮点数测试
 */
public class DoubleTest {

    public static void main(String[] args) {
        double a = 1.0d - 0.9d;
        System.out.println(a);

        double b = 0.9d - 0.8d;
        System.out.println(b);

        System.out.println(a == b);

        double c = 0.1 + 0.2;
        System.out.println(c);  // 输出：0.30000000000000004
        BigDecimal decimal = new BigDecimal(c);
        System.out.println(decimal.doubleValue());

        // 正常精度的计算方式
        BigDecimal d1 = new BigDecimal(Double.toString(0.1));
        BigDecimal d2 = new BigDecimal(Double.toString(0.3));
        System.out.println(d1.subtract(d2).doubleValue());

        System.out.println(d1.add(d2).doubleValue());
        // System.out.println(d1.divide(d2));// 出现无限循环小数点报错
        System.out.println(d1.divide(d2, 2, RoundingMode.HALF_EVEN).doubleValue()); // 银行家舍入法

        System.out.println(1.1 + 1.2);  //输出：2.3
        System.out.println(0.1f + 0.2f);//输出：0.3

        // 四舍五入测试
        System.out.println("12.5的四舍五入值：" + Math.round(12.5));// 12.5的四舍五入值：13
        System.out.println("-12.5的四舍五入值：" + Math.round(-12.5));// -12.5的四舍五入值：-12

    }

}
