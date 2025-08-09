package com.example.wiprospringboottasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication6 {
    public static void main(String[] args) {
        // Load custom properties file
        new SpringApplicationBuilder(DemoApplication6.class)
            .properties("spring.config.name=application6")
            .run(args);
    }
}

//http://localhost:9090/demo
