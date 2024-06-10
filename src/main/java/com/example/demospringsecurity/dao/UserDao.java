package com.example.demospringsecurity.dao;

//import ru.kata.spring.boot_security.demo.models.User;

import com.example.demospringsecurity.models.User;

import java.util.List;


public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);

    List<User> findByUsername(String username);
}
