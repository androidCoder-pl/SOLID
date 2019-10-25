package com.androidcoder.writer;

import com.androidcoder.converter.UsersToStringConverter;
import com.androidcoder.model.User;

import java.util.List;

public class UsersTableScreenWriter implements UsersWriter {

    private UsersToStringConverter stringConverter;
    private AlphanumericScreen alphanumericScreen;

    public UsersTableScreenWriter(UsersToStringConverter userTable, AlphanumericScreen alphanumericScreen) {
        this.stringConverter = userTable;
        this.alphanumericScreen = alphanumericScreen;
    }

    @Override
    public void writeData(List<User> usersData) {
        alphanumericScreen.print(stringConverter.toString(usersData));
    }
}
