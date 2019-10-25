package com.androidcoder.mocks.builder;

import com.androidcoder.builder.StringTableBuilder;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SpyStringTableBuilder implements StringTableBuilder {

    public static String MOCK_TABLE = "[MOCK]";

    private static String LINE = "--line--";

    private ArrayList<String> actualRows = new ArrayList<>();

    private int clearCounter = 0;

    @Override
    public void drawRow(String... row) {
        actualRows.add(joinRow(row));
    }

    private String joinRow(String[] row) {
        return String.join("", row);
    }

    public void verifyRow(int rowNumber, String... row) {
        String expectedRow = joinRow(row);
        assertThat(actualRows.get(rowNumber), is(expectedRow));
    }

    @Override
    public void drawLine() {
        actualRows.add(LINE);
    }

    public void verifyLine(int rowNumber) {
        assertThat(actualRows.get(rowNumber), is(LINE));
    }

    @Override
    public String getTable() {
        return MOCK_TABLE;
    }

    @Override
    public void clear() {
        clearCounter++;
    }

    public void verifyClear() {
        assertThat("Clear invoked many times", clearCounter, is(1));
    }
}
