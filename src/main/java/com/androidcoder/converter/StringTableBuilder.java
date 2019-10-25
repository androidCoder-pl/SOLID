package com.androidcoder.converter;

public class StringTableBuilder {
    private StringBuilder tableBuilder = new StringBuilder();

    public void drawRow(String... row) {
        tableBuilder.append(String.format("| %-10s |", row[0]));
        tableBuilder.append(String.format(" %-10s |", row[1]));
        tableBuilder.append(String.format(" %-10s |%n", row[2]));
    }

    public void drawLine() {
        tableBuilder.append(String.format("%40s%n", "").replace(" ", "-"));
    }

    public String getTable() {
        return tableBuilder.toString();
    }

    public void clear() {
        tableBuilder.delete(0, tableBuilder.length());
    }
}
