package com.example.demo;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class logincontroller {
public String usera;
public String password1;
@Autowired
private loginservice repo;

@GetMapping("/login")
public ModelAndView login() {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("credentials",new Login());
    return mav;
}

@PostMapping("/login")
public String loginsubmit(@ModelAttribute Login credentials ) {
    //TODO: process POST request
    usera=credentials.getUsername();
    password1=credentials.getPassword();
    Login user = repo.login(credentials.getUsername(),credentials.getPassword());
    if(Objects.nonNull(user)){
        return "home.html";
    }
    else{
        return "signup.html";
    }
}


}
