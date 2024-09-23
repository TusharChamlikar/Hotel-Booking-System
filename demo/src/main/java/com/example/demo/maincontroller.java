package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class maincontroller {
    @GetMapping()
    public String getMethodName() {
        return "main.html";
    }
    
}
