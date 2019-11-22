package io.itjun.examples.chap08.enums;

import java.util.Scanner;

/**
 * Created by iCrazyTeam on 16/6/20.
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size :(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size = " + size);
        System.out.println("abbreviation = " + size.getAbbreviation());

        for (Size en : Size.values()) {
            if (size == en) {
                System.out.println(String.format("Good job -- you paid attention on the %s.", en.getAbbreviation()));
            }
        }

        if (in != null) {
            in.close();
        }
    }
}