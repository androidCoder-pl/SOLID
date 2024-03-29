package com.androidcoder.data;

import com.androidcoder.model.User;

import java.util.LinkedList;
import java.util.List;

public class LocalUsersData implements UsersData {

    private List<User> users = new LinkedList<>();

    public LocalUsersData() {
        users.add(new User("Michał", "Kowalski", "MK1"));
        users.add(new User("Daniel", "Miły", "DM1"));
        users.add(new User("Iza", "Cytryna", "IC1"));
        users.add(new User("Ireneusz", "Czapka", "IC2"));
    }

    public List<User> getUsers() {
        return users;
    }
}
