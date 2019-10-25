package com.androidcoder;

import com.androidcoder.builder.FixedColumnStringTableBuilder;
import com.androidcoder.builder.StringTableBuilder;
import com.androidcoder.converter.UserListTableConverter;
import com.androidcoder.converter.UsersToStringConverter;
import com.androidcoder.data.JsonFileUsersData;
import com.androidcoder.data.UsersData;
import com.androidcoder.writer.UsersTableScreenWriter;
import com.androidcoder.writer.UsersWriter;
import com.google.gson.Gson;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("users.json");
        UsersData usersData = new JsonFileUsersData(file, new Gson());
        StringTableBuilder stringTableBuilder = new FixedColumnStringTableBuilder();
        UsersToStringConverter usersToStringConverter = new UserListTableConverter(stringTableBuilder);
        UsersWriter usersWriter = new UsersTableScreenWriter(usersToStringConverter);

        UserTable userTable = new UserTable(usersData, usersWriter);
        userTable.writeTableOnScreen();
    }
}
