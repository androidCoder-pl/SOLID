package com.androidcoder;

import com.androidcoder.builder.FixedColumnStringTableBuilder;
import com.androidcoder.builder.StringTableBuilder;
import com.androidcoder.converter.UserListTableConverter;
import com.androidcoder.converter.UsersToStringConverter;
import com.androidcoder.data.JsonFileUsersData;
import com.androidcoder.data.UsersData;
import com.androidcoder.data.json.GsonConverter;
import com.androidcoder.data.json.JsonConverter;
import com.androidcoder.data.json.JsonFile;
import com.androidcoder.screen.DefaultScreen;
import com.androidcoder.writer.AlphanumericScreen;
import com.androidcoder.writer.UsersTableScreenWriter;
import com.androidcoder.writer.UsersWriter;
import com.google.gson.Gson;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("users.json");
        JsonFile jsonFile = new JsonFile(file);
        JsonConverter jsonConverter = new GsonConverter(new Gson());
        UsersData usersData = new JsonFileUsersData(jsonFile, jsonConverter);
        StringTableBuilder stringTableBuilder = new FixedColumnStringTableBuilder();
        UsersToStringConverter usersToStringConverter = new UserListTableConverter(stringTableBuilder);
        AlphanumericScreen alphanumericScreen = new DefaultScreen(System.out);
        UsersWriter usersWriter = new UsersTableScreenWriter(usersToStringConverter, alphanumericScreen);
        UserTable userTable = new UserTable(usersData, usersWriter);
        userTable.writeTableOnScreen();
    }
}
