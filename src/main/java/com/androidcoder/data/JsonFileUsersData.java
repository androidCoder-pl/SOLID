package com.androidcoder.data;

import com.androidcoder.model.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonFileUsersData implements UsersData {

    private List<User> users;

    public JsonFileUsersData(File file, Gson gson) {
        try (FileReader fileReader = new FileReader(file)) {
            convertJsonToUserList(gson, fileReader);
        } catch (IOException e) {
            makeListEmpty();
        }
    }

    private void convertJsonToUserList(Gson gson, FileReader fileReader) {
        User[] usersList = gson.fromJson(fileReader, User[].class);
        users = Arrays.asList(usersList);
    }

    private void makeListEmpty() {
        users = Collections.emptyList();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
