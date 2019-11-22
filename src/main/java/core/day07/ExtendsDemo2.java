package core.day07;
/*
子父类出现后，类成员的特点：

类中成员：
1，变量。
2，函数。
3，构造函数。

1,变量
如果子类中出现非私有的同名成员变量时，
子类要访问本类中的变量，用this
子类要访问父类中的同名变量，用super。

super的使用和this的使用几乎一致。
this代表的是本类对象的引用。
super代表的是父类对象的引用。
*/

class Father {
    private int num = 4;

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class Son extends Father {
    void show() {
        System.out.println(super.getNum());
    }
}

public class ExtendsDemo2 {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}
