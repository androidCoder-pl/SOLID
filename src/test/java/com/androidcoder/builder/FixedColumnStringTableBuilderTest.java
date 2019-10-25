package com.androidcoder.builder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FixedColumnStringTableBuilderTest {

    private FixedColumnStringTableBuilder builder;

    @Before
    public void setUp() {
        builder = new FixedColumnStringTableBuilder();
    }

    @Test
    public void shouldWriteOnlyThreeRow() {
        builder.drawRow("a", "b", "c", "d");
        String row = builder.getTable();
        String expected = String.format("| a          | b          | c          |%n");
        assertEquals(expected, row);
    }

    @Test
    public void shouldWriteRow() {
        builder.drawRow("a", "b", "c");
        String table = builder.getTable();
        String expected = String.format("| a          | b          | c          |%n");
        assertEquals(expected, table);
    }

    @Test
    public void shouldWriteLine() {
        builder.drawLine();
        String table = builder.getTable();
        String expected = String.format("----------------------------------------%n");
        assertEquals(expected, table);
    }

    @Test
    public void shouldDeleteAllTableWhenClearTable() {
        builder.drawLine();
        builder.clear();
        String table = builder.getTable();
        assertEquals("", table);
    }
}