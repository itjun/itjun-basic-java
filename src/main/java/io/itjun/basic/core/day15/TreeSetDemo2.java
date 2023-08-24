package io.itjun.basic.core.day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
当元素自身不具备比较性，或者具备的比较性不是所需要的。
这时需要让容器自身具备比较性。
定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数。

当两种排序都存在时，以比较器为主。

定义一个类，实现Comparator接口，覆盖compare方法。


*/
class Student3 implements Comparable// 该接口强制让学生具备比较性。
{
    private String name;
    private int age;

    Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object obj) {

        // return 0;

        if (!(obj instanceof Student3))
            throw new RuntimeException("不是学生对象");
        Student3 s = (Student3) obj;

        // System.out.println(this.name+"....compareto....."+s.name);
        if (this.age > s.age)
            return 1;
        if (this.age == s.age) {
            return this.name.compareTo(s.name);
        }
        return -1;
        /**/
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }
}

public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();

        ts.add(new Student3("lisi02", 22));
        ts.add(new Student3("lisi02", 21));
        ts.add(new Student3("lisi007", 20));
        ts.add(new Student3("lisi09", 19));
        ts.add(new Student3("lisi06", 18));
        ts.add(new Student3("lisi06", 18));
        ts.add(new Student3("lisi007", 29));
        // ts.add(new Student("lisi007",20));
        // ts.add(new Student("lisi01",40));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            Student3 stu = (Student3) it.next();
            System.out.println(stu.getName() + "..." + stu.getAge());
        }
    }
}

class MyCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student3 s1 = (Student3) o1;
        Student3 s2 = (Student3) o2;

        int num = s1.getName().compareTo(s2.getName());
        if (num == 0) {

            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
            /*
             * if(s1.getAge()>s2.getAge()) return 1; if(s1.getAge()==s2.getAge()) return 0;
             * return -1;
             */
        }

        return num;

    }
}