package io.itjun.examples.core.day21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class EncodeStream {
    public static void main(String[] args) throws IOException {
        // writeText();
        readText();
    }

    public static void readText() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("utf.txt"), "gbk");

        char[] buf = new char[10];
        int len = isr.read(buf);

        String str = new String(buf, 0, len);

        System.out.println(str);

        isr.close();
    }

    public static void writeText() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"), StandardCharsets.UTF_8);

        osw.write("你好");

        osw.close();
    }

}
