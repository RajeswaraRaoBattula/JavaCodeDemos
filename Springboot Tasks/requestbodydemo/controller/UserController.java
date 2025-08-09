package com.example.requestbodydemo.controller;

import com.example.requestbodydemo.model.User;
import com.example.requestbodydemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/users") // This maps POST /users
public class UserController {

    @PostMapping
    public String createUser(@RequestBody @Valid User user) {
        return "User created";
    }
}
