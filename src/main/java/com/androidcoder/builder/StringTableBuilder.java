package com.androidcoder.builder;

public interface StringTableBuilder {
    void drawRow(String... row);

    void drawLine();

    String getTable();

    void clear();
}
