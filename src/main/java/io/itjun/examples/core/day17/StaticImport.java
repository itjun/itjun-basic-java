package io.itjun.examples.core.day17;

//导入了System类中所有静态成员。

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;

//导入的是Arrays这个类中的所有静态成员。
/*
packa/Demo.class
packb/Demo.class

import packa.*;
import packb.*;
*/
/*
StaticImport  静态导入。

当类名重名时，需要指定具体的包名。
当方法重名是，指定具备所属的对象或者类。
*/

public class StaticImport // extends Object
{
    public static void main(String[] args) {

        out.println("haha");
        int[] arr = {3, 1, 5};

        sort(arr);
        int index = binarySearch(arr, 1);
        out.println(Arrays.toString(arr));
        System.out.println("Index=" + index);

        ArrayList al = new ArrayList();
        al.add(1);
        al.add(3);
        al.add(2);

        out.println(al);

        sort(al);
        out.println(al);
    }
}
