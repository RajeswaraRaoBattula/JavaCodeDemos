package com.example.wiprospringboottasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application5.properties")  // ✅ this is good
public class DemoApplication5 {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication5.class, args);
    }
}
