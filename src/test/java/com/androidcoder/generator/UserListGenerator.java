package com.androidcoder.generator;


import com.androidcoder.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListGenerator {
    public static List<User> createUsersCollection(int count) {
        List<User> users = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            User user = new User("NAME_" + i, "LAST_NAME_" + i, "ID_" + i);
            users.add(user);
        }
        return users;
    }
}
