package io.itjun.basic.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 对双精度浮点数四舍五入计算
 */
public class MathTool {

    private static final RoundingMode mode = RoundingMode.HALF_EVEN;// 银行家舍入模式
    private static final int scale = 2;// 默认保留的小数位数

    private MathTool() {
    }

    public static double add(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.add(d2);
        return result.setScale(scale, mode).doubleValue();
    }

    public static double subtract(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.subtract(d2);
        return result.setScale(scale, mode).doubleValue();
    }

    public static double multiply(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.multiply(d2);
        return result.setScale(scale, mode).doubleValue();
    }

    public static double divide(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(Double.toString(v1));
        BigDecimal d2 = new BigDecimal(Double.toString(v2));
        BigDecimal result = d1.divide(d2, scale, mode);
        return result.doubleValue();
    }

    public static void main(String[] args) {
//        System.out.println(0.1 + 0.2);
//        System.out.println(MathTool.add(0.1, 0.2));
//        System.out.println(MathTool.subtract(37121, 0.475));

        System.out.println(37121 * 0.475);
        System.out.println(MathTool.multiply(37121, 0.475));
//
//        System.out.println(6879 * 0.475);
//        System.out.println(MathTool.multiply(6879, 0.475));

//        System.out.println(MathTool.divide(1, 3));
    }

}
