package io.itjun.examples.chap07;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        System.out.println(getArrayList());
    }

    public static ArrayList<?> getArrayList() {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            items.add("P" + i);
        }

        ArrayList<String> list = new ArrayList<>();
        if (items.size() > 0 && items.size() < 10) {
            return items;
        } else {
            for (int i = 0; i < 10; i++) {
                list.add(items.get(i));
            }
            list.add("P11");
            items.clear();
            items = list;
            return items;
        }
    }
}
