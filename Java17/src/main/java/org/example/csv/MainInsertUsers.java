package org.example.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainInsertUsers {
    public static void main(String[] args) {
        try {
            List<User> userList = new ArrayList<>(readCSV("src/main/java/org/example/csv/users_new.csv"));
            insertUsers(userList);
            System.out.println("Done.");
        } catch (Exception e) {
            System.err.println("Try running it again or contact the software publisher.");
        }
    }

    public static void insertUsers(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        PreparedStatement userInsrt = connection.prepareStatement(
                "insert into users_lengocan (id, first_name, last_name, email, gender) values (?, ?, ?, ?, ?)"
        );
        connection.setAutoCommit(false);
        for (User user : users) {
            try {
                userInsrt.setInt(1, user.getId());
                userInsrt.setString(2, user.getFirstName());
                userInsrt.setString(3, user.getLastName());
                userInsrt.setString(4, user.getEmail());
                userInsrt.setString(5, user.getGender());
                userInsrt.addBatch();
            } catch (Exception e) {
                System.err.println("Exception occurred while adding 'id=" + user.getId() + ", firstName=" + user.getFirstName() + ", lastName=" + user.getLastName() + ", email=" + user.getEmail() + ", gender=" + user.getGender() + "': See below.");
                e.printStackTrace();
            }
        }

        int[] count = userInsrt.executeBatch();

        connection.commit();

        userInsrt.close();
        connection.close();
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
