package io.itjun.basic.json.gson.serialization;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class KeynoteTest {

    @Test
    public void test_1() {
        Keynote keynote = new Keynote("1", "2");
        System.out.println(new Gson().toJson(keynote));
    }

}