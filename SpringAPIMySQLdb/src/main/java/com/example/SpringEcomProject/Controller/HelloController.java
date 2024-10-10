package com.example.SpringEcomProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/greet")
    public String greet()
    {
        return "Welcome to project";
    }
}
