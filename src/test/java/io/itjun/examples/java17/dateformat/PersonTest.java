package io.itjun.examples.java17.dateformat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.itjun.examples.tools.JsonTool;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class PersonTest {

    @Test
    public void test_1() {
        Person person = new Person("itjun", "Shenzhen_601");
        String json = JsonTool.toJson(person);
        System.out.println(json);

        Person item = JsonTool.fromJson(json, Person.class);
        System.out.println(item.name());
        System.out.println(item.address());
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

    @Test
    public void test_3() {
        Person person = Person.unnamed("Shenzhen_601");
        System.out.println("--- getDeclaredFields ---");
        for (Field field : person.getClass().getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("--- getFields ---");
        for (Field field : person.getClass().getFields()) {
            System.out.println(field);
        }
    }

}