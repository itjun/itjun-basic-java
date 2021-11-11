package io.itjun.examples.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 对双精度浮点数四舍五入计算
 */
public class MathTool {

    private MathTool() {
    }

    public static double add(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.add(d2);
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double subtract(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.subtract(d2);
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double multiply(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.multiply(d2);
        return result.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double divide(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.divide(d2, 2, RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    public static void main(String[] args) {
//        System.out.println(MathTool.add(37121, 0.475));
//        System.out.println(MathTool.subtract(37121, 0.475));

        System.out.println(37121 * 0.475);
        System.out.println(MathTool.multiply(37121, 0.475));

        System.out.println(6879 * 0.475);
        System.out.println(MathTool.multiply(6879, 0.475));

//        System.out.println(MathTool.divide(1, 3));
    }

}
