package com.androidcoder.converter;

import com.androidcoder.generator.UserListGenerator;
import com.androidcoder.mocks.builder.SpyStringTableBuilder;
import com.androidcoder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserListTableConverterTest {

    private static int CONTENT_ROW_OFFSET = 3;

    private SpyStringTableBuilder stringTableBuilder = new SpyStringTableBuilder();

    private UserListTableConverter userListTableConverter;

    @Before
    public void setUp() {
        userListTableConverter = new UserListTableConverter(stringTableBuilder);
    }

    @Test
    public void shouldCreateHeader() {
        List<User> userList = UserListGenerator.createUsersCollection(3);
        userListTableConverter.toString(userList);
        assertHeaderDraw();
    }

    @Test
    public void shouldConvertAllUsersIntoRows() {
        List<User> userList = UserListGenerator.createUsersCollection(10);
        userListTableConverter.toString(userList);
        assertUsersInRows(userList);
    }

    @Test
    public void shouldClearOldTableWhenNewUsersListConvert() {
        List<User> userList = UserListGenerator.createUsersCollection(10);
        userListTableConverter.toString(userList);
        stringTableBuilder.verifyClear();
    }


    @Test
    public void shouldDrawLineAtTheEndOfTable() {
        List<User> userList = UserListGenerator.createUsersCollection(3);
        userListTableConverter.toString(userList);
        assertEndLine(userList.size());
    }

    @Test
    public void shouldReturnTableGeneratedByBuilder() {
        List<User> userList = UserListGenerator.createUsersCollection(3);
        String table = userListTableConverter.toString(userList);
        assertThat(table, is(stringTableBuilder.getTable()));
    }

    private void assertEndLine(int contentRowsCount) {
        stringTableBuilder.verifyLine(contentRowsCount + CONTENT_ROW_OFFSET);
    }

    private void assertUsersInRows(List<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            stringTableBuilder.verifyRow(i + CONTENT_ROW_OFFSET, user.getId(), user.getName(), user.getLastName());
        }
    }

    private void assertHeaderDraw() {
        stringTableBuilder.verifyLine(0);
        stringTableBuilder.verifyRow(1, "ID", "NAME", "LASTNAME");
        stringTableBuilder.verifyLine(2);
    }
}