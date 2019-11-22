package io.itjun.examples.core.day06;
/*
设计模式：解决某一类问题最行之有效的方法。
java中23种设计模式：
单例设计模式：解决一个类在内存只存在一个对象。

想要保证对象唯一。
1，为了避免其他程序过多建立该类对象。先禁止其他程序建立该类对象
2，还为了让其他程序可以访问到该类对象，只好在本类中，自定义一个对象。
3，为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式。

这三部怎么用代码体现呢？
1，将构造函数私有化。
2，在类中创建一个本类对象。
3，提供一个方法可以获取到该对象。

对于事物该怎么描述，还怎么描述。
当需要将该事物的对象保证在内存中唯一时，就将以上的三步加上即可。
*/

public class Single {
    private static Single single = new Single();
    private int count;

    private Single() {
    }

    public static Single getInstance() {
        return single;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Single single = Single.getInstance();
        single.setCount(2017);

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Single single = Single.getInstance();
                    System.out.println(single.getCount());
                }
            }).start();
        }

        long end = System.currentTimeMillis();
        System.out.println("use time" + (end - start));
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
