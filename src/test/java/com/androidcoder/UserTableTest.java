package com.androidcoder;

import com.androidcoder.mocks.data.MockUsersData;
import com.androidcoder.mocks.writer.SpyUsersWriter;
import com.androidcoder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.androidcoder.generator.UserListGenerator.createUsersCollection;

public class UserTableTest {

    private MockUsersData usersData = new MockUsersData();

    private SpyUsersWriter writer = new SpyUsersWriter();

    private UserTable userTable;

    @Before
    public void setUp() {
        userTable = new UserTable(usersData, writer);
    }

    @Test
    public void shouldWriteAllElementsFromTheList() {
        List<User> users = createUsersCollection(3);
        usersData.returnsUsers(users);
        userTable.writeTableOnScreen();
        writer.verifyWriteData(users);
    }

    @Test
    public void shouldWriteAllElementsWithoutChangingOrder() {
        List<User> users = createUsersCollection(3);
        usersData.returnsUsers(users);
        userTable.writeTableOnScreen();
        writer.verifyWriteData(users);
    }
}