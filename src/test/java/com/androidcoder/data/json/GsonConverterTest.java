package com.androidcoder.data.json;

import com.androidcoder.mocks.data.StubUserJsonData;
import com.androidcoder.model.User;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GsonConverterTest {

    private Gson gson = new Gson();

    private StubUserJsonData jsonData = new StubUserJsonData();

    private GsonConverter gsonConverter;

    @Before
    public void setUp() {
        gsonConverter = new GsonConverter(gson);
    }

    @Test
    public void gsonShouldParseJsonFromJsonDataObject() {
        User actualUser = gsonConverter.fromJson(jsonData, User.class);
        assertThat(actualUser, is(jsonData.getUser()));
    }
}