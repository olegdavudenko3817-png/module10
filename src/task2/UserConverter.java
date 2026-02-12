package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserConverter {
    static void main(String[] args) {
        printUserConverter("src/task2/file.txt", "src/task2/user.json");
    }

    public static void printUserConverter(String filePath, String fileName) {
        List<User> users = new ArrayList<>();

        try (BufferedReader buff = new BufferedReader(new FileReader(filePath))) {
            String line;
            buff.readLine();

            while((line = buff.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);

                users.add(new User(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fw = new FileWriter(fileName)) {
            gson.toJson(users, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
