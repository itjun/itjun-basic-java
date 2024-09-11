package io.itjun.basic.thread.virtual;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Slf4j
public class SocketChatClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8090)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));// 接收控制台输入
            String line;
            while ((line = console.readLine()) != null) {
                out.println(line);
                log.info("服务返回 {}", reader.readLine());
                if ("exit".equals(line))
                    break;
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
