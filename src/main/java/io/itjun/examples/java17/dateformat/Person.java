package io.itjun.examples.java17.dateformat;

public record Person(String name, String address) {

    public static Person unnamed(String address) {
        return new Person("Unnamed", address);
    }

}
