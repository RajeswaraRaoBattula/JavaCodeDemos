package com.example.wiprospringboottasks;

import org.springframework.stereotype.Component;

@Component
public class ClassABC implements InterfacePQR {
    @Override
    public void display() {
        System.out.println("Hi... I am ClassABC");
    }
}

