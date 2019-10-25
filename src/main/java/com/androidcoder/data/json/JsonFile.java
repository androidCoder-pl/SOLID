package com.androidcoder.data.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JsonFile implements JsonData {

    private File file;

    public JsonFile(File file) {
        this.file = file;
    }

    @Override
    public String getJsonString() {
        try {
            byte[] jsonBytes = Files.readAllBytes(file.toPath());
            return new String(jsonBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "";
        }
    }
}