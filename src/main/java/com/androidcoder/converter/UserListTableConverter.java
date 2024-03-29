package com.androidcoder.converter;

import com.androidcoder.builder.StringTableBuilder;
import com.androidcoder.model.User;

import java.util.List;

public class UserListTableConverter implements UsersToStringConverter {

    private StringTableBuilder stringTableBuilder;

    public UserListTableConverter(StringTableBuilder stringTableBuilder) {
        this.stringTableBuilder = stringTableBuilder;
    }

    public String toString(List<User> usersList) {
        convertToStringTable(usersList);
        return stringTableBuilder.getTable();
    }

    private void convertToStringTable(List<User> usersList) {
        clearOldTableData();
        drawTableHeader();
        drawMainTableData(usersList);
    }

    private void clearOldTableData() {
        stringTableBuilder.clear();
    }

    private void drawMainTableData(List<User> usersList) {
        stringTableBuilder.drawLine();
        for (User user : usersList) {
            stringTableBuilder.drawRow(user.getId(), user.getName(), user.getLastName());
        }
        stringTableBuilder.drawLine();
    }

    private void drawTableHeader() {
        stringTableBuilder.drawLine();
        stringTableBuilder.drawRow("ID", "NAME", "LASTNAME");
    }
}
