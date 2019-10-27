package com.androidcoder.mocks.converter;

import com.androidcoder.converter.UsersToStringConverter;
import com.androidcoder.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockUsersToStringConverter implements UsersToStringConverter {

    private Map<List<User>, String> stringTable = new HashMap<>();

    public MockUsersToStringConverter(List<User> usersList, String stringTable){
        this.stringTable.put(usersList, stringTable);
    }

    @Override
    public String toString(List<User> usersList) {
        return stringTable.get(usersList);
    }
}
