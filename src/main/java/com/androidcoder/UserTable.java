package com.androidcoder;

import com.androidcoder.datasource.UsersData;
import com.androidcoder.writer.UsersTableScreenWriter;

public class UserTable {
    public void printUserTableOnScreen() {
        UsersData usersData = new UsersData();
        UsersTableScreenWriter usersTableScreenWriter = new UsersTableScreenWriter();
        usersTableScreenWriter.writeTableOnScreen(usersData.getUsers());
    }
}
