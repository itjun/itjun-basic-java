package io.itjun.basic.java17.dateformat;

import io.itjun.basic.math.StringUtils;

import java.io.Serializable;

public record Person(String name, String address) implements Serializable {

    public Person {
        if (StringUtils.isEmpty(name))
            throw new IllegalArgumentException("name can not be empty");
    }

    /**
     * 默认是未命名的用户
     *
     * @param address 用户地址
     * @return 未命名的用户对象
     */
    public static Person unnamed(String address) {
        return new Person("Unnamed", address);
    }

}
