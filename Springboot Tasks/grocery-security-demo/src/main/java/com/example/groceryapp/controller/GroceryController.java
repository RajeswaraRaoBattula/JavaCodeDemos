package com.example.groceryapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Welcome to the Grocery Store! This is a public endpoint.";
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return Arrays.asList("Apples", "Bananas", "Carrots");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orders")
    public List<String> getOrders() {
        return Arrays.asList("Order #1001", "Order #1002", "Order #1003");
    }
}