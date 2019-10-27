package com.androidcoder.mocks.data;

import com.androidcoder.data.json.JsonData;
import com.androidcoder.model.User;

public class StubUserJsonData implements JsonData {

    private User user = new User("Avery", "Horn", "a123");

    @Override
    public String getJsonString() {
        return
                "{" +
                "\"id\":" + user.getId() +
                ",\"name\": \"" + user.getName() + "\"" +
                ",\"lastName\": \"" + user.getLastName() + "\"" +
                "}";
    }

    public User getUser() {
        return user;
    }
}