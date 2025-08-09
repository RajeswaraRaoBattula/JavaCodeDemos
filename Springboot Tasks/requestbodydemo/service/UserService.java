package com.example.requestbodydemo.service;

import org.springframework.stereotype.Service;

import com.example.requestbodydemo.model.User;

@Service
public class UserService {

    public String saveUser(User user) {
        return "User saved: " + user.getFirstName() + " " + user.getLastName() + ", Age: " + user.getAge();
    }
}
