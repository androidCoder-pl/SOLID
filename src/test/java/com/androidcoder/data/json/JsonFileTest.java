package com.androidcoder.data.json;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class JsonFileTest {

    String jsonString = "{\"data\":\"json\"}";

    private File file;

    private JsonFile jsonFile;

    @Before
    public void setUp() throws Exception {
        createTestFile();
    }

    @After
    public void tearDown() {
        deleteTestFile();
    }

    private void deleteTestFile() {
        file.deleteOnExit();
    }

    private void createTestFile() throws IOException {
        new File("build/tmp/testFiles").mkdir();
        file = new File("build/tmp/users.json");
        Writer writer = new FileWriter(file);
        writer.write(jsonString);
        writer.close();
    }

    @Test
    public void shouldReturnEmptyStringWhenIOExceptionccuOrsDuringOpenFile(){
        jsonFile = new JsonFile(new File("not/known/path/users.json"));
        String result = jsonFile.getJsonString();
        assertEquals("", result);
    }

    @Test
    public void shouldReturnJsonStringWhenFileIsNotEmpty() throws Exception {
        jsonFile = new JsonFile(file);
        String results = jsonFile.getJsonString();
        assertThat(results, is(jsonString));
    }
}