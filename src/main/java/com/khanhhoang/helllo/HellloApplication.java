package com.khanhhoang.helllo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HellloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellloApplication.class, args);
    }

}
