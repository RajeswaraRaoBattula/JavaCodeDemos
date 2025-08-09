package com.example.wiprospringboottasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC")  // Injects ClassABC bean
    private InterfacePQR pqr;

    public void show() {
        pqr.display();
    }
}

