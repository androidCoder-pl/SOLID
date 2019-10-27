package com.androidcoder.data;

import com.androidcoder.data.json.GsonConverter;
import com.androidcoder.data.json.JsonConverter;
import com.androidcoder.mocks.data.StubUsersJsonData;
import com.androidcoder.mocks.data.json.StubNullJsonConverter;
import com.androidcoder.model.User;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class JsonFileUsersDataTest {

    private StubUsersJsonData jsonData = new StubUsersJsonData();

    private JsonConverter jsonConverter;


    @Test
    public void shouldReturnEmptyListWhenJsonConverterReturnNull() {
        jsonConverter = new StubNullJsonConverter();
        JsonFileUsersData jsonFileUsersData = new JsonFileUsersData(jsonData, jsonConverter);

        List<User> users = jsonFileUsersData.getUsers();

        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    @Test
    public void shouldReturnListWhenJsonConverterReturnObjects() {
        jsonConverter = new GsonConverter(new Gson());
        JsonFileUsersData jsonFileUsersData = new JsonFileUsersData(jsonData, jsonConverter);

        List<User> users = jsonFileUsersData.getUsers();

        assertThat(users, is(jsonData.getUsers()));
    }
}