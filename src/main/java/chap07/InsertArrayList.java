package chap07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by iCrazyTeam on 2017/1/17.
 */
public class InsertArrayList {
    private static final Logger log = LoggerFactory.getLogger(InsertArrayList.class);

    public static void main(String[] args) {
        step1();

        step2();
    }

    private static void step1() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list1.add(i);
        }
        log.info("ArrayList spend {} ms", (System.currentTimeMillis() - start));
    }


    private static void step2() {
        LinkedList<Integer> list3 = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list3.add(i);
        }
        log.info("LinkedList spend {} ms", (System.currentTimeMillis() - start));
    }
}
