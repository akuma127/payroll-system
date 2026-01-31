package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static final String FILE_NAME = "Persons.txt";

    public static List<Person> loadPersons() {
        List<Person> personList = new ArrayList<>();
//Exception
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                // assuming format name, id, password, jobTitle
                String[] parts = line.split(",");

                if (parts.length >= 4) {
                    String name = parts[0].trim();
                    String id = parts[1].trim();
                    String pass = parts[2].trim();
                    String title = parts[3].trim();

                    // if ID contains "admin", they are model.Admin
                    // Otherwise, they are model.Employee
                    if (title.toLowerCase().contains("admin")) {
                        personList.add(new Admin(name, id, pass, title));
                    } else {
                        personList.add(new Employee(name, id, pass, title));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Persons.txt: " + e.getMessage());
            e.printStackTrace();
        }

        return personList;
    }
}