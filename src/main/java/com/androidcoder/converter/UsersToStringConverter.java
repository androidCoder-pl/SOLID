package com.androidcoder.converter;

import com.androidcoder.model.User;

import java.util.List;

public interface UsersToStringConverter {
    String toString(List<User> usersList);
}
