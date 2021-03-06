package com.mongo.example.mongodbexample.service;

import com.mongo.example.mongodbexample.model.User;
import com.mongo.example.mongodbexample.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired private UserDao userDao;

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public void saveUser(final User user) {
        userDao.save(user);
    }
}
