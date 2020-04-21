package com.mongo.example.mongodbexample;

import com.mongo.example.mongodbexample.model.User;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

public class MongoClientTest {

    private static final String USERS_COLLECTION = "user";

    public static void main1(String[] args) {
//        // creating mongo Client
//        final MongoClient mongoClient = new MongoClient();
//
//        // accessing alokdb database
//        final MongoDatabase database = mongoClient.getDatabase("alokdb");
//
//        //creating and retrieving Collection users
//        database.createCollection(USERS_COLLECTION);
//        final MongoCollection<User> usersCollection = database.getCollection(USERS_COLLECTION, User.class);
//
//        // inserting document in collection
////        final Document document = new Document("name", "alok");
////        document.append("age", 31);
////        document.append("gender", "male");
////        document.append("status", "active");
//
//        final User user = new User("ankita", 29, "female", "active");
//
//        usersCollection.insertOne(user);
//
//        System.out.println("Successfully created document in collection");


    }

    public static void main(String[] args) {
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .codecRegistry(codecRegistry)
                    .build();
            try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
                MongoDatabase db = mongoClient.getDatabase("alokdb");
                MongoCollection<User> userColl = db.getCollection("users", User.class);

                final User user = new User("amit", 34, "male", "inactive");

                // create a new grade.
//                userColl.insertOne(user);
                final FindIterable<User> users = userColl.find();
                List<User> userList = new ArrayList<>();
                for (final User user1 : users) {
                    userList.add(user1);
                }

                System.out.println("User List" + userList);

                // find this grade.
//                Grade grade = userColl.find(eq("student_id", 10003d)).first();
//                System.out.println("Grade found:\t" + grade);

                // update this grade: adding an exam grade
//                List<Score> newScores = new ArrayList<>(grade.getScores());
//                newScores.add(new Score().setType("exam").setScore(42d));
//                grade.setScores(newScores);
//                Document filterByGradeId = new Document("_id", grade.getId());
//                FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
//                Grade updatedGrade = userColl.findOneAndReplace(filterByGradeId, grade, returnDocAfterReplace);
//                System.out.println("Grade replaced:\t" + updatedGrade);
//
//                // delete this grade
//                System.out.println(userColl.deleteOne(filterByGradeId));
            }
    }
}
