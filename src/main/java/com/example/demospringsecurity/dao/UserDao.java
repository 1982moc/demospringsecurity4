package com.example.demospringsecurity.dao;

//import ru.kata.spring.boot_security.demo.models.User;

import com.example.demospringsecurity.models.User;

import java.util.List;


public interface UserDao {

    User getUser(Long id);
    List<User> findByUsername(String username);
}