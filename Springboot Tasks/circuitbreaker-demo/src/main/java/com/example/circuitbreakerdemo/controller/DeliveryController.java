package com.example.circuitbreakerdemo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DELIVERY_SERVICE = "deliveryService";

    @GetMapping("/check-status")
    @CircuitBreaker(name = DELIVERY_SERVICE, fallbackMethod = "fallbackStatus")
    public String checkDeliveryStatus() {
        String url = "http://localhost:9091/delivery/status";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackStatus(Exception ex) {
        return "Fallback response: Delivery service is currently unavailable.";
    }
}