package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingrepo extends JpaRepository<Book,Integer> {
    
}
