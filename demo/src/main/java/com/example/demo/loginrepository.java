package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface loginrepository extends JpaRepository<Login, Integer>{
Login findByUsernameAndPassword(String username,String password);
}
