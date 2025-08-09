package com.example.wiprospringboottasks;

import org.springframework.stereotype.Component;

@Component
public class ClassXYZ implements InterfacePQR {
    @Override
    public void display() {
        System.out.println("Hi... I am ClassXYZ");
    }
}
