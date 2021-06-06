package io.itjun.examples.desig.patterns.single;

/**
 * 静态内部类实现单例模，也实现了懒加载的功能
 */
public class SingletonInnerClass {

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    private SingletonInnerClass() {
    }

    private static class SingletonInstance {
        private static final SingletonInnerClass singleton = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return SingletonInstance.singleton;
    }

    public static void main(String[] args) {
        SingletonInnerClass item1 = SingletonInnerClass.getInstance();
        item1.setNum(20);

        SingletonInnerClass item2 = SingletonInnerClass.getInstance();
        System.out.println(item2.getNum());
    }

}
