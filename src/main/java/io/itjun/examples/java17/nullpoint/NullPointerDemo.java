package io.itjun.examples.java17.nullpoint;

import io.itjun.examples.java17.records.GrapeClass;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class NullPointerDemo {

    public static void main(String[] args) {
        Map<String, GrapeClass> grapes = new HashMap<>();
        grapes.put("grape1", new GrapeClass(Color.BLUE, 2));
        grapes.put("grape2", new GrapeClass(Color.white, 4));
        grapes.put("grape3", null);// 增强型空指针异常，指出哪个链式方法为空
        var color = ((GrapeClass) grapes.get("grape3")).getColor();
    }

}
