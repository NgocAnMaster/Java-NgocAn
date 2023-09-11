package org.example.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void checkNullUser(User user) {
        Integer id = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String gender = user.getGender();
        if (id == null || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || gender.isEmpty())
            throw new NullRowValueException("A row with empty value(s) was detected");
    }

    public static String readString(CSVRecord row, String col) {
        return row.get(col);
    }

    public static Integer readInteger(CSVRecord row, String col) {
        String rowString = row.get(col);
        if (rowString.isEmpty()) {
            return null;
        }
        return Integer.valueOf(rowString);
    }

    public static void main(String[] args) throws IOException {
//        List<User> users = new ArrayList<>(readCSV("src/main/java/org/example/csv/users.csv"));
//        for (User user : users) {
//            System.out.println(user);
//        }
        List<User> users1 = new ArrayList<>(readCSV("src/main/java/org/example/csv/users_new.csv"));
        for (User user : users1) {
            System.out.println(user);
        }
    }

    public static User readRow(CSVRecord row) {
        Integer id = readInteger(row, "id");
        String firstName = readString(row, "first_name");
        String lastName = readString(row, "last_name");
        String email = readString(row, "email");
        String gender = readString(row, "gender");
        User user = new User(id, firstName, lastName, email, gender);
        checkNullUser(user);
        return user;
    }

    public static List<User> readCSV(String filePath) throws IOException {
//        String[] HEADERS = {"id", "first_name", "last_name", "email", "gender"};
        List<User> reader = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord record : csvParser) {
            try {
                reader.add(readRow(record));
            } catch (Exception e) {
                System.err.println("Error encountered while processing:");
                e.printStackTrace();
                System.err.println("Record skipped.");
            }
        }
        return reader;
    }
}
