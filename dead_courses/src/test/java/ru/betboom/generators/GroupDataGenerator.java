package ru.betboom.generators;

import ru.betboom.model.UserData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    public static void main (String[] args) {
      int count = Integer.parseInt(args[0]);
      File file = new File(args[1]);

      List<UserData> users = generateUsers(count);
      save(users, file);
    }

    private static void save(List<UserData> users, File file) {
    }

    private static List<UserData> generateUsers(int count) {
        List<UserData> users = new ArrayList<UserData>();
        for (int i = 0; i < count; i++) {

        }
    }

}
