package com.androidcoder;

import com.androidcoder.data.UsersData;
import com.androidcoder.writer.UsersWriter;

public class UserTable {

    private UsersData usersData;
    private UsersWriter writer;

    public UserTable(UsersData usersData, UsersWriter writer) {
        this.usersData = usersData;
        this.writer = writer;
    }

    public void writeTableOnScreen() {
        writer.writeData(usersData.getUsers());
    }
}
