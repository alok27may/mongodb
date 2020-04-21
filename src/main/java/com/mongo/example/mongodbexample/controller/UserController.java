package com.mongo.example.mongodbexample.controller;

import com.mongo.example.mongodbexample.model.User;
import com.mongo.example.mongodbexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(method = {GET})
    public List<User> getUsers() {
        return userService.getUserList();
    }

    @RequestMapping(method = PUT)
    public List<User> saveUser(@RequestBody final User user) {
        userService.saveUser(user);
        return getUsers();
    }


}
