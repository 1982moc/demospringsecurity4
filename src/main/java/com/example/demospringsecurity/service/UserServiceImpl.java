package com.example.demospringsecurity.service;

import com.example.demospringsecurity.dao.UserDao;
import com.example.demospringsecurity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //@Transactional(readOnly = true)
    //@Override
    //public List<User> listUsers() {
    //    return userDao.listUsers();
   // }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}

