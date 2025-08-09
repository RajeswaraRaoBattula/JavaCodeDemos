package com.example.wiprospringboottasks;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {

    @GetMapping("/users/{id}/accounts")
    public List<String> getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status) {

        return Arrays.asList(
                "User ID: " + id,
                "Account Type: " + type,
                "Account Status: " + status
        );
    }
}
