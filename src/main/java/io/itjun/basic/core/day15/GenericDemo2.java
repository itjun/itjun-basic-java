package io.itjun.basic.core.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(new LenComparator());

        ts.add("abcd");
        ts.add("cc");
        ts.add("cba");
        ts.add("aaa");
        ts.add("z");
        ts.add("hahaha");

        Iterator<String> it = ts.iterator();

        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
}

class LenComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));

        if (num == 0)
            return o2.compareTo(o1);
        return num;
    }
}