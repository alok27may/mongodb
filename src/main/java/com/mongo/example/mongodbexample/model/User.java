package com.mongo.example.mongodbexample.model;

public class User {

    private String name;
    private int age;
    private String gender;
    private String status;

    public User() {
    }

    public User(final String name, final int age, final String gender, final String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
