package com.androidcoder.writer;

import com.androidcoder.converter.UsersToStringConverter;
import com.androidcoder.mocks.converter.MockUsersToStringConverter;
import com.androidcoder.mocks.writer.SpyAlphanumericScreen;
import com.androidcoder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class UsersTableScreenWriterTest {

    private String mockTable = "[TABLE]";

    private UsersToStringConverter stringConverter = new MockUsersToStringConverter(listOfUsers(), mockTable);

    private SpyAlphanumericScreen alphanumericScreen = new SpyAlphanumericScreen();

    private UsersTableScreenWriter screenWriter;

    @Before
    public void setUp() {
        screenWriter = new UsersTableScreenWriter(stringConverter, alphanumericScreen);
    }

    @Test
    public void shouldWriteUsersDataOnAlphanumericScreen() throws Exception {
        screenWriter.writeData(listOfUsers());

        alphanumericScreen.verifyPrinted(mockTable);
    }

    private List<User> listOfUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Avery", "Horn", "a123"));
        users.add(new User("Henry", "Black", "a125"));
        return users;
    }

}