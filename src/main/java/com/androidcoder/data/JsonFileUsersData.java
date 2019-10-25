package com.androidcoder.data;

import com.androidcoder.data.json.JsonConverter;
import com.androidcoder.data.json.JsonData;
import com.androidcoder.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonFileUsersData implements UsersData {

    private List<User> users;

    private JsonConverter jsonConverter;

    private JsonData jsonData;

    public JsonFileUsersData(JsonData jsonData, JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
        this.jsonData = jsonData;
        convertJsonToUserList();
    }

    private void convertJsonToUserList() {
        User[] usersList = jsonConverter.fromJson(jsonData, User[].class);
        users = usersList != null ? Arrays.asList(usersList) : Collections.emptyList();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
