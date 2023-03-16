package io.itjun.examples.java17.dateformat;

public record Person(String name, String address) {

    /**
     * 默认是未命名的用户
     *
     * @param address 用户地址
     * @return
     */
    public static Person unnamed(String address) {
        return new Person("Unnamed", address);
    }

}
