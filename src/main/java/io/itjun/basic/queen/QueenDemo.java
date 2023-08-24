package io.itjun.basic.queen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by itjun on 2017/4/25.
 */
public class QueenDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");

        for (String key : queue) {
            System.out.println(key);
        }
        System.out.println("--------->");

        System.out.println("poll " + queue.poll());
        for (String key : queue) {
            System.out.println(key);
        }
        System.out.println("--------->");

        System.out.println("element " + queue.element());
        for (String key : queue) {
            System.out.println(key);
        }
        System.out.println("--------->");

        System.out.println("peek " + queue.peek());
        for (String key : queue) {
            System.out.println(key);
        }
        System.out.println("--------->");
    }
}
