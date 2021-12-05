package io.itjun.examples.desig.patterns.single;

/**
 * 静态内部类实现单例模，也实现了懒加载的功能
 */
public class Holder {

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    private Holder() {
    }

    private static final class SingletonInstance {
        private static final Holder HOLDER = new Holder();
    }

    public static Holder getInstance() {
        return SingletonInstance.HOLDER;
    }

    public static void main(String[] args) {
        Holder item1 = Holder.getInstance();
        item1.setNum(20);

        Holder item2 = Holder.getInstance();
        System.out.println(item2.getNum());
    }

}
