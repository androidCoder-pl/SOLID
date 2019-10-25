package com.androidcoder.mocks.data;

import com.androidcoder.data.UsersData;
import com.androidcoder.model.User;

import java.util.List;

public class MockUsersData implements UsersData {

    private List<User> users = null;

    @Override
    public List<User> getUsers() {
        return users;
    }

    public void returnsUsers(List<User> returnUsers) {
        users = returnUsers;
    }
}
