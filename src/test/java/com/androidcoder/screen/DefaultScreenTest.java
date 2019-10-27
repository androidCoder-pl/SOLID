package com.androidcoder.screen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class DefaultScreenTest {


    PrintStream printStream;

    DefaultScreen defaultScreen;

    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);

        defaultScreen = new DefaultScreen(printStream);
    }


    @Test
    public void shouldPrintAndMoveToNextLine() throws Exception {
        String something = "Some text to print".trim();
        defaultScreen.print(something);

        String result = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        assertEquals("\n", result.substring(result.length() - 1));
    }
}