package com.androidcoder.builder;

public class FixedColumnStringTableBuilder implements StringTableBuilder {
    private StringBuilder tableBuilder = new StringBuilder();

    @Override
    public void drawRow(String... row) {
        tableBuilder.append(String.format("| %-10s |", row[0]));
        tableBuilder.append(String.format(" %-10s |", row[1]));
        tableBuilder.append(String.format(" %-10s |%n", row[2]));
    }

    @Override
    public void drawLine() {
        tableBuilder.append(String.format("%40s%n", "").replace(" ", "-"));
    }

    @Override
    public String getTable() {
        return tableBuilder.toString();
    }

    @Override
    public void clear() {
        tableBuilder.delete(0, tableBuilder.length());
    }
}
