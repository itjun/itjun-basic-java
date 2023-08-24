package io.itjun.basic.math;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 常用数学工具
 */
@Slf4j
public class MathUtils {

    public static void main(String[] args) {
        log.info(MathUtils.getRandom(5));
    }

    /**
     * @param len 数据长度
     * @return 指定长度的随机数
     */
    public static String getRandom(int len) {
        Random random = new Random();
        String verify = "";
        for (int i = 0; i < len; i++) {
            verify = verify + random.nextInt(10);
        }
        return verify;
    }

    /**
     * @param min 最小值
     * @param max 最大值
     * @return 指定范围内的随机整数
     */
    public static int getRandom(int min, int max) {
        if (max < min) {
            throw new RuntimeException("最大值范围不允许小于最小值");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}
