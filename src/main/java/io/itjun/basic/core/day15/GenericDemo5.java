package io.itjun.basic.core.day15;

//泛型定义在接口上。
interface Inter<T> {
    void show(T t);
}

/*
 * class InterImpl implements Inter<String> { public void show(String t) {
 * System.out.println("show :"+t); } }
 *
 */

class InterImpl<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println("show :" + t);
    }
}

public class GenericDemo5 {
    public static void main(String[] args) {

        InterImpl<Integer> i = new InterImpl<Integer>();
        i.show(4);
        // InterImpl i = new InterImpl();
        // i.show("haha");
    }
}
