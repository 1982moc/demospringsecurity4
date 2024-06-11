package com.example.demospringsecurity.dao;

import com.example.demospringsecurity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> findByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
    }

}