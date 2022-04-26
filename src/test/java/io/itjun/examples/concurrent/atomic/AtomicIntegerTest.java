package io.itjun.examples.concurrent.atomic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * addAndGet()- 以原子方式将给定值添加到当前值，并在添加后返回新值。
 * getAndAdd() - 以原子方式将给定值添加到当前值并返回旧值。
 * <p>
 * incrementAndGet()- 以原子方式将当前值递增1并在递增后返回新值。它相当于i ++操作。
 * getAndIncrement() - 以原子方式递增当前值并返回旧值。它相当于++ i操作。
 * <p>
 * decrementAndGet()- 原子地将当前值减1并在减量后返回新值。它等同于i-操作。
 * getAndDecrement() - 以原子方式递减当前值并返回旧值。它相当于-i操作。
 */
@Slf4j
public class AtomicIntegerTest {

    @Test
    public void test_1() {
        AtomicInteger atomic = new AtomicInteger();
        log.info("{}", atomic.get());//0
        log.info("{}", atomic.incrementAndGet());//1

        log.info("{}", atomic.addAndGet(5));//返回新值 6
        log.info("{}", atomic.getAndAdd(5));// 返回旧值 6
        log.info("{}", atomic.get());// 11

        log.info("{}", atomic.incrementAndGet());//  1++，返回新值 12
        log.info("{}", atomic.getAndIncrement());// ++1，返回旧值 12
        log.info("{}", atomic.get());// 13

        log.info("{}", atomic.getAndDecrement());//  --1，返回旧值 13
        log.info("{}", atomic.decrementAndGet());// 1--，返回新值 11
        log.info("{}", atomic.get());// 11
    }

}
