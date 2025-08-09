package com.example.wiprospringboottasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application4.properties")
public class DemoApplication4 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication4.class, args);
    }
}
