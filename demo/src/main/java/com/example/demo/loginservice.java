package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginservice {
    @Autowired
    private loginrepository repo;

    public Login login(String username,String password){
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }
}
