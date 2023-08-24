package io.itjun.basic.core.day23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TextClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("192.168.1.254", 10006);

        BufferedReader bufr = new BufferedReader(new FileReader("IPDemo.java"));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String line = null;
        while ((line = bufr.readLine()) != null) {
            out.println(line);
        }

        s.shutdownOutput();// 关闭客户端的输出流。相当于给流中加入一个结束标记-1.

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str = bufIn.readLine();
        System.out.println(str);

        bufr.close();

        s.close();
    }
}

class TextServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10006);

        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "....connected");

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(new FileWriter("server.txt"), true);

        String line = null;

        while ((line = bufIn.readLine()) != null) {
            // if("over".equals(line))
            // break;
            out.println(line);
        }

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("上传成功");

        out.close();
        s.close();
        ss.close();

    }
}
