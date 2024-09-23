package com.example.demo;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class bookcontroller {
    @Autowired
    private loginservice repo;

    @Autowired
    private bookingrepo repo1;

    @GetMapping("/book")
    public ModelAndView book() {
        ModelAndView mav= new ModelAndView("book.html");
        mav.addObject("book1", new Book());
        return mav;
    }
    @PostMapping("/book")
    public String postMethodName(@ModelAttribute Book book1) {
        //TODO: process POST request
        Login l = repo.login(book1.getUsername(), book1.getPassword());
        Book p =new Book();
        p.setName(book1.getName());
        p.setLastname(book1.getLastname());
        p.setUsername(book1.getUsername());
        p.setPassword(book1.getPassword());
        p.setDate(book1.getDate());
        
        if(Objects.nonNull(l)){
        repo1.save(p);
        return "home.html";
        
    }
    else{
        return "signup.html";
    }
        
        
    }
    
    
}
