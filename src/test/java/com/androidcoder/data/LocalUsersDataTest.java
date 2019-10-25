package com.androidcoder.data;

import com.androidcoder.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LocalUsersDataTest {

    LocalUsersData localUsersData;

    @Before
    public void setUp() throws Exception {
        localUsersData = new LocalUsersData();
    }

    @Test
    public void allUsersShouldHaveName() throws Exception {
        for (User user : localUsersData.getUsers()) {
            assertNotNull(user.getName());
        }
    }

    @Test
    public void allUsersShouldHaveLastName() throws Exception {
        for (User user : localUsersData.getUsers()) {
            assertNotNull(user.getLastName());
        }
    }

    @Test
    public void allUsersShouldHaveId() throws Exception {
        for (User user : localUsersData.getUsers()) {
            assertNotNull(user.getId());
        }
    }
}