package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class signupcontroller {
    @Autowired
    private signuprepository repo;

    @Autowired
    private loginrepository repo1;

    @GetMapping("/signup")
    public ModelAndView getMethodName() {
        ModelAndView mav = new ModelAndView("singup");
        mav.addObject("cred", new Signup());
        return mav;
    }
    @PostMapping("/signup")
    public String signupsubmit(@ModelAttribute Signup cred) {
         Signup temp = new Signup();
         temp.setFirstname(cred.getFirstname());
         temp.setLastname(cred.getLastname());
         temp.setMobilenumber(cred.getMobilenumber());
         temp.setUsername(cred.getUsername());
         temp.setPassword(cred.getPassword());
         Login l = new Login();
         l.setUsername(cred.getUsername());
         l.setPassword(cred.getPassword());
        //TODO: process POST request
        
        repo.save(temp);
        repo1.save(l);
        return "redirect:/login";
    }
    
    
}
