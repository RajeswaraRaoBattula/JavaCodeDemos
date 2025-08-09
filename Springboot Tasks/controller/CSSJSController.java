package com.example.wiprospringboottasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSSJSController {

    @GetMapping("/demo")
    public String showDemoPage() {
        return "demo"; // maps to demo.html in templates
    }
}
