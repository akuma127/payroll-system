package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Person {
    private String jobTitle;
    String EMPLOYEE_FILE_PATH = "Persons.txt";


    public Admin(String name, String personID, String password, String jobTitle,String EMPLOYEE_FILE_PATH) {
        super(name, personID, password);
        this.jobTitle = jobTitle;
        this.EMPLOYEE_FILE_PATH = EMPLOYEE_FILE_PATH;
    }
    public Admin(String name, String personID, String password, String jobTitle) {
        super(name, personID, password);
        this.jobTitle = jobTitle;

    }


    public String getJobTitle() { return jobTitle; }
    public void saveEmployeeToFile(String name, String username, String password, String role) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(this.EMPLOYEE_FILE_PATH, true))) {

            writer.newLine();
            writer.write(name + "," + username + "," + password + "," + role);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean removeEmployeeFromFile(String username) {
        List<String> remainingLines = new ArrayList<>();
        boolean found = false;


        try (BufferedReader reader = new BufferedReader(new FileReader(this.EMPLOYEE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // Assuming format: Name,Username,Password,Role
                String[] details = line.split(",");
                if (details.length >= 2 && details[1].equalsIgnoreCase(username)) {
                    found = true; // Skip this line to "remove" it
                } else {
                    remainingLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.EMPLOYEE_FILE_PATH, false))) {
                for (int i = 0; i < remainingLines.size(); i++) {
                    writer.write(remainingLines.get(i));
                    if (i < remainingLines.size() - 1) {
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return found;
    }
    public String[] findEmployee(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("[source")) continue;
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[1].equalsIgnoreCase(username)) {
                    return parts;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmployeeInFile(String username, String name, String pass, String role) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.startsWith("[source")) {
                    String[] parts = line.split(",");
                    if (parts.length >= 4 && parts[1].equalsIgnoreCase(username)) {
                        lines.add(name + "," + username + "," + pass + "," + role);
                        continue;
                    }
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_FILE_PATH))) {
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}