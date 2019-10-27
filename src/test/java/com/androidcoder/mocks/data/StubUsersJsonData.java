package com.androidcoder.mocks.data;

import com.androidcoder.data.json.JsonData;
import com.androidcoder.model.User;

import java.util.ArrayList;
import java.util.List;

public class StubUsersJsonData implements JsonData {

    private User user = new User("Avery", "Horn", "a123");

    @Override
    public String getJsonString() {
        return
                "[{" +
                "\"id\":" + user.getId() +
                ",\"name\": \"" + user.getName() + "\"" +
                ",\"lastName\": \"" + user.getLastName() + "\"" +
                "}]";
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }
}