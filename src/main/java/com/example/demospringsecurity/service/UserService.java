package com.example.demospringsecurity.service;



import com.example.demospringsecurity.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);

}
