package io.itjun.examples.java17.dateformat;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void test_1() {
        Person person = new Person("itjun", "Shenzhen_601");
        System.out.println(new Gson().toJson(person));
        System.out.println(person.name());
        System.out.println(person.address());
    }

    @Test
    public void test_2() {
        Person person = Person.unnamed("Shenzhen_601");
        System.out.println(new Gson().toJson(person));
        System.out.println(person.name());
        System.out.println(person.address());
        System.out.println(Person.class.isRecord());
        System.out.println(Person.class.isAssignableFrom(Person.class));
    }

}