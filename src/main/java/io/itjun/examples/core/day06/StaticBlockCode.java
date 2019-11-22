package io.itjun.examples.core.day06;

/*
静态代码块
static
{
	静态代码块中的执行语句。
}

特点：随着类的加载而执行，只执行一次,并优先于主函数。
用于给类进行初始化的。
*/
class StaticCode {
    static {
        System.out.println("a");
    }

    int num = 9;

    {
        System.out.println("c" + num);
    }

    StaticCode() {
        System.out.println("b");
    }

    StaticCode(int x) {
        System.out.println("d");
    }

    public static void show() {
        System.out.println("show run");
    }
}

public class StaticBlockCode {
    static {
        System.out.println("StaticBlockCode");
    }

    public static void main(String[] args) {
        new StaticCode(4);
    }
}
