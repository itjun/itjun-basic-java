package chap07;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by iCrazyTeam on 2017/1/17.
 */
public class InsertArrayList {
    public static void main(String[] args) {
        //step1
        step1();

        //step2
        step2();

        //step3
        step3();
    }

    private static void step1() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list1.add(i);
        }
        System.out.println("spend " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void step2() {
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 10000000; i < 20000000; i++) {
            list2.add(i);
        }
        System.out.println("spend " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void step3() {
        LinkedList<Integer> list3 = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list3.add(i);
        }
        System.out.println("spend " + (System.currentTimeMillis() - start) + " ms");
    }
}
