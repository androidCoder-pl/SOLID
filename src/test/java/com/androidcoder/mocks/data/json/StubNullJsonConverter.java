package com.androidcoder.mocks.data.json;

import com.androidcoder.data.json.JsonConverter;
import com.androidcoder.data.json.JsonData;
import com.androidcoder.model.User;

public class StubNullJsonConverter implements JsonConverter  {

    @Override
    public <T> T fromJson(JsonData jsonData, Class<T> classOf) {
        return (T) new User[0];
    }
}
