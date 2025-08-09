package com.example.wiprospringboottasks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyReader {

    @Value("${app.example.integer-value}")
    private Integer valueInteger;

    @Value("${app.example.decimal-value}")
    private Double valueDouble;

    @Value("${app.example.boolean-value}")
    private Boolean valueBoolean;

    public void printValues() {
        System.out.println("Integer value: " + valueInteger);
        System.out.println("Decimal value: " + valueDouble);
        System.out.println("Boolean value: " + valueBoolean);
    }
}
