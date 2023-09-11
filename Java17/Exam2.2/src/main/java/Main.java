import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Which CSV file do you want to import into the database? (default User.csv): ");
            String file = sc.nextLine();
            if (file.isEmpty()) {
                file = "User.csv";
            }
            checkFile(file);
            System.out.println("Generating list...");
            List<User> users = new ArrayList<>(readCsv(file));
            System.out.println("Pushing into the database...");
            insertUsers(users);
            System.out.println("Done.");
        } catch (Exception e) {
            System.err.println("An unexpected error encountered while processing: See below.");
            e.printStackTrace();
            System.err.println("Try running it again. If the error persists, contact the software developer.");
        }
    }

    private static void insertUsers(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        PreparedStatement userInsrt = connection.prepareStatement(
                "insert into users_lengocan (id, full_name, email, gender, dob, address, salary) values (?, ?, ?, ?, ?, ?, ?)"
        );
        connection.setAutoCommit(false);
        int numUsers = 0;
        for (User user : users) {
            try {
                userInsrt.setInt(1, user.getId());
                userInsrt.setString(2, user.getFullName());
                userInsrt.setString(3, user.getEmail());
                userInsrt.setString(4, user.getGender());
                userInsrt.setDate(5, Date.valueOf(user.getDob()));
                userInsrt.setString(6, user.getAddress());
                userInsrt.setInt(7, user.getSalary());
                userInsrt.addBatch();
                numUsers++;
            } catch (Exception e) {
                System.err.println("Exception occurred while adding 'id=" + user.getId() + ", fullName=" + user.getFullName() + ", email=" + user.getEmail() + ", gender=" + user.getGender() + ", dob=" + user.getDob() + ", address=" + user.getAddress() + ", salary=" + user.getSalary() + "': See below.");
                e.printStackTrace();
            }
        }

        int[] count = userInsrt.executeBatch();

        connection.commit();

        userInsrt.close();
        connection.close();
        System.out.println("Added " + numUsers + " user(s) to the database.");
    }

    public static void checkFile(String file) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("That file was not found - try double-checking your filename");
        }
    }

    private static User readRow(CSVRecord record) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        Integer id = readInteger(record, "id");
        String fullName = readString(record, "full name");
        String email = readString(record, "email");
        String gender = readString(record, "gender");
        LocalDate dob = readDob(record, "dob");
        String address = readString(record, "address");
        Integer salary = readInteger(record, "salary");
        User user = new User(id, fullName, email, gender, dob, address, salary);
        checkNullUser(user);
        return user;
    }

    public static void checkNullUser(User user) {
        Integer id = user.getId();
        String fullName = user.getFullName();
        String email = user.getEmail();
        String gender = user.getGender();
        LocalDate dob = user.getDob();
        String address = user.getAddress();
        Integer salary = user.getSalary();
        if (id == null || fullName.isEmpty() || email.isEmpty() || gender.isEmpty() || dob == null || address.isEmpty() || salary == null)
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
        Integer check;
        try {
            check = Integer.valueOf(rowString);
        } catch (NumberFormatException e) {
            throw new InvalidIntegerException("Invalid format of integer - number(s) expected");
        }
        return check;
    }

    public static LocalDate readDob(CSVRecord row, String col) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        if (row.get(col).isEmpty()) {
            return null;
        }
        LocalDate date;
        try {
            date = LocalDate.parse(row.get(col), formatter);
        } catch (DateTimeException e) {
            throw new InvalidIntegerException("Couldn't parse date: date is in unknown format");
        }
        return date;
    }

    private static List<User> readCsv(String filePath) throws IOException {
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
