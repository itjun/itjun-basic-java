package io.itjun.basic.base64;

import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

@Slf4j
public class Base64Test {

    public static void main(String[] args) {
        String base64 = Base64.getEncoder().encodeToString("Hello World!".getBytes());
        log.info("encoder {}", base64);
        byte[] bytes = Base64.getDecoder().decode(base64);
        log.info("decode {}", bytes);
        log.info("decode {}", new String(bytes));
    }

}
