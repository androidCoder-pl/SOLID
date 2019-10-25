package com.androidcoder.writer;

import com.androidcoder.converter.UserListTableConverter;
import com.androidcoder.model.User;

import java.util.List;

public class UsersTableScreenWriter {
    public void writeTableOnScreen(List<User> usersData) {
        String stringTable = convertUsersListToTable(usersData);
        writeTableOnScreen(stringTable);
    }

    private void writeTableOnScreen(String stringTable) {
        System.out.println(stringTable);
    }

    private String convertUsersListToTable(List<User> usersData) {
        UserListTableConverter userTable = new UserListTableConverter();
        return userTable.toString(usersData);
    }
}
