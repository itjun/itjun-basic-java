package io.itjun.basic.core.day19;

/*
通过缓冲区复制一个.java文件。

*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBuf {
    public static void main(String[] args) {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader("BufferedWriterDemo.java"));
            bufw = new BufferedWriter(new FileWriter("bufWriter_Copy.txt"));

            String line = null;

            while ((line = bufr.readLine()) != null) {
                bufw.write(line);
                bufw.newLine();
                bufw.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        } finally {
            try {
                if (bufr != null)
                    bufr.close();
            } catch (IOException e) {
                throw new RuntimeException("读取关闭失败");
            }
            try {
                if (bufw != null)
                    bufw.close();
            } catch (IOException e) {
                throw new RuntimeException("写入关闭失败");
            }
        }
    }
}
