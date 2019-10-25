package com.androidcoder.screen;

import com.androidcoder.writer.AlphanumericScreen;

import java.io.PrintStream;

public class DefaultScreen implements AlphanumericScreen {
    private PrintStream printStream;

    public DefaultScreen(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void print(String text) {
        printStream.println(text);
    }
}