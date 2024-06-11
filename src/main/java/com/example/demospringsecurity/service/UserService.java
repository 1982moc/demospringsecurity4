package com.example.demospringsecurity.service;



import com.example.demospringsecurity.models.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);
    List<User> findByUsername(String username);
}