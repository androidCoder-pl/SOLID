package com.androidcoder.writer;

import com.androidcoder.converter.UsersToStringConverter;
import com.androidcoder.model.User;

import java.util.List;

public class UsersTableScreenWriter implements UsersWriter {

    private UsersToStringConverter stringConverter;

    public UsersTableScreenWriter(UsersToStringConverter userTable) {
        this.stringConverter = userTable;
    }

    @Override
    public void writeData(List<User> usersData) {
        System.out.println(stringConverter.toString(usersData));
    }
}
