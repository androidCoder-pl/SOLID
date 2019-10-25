package com.androidcoder.data.json;

import com.google.gson.Gson;

public class GsonConverter implements JsonConverter {

    private Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T fromJson(JsonData jsonData, Class<T> classOf) {
        return gson.fromJson(jsonData.getJsonString(), classOf);
    }
}