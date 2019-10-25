package com.androidcoder.data.json;

public interface JsonConverter {
    <T> T fromJson(JsonData jsonData, Class<T> classOf);
}