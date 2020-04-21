package com.mongo.example.mongodbexample.dal;

import com.mongo.example.mongodbexample.model.User;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Service;

@Service
public class MongoConnection {

    private MongoCollection<User> userMongoCollection;

    public MongoCollection<User> getMongoUserCollection() {
        if (userMongoCollection == null) {
            userMongoCollection = createUserMongoCollection();
        }
        return userMongoCollection;
    }

    private MongoCollection<User> createUserMongoCollection() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .build();
        try {
            MongoClient mongoClient = MongoClients.create(clientSettings);
            MongoDatabase db = mongoClient.getDatabase("alokdb");
            return db.getCollection("users", User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
