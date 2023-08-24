package io.itjun.basic.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 对比StringBuffer和StringBuilder
 * <p>
 * As for performance , after hotspot kicks in , StringBuilder is the winner.
 * <br/>
 * </>However , for small iterations , the performance difference is negligible.
 * <p>
 * https://stackoverflow.com/questions/355089/difference-between-stringbuilder-and-stringbuffer
 */
@Slf4j
public class StringBuilderTest {

    private static final int times = Integer.MAX_VALUE / 5;

    @Test
    public void test_buff() {
        long start = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        buffer.append("itjun".repeat(times));
        log.info("StringBuffer length {}, cost {}ms", buffer.length(), System.currentTimeMillis() - start);
    }

    @Test
    public void test_build() {
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        builder.append("itjun".repeat(times));
        log.info("StringBuilder length {}, cost {}ms", builder.length(), System.currentTimeMillis() - start);
    }

}