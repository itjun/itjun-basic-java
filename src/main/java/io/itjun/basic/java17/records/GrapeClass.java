package io.itjun.basic.java17.records;

import java.awt.*;
import java.util.Objects;

public class GrapeClass {

    private final Color color;
    private final int nbrOfPits;

    public GrapeClass(Color color, int nbrOfPits) {
        this.color = color;
        this.nbrOfPits = nbrOfPits;
    }

    public Color getColor() {
        return color;
    }

    public int getNbrOfPits() {
        return nbrOfPits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrapeClass that = (GrapeClass) o;
        return nbrOfPits == that.nbrOfPits && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, nbrOfPits);
    }

    @Override
    public String toString() {
        return "GrapeClass{" +
                "color=" + color +
                ", nbrOfPits=" + nbrOfPits +
                '}';
    }

    private static void oldStyle() {
        System.out.println("""
                *************
                * Old style *
                *************""");
        GrapeClass grape1 = new GrapeClass(Color.BLUE, 1);
        GrapeClass grape2 = new GrapeClass(Color.WHITE, 2);
        System.out.println("Grape 1 is " + grape1);
        System.out.println("Grape 2 is " + grape2);
        System.out.println("Grape 1 equals grape 2? " + grape1.equals(grape2));
        GrapeClass grape1Copy = new GrapeClass(grape1.getColor(), grape1.getNbrOfPits());
        System.out.println("Grape 1 equals its copy? " + grape1.equals(grape1Copy));
    }

    public static void main(String[] args) {
        oldStyle();
    }
}
