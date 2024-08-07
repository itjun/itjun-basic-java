package io.itjun.basic.core.day15;
/*
练习：按照字符串长度排序。

字符串本身具备比较性。但是它的比较方式不是所需要的。

这时就只能使用比较器。



*/

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new StrLenComparator());

        ts.add("abcd");
        ts.add("cc");
        ts.add("cba");
        ts.add("aaa");
        ts.add("z");
        ts.add("hahaha");

        Iterator it = ts.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class StrLenComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;

        /*
         * if(s1.length()>s2.length()) return 1; if(s1.length()==s2.length()) return 0;
         */

        int num = Integer.compare(s1.length(), s2.length());
        if (num == 0)
            return s1.compareTo(s2);

        return num;
    }
}
