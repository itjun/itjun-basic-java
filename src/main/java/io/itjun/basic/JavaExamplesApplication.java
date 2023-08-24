package io.itjun.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavaExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaExamplesApplication.class, args);
    }

}
