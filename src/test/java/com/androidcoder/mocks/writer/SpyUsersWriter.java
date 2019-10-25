package com.androidcoder.mocks.writer;

import com.androidcoder.model.User;
import com.androidcoder.writer.UsersWriter;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SpyUsersWriter implements UsersWriter {

    private int invokeCounter = 0;
    private List<User> actualUserData = null;

    @Override
    public void writeData(List<User> usersData) {
        invokeCounter++;
        actualUserData = usersData;
    }

    public void verifyWriteData(List<User> expectedUsersData) {
        assertThat("Invoke multiple times", invokeCounter, is(1));
        assertThat(actualUserData, equalTo(expectedUsersData));
    }
}
