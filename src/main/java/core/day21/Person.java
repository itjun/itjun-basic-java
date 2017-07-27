package core.day21;

import java.io.Serializable;

public class Person implements Serializable {

    public static final long serialVersionUID = 42L;
    static String country = "cn";
    transient int age;
    private String name;

    Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return name + ":" + age + ":" + country;
    }
}