package com.androidcoder;

import java.util.LinkedList;
import java.util.List;

public class UsersData {

    private List<User> users = new LinkedList<>();
    private StringBuilder tableBuilder = new StringBuilder();

    public UsersData() {
        users.add(new User("Michał", "Kowalski", "MK1"));
        users.add(new User("Daniel", "Miły", "DM1"));
        users.add(new User("Iza", "Cytryna", "IC1"));
        users.add(new User("Ireneusz", "Czapka", "IC2"));
    }

    public void printTable() {

        drawLine();
        drawRow("ID", "NAME", "LASTNAME");
        drawLine();
        for (User user : users) {
            drawRow(user.getId(), user.getName(), user.getLastName());
        }
        drawLine();
        System.out.println(tableBuilder.toString());
    }

    private void drawRow(String... row) {
        tableBuilder.append(String.format("| %-10s |", row[0]));
        tableBuilder.append(String.format(" %-10s |", row[1]));
        tableBuilder.append(String.format(" %-10s |%n", row[2]));
    }

    private void drawLine() {
        tableBuilder.append(String.format("%40s%n", "").replace(" ", "-"));
    }
}
