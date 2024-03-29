package io.itjun.basic.core.day18;

//读取一个.java文件，并打印在控制台上。

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("DateDemo.java");

        char[] buf = new char[1024];

        int num = 0;

        while ((num = fr.read(buf)) != -1) {
            System.out.print(new String(buf, 0, num));
        }

        fr.close();
    }

}
