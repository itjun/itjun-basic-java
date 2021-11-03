package io.itjun.examples.java17.instance;

import io.itjun.examples.java17.records.GrapeClass;

import java.awt.*;

public class InstanceofDemo {
    public static void main(String[] args) {
        oldStyle();
        patternMatching();
        patternMatchingScopeException();
    }

    private static void oldStyle() {
        System.out.println("""
                *************
                * Old Style *
                *************""");
        Object o = new GrapeClass(Color.BLUE, 2);
        if (o instanceof GrapeClass) {
            GrapeClass grape = (GrapeClass) o;// 额外创建变量并强转
            System.out.println("This grape has " + grape.getNbrOfPits() + " pits.");
        }
    }

    private static void patternMatching() {
        System.out.println("""
                ********************
                * Pattern matching *
                ********************""");
        Object o = new GrapeClass(Color.BLUE, 2);
        /**
         * 可以在 instanceof 检查中创建变量，并且不再需要用于创建新变量和转换对象的额外行。
         */
        if (o instanceof GrapeClass grape) {
            System.out.println("This grape has " + grape.getNbrOfPits() + " pits.");
        }
    }

    private static void patternMatchingScopeException() {
        System.out.println("""
                **********************************************
                * Pattern matching scope test with exception *
                **********************************************""");
        Object o = new GrapeClass(Color.BLUE, 2);
        if (!(o instanceof GrapeClass grape)) {
            throw new RuntimeException();
        }
        System.out.println("This grape has " + grape.getNbrOfPits() + " pits.");
    }

}
