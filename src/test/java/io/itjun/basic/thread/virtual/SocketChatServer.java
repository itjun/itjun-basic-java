package io.itjun.basic.thread.virtual;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class SocketChatServer {

    public static void main(String[] args) {
        int port = 8090;
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket socket = server.accept();
                Thread.ofVirtual().start(() -> {
                    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String thread = Thread.currentThread().toString();
                            out.println(thread + " : " + line);
                            log.info("收到消息 {}", line);
                        }
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
