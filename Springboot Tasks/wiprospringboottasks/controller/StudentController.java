package com.example.wiprospringboottasks.controller;

import com.example.wiprospringboottasks.model.Student;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class StudentController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("sections", List.of("Graduate", "Post Graduate", "Research"));
        model.addAttribute("countries", List.of("India", "USA", "CANADA", "UK"));
        model.addAttribute("subjects", List.of("Physics", "Chemistry", "Life Science", "Political Science"));
        return "enrollment";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("student") Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sections", List.of("Graduate", "Post Graduate", "Research"));
            model.addAttribute("countries", List.of("India", "USA", "CANADA", "UK"));
            model.addAttribute("subjects", List.of("Physics", "Chemistry", "Life Science", "Political Science"));
            return "enrollment";
        }
        return "success";
    }
}

