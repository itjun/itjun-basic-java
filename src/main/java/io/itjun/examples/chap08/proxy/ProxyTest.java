package io.itjun.examples.chap08.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * This Program demonstrates the use of proxies.
 * <p>
 * Created by itjun on 2016/6/28 0026.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer index = i + 1;
            InvocationHandler handler = new TraceHandler(index);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length + 1);
        int value = Arrays.binarySearch(elements, key);
        if (value >= 0) {
            System.out.println(elements[value]);
        }
    }
}
