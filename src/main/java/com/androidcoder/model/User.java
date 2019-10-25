package com.androidcoder.model;

public class User {
    private String name;
    private String lastName;
    private String id;

    public User(String name, String lastName, String id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

}
