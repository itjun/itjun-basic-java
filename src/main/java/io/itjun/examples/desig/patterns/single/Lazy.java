package io.itjun.examples.desig.patterns.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Lazy {

    private boolean itjun = false;

    private Lazy() {
        synchronized (Lazy.class) {
            if (lazy != null) {
                // 防止反射
                throw new RuntimeException("别瞎搞，不要乱使用反射来创建对象。");
            }
        }
        System.out.println(Thread.currentThread().getName());
    }

    private static Lazy lazy;

    /**
     * 1、分配内存空间
     * 2、执行构造方法，初始化对象
     * 3、把这个对象指向这个空间
     * <p>
     * 可能执行 123
     * 也可能是 132 A
     * ->  B 得到null的对象
     */
    public static Lazy getInstance() {
        if (lazy == null) {
            lazy = new Lazy();// 不是原子操作
        }
        return lazy;
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(Lazy::getInstance).start();
//        }

        System.out.println(Lazy.getInstance());

        // 反射创建对象实例
        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Lazy item2 = declaredConstructor.newInstance();
        System.out.println(item2);

        // 反射获取对象并修改属性
        Field itjun = Lazy.class.getDeclaredField("itjun");
        itjun.setAccessible(true);
        itjun.set(item2, true);
    }

}
