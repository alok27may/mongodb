package com.mongo.example.mongodbexample.persistence;

import com.mongo.example.mongodbexample.dal.MongoConnection;
import com.mongo.example.mongodbexample.model.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired private MongoConnection connection;



    public List<User> getUserList() {
        final List<User> users = new ArrayList<>();
        final MongoCollection<User> userCollection = connection.getMongoUserCollection();
        final FindIterable<User> userList = userCollection.find();
        for (final User user : userList) {
            users.add(user);
        }
        return users;
    }

    public void save(final User user) {
        final MongoCollection<User> userCollection = connection.getMongoUserCollection();
        userCollection.insertOne(user);
    }
}
