package org.example.homework.jdbc;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        try {
            // Direct those file to the correct path when re-downloading or clone
            List<School> schoolList = readSchools("src/main/java/org/example/homework/jdbc/School.csv");
//            System.out.println(schoolList);
            List<Student> studentList = readStudents("src/main/java/org/example/homework/jdbc/Student.csv");
//            System.out.println(studentList);
//            // To avoid errors, execute those insert commands only when the table doesn't have any values duplicate to those values in the insertion.
//            insertSchools(schoolList);
//            insertStudents(studentList);

            List<Student> studentListUpdate = readStudents("src/main/java/org/example/homework/jdbc/Student update.csv");
//            // To avoid errors, execute those update commands only when the table doesn't have any values duplicate to those values in the update.
//            updateStudents(studentListUpdate);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students_lengocan");
            List<Student> studentList1 = new ArrayList<>();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String code = resultSet.getString("code");
                String gender = resultSet.getString("gender");
                String schoolCode = resultSet.getString("school_code");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = resultSet.getTimestamp("updated_at").toLocalDateTime();
                if (LocalDateTime.now().getYear() - dob.getYear() == 18)
                    studentList1.add(new Student(firstName, lastName, code, gender, schoolCode, dob, createdAt, updatedAt));
            }
            statement.close();
            connection.close();
//            for (int i = 0; i < studentList1.size(); i++) {
//                System.out.println((i + 1) + ". " + studentList1.get(i).getFirstName() + " " + studentList1.get(i).getLastName() + " - " + studentList1.get(i).getCode() + ", gender: " + studentList1.get(i).getGender() + ", school code: " + studentList1.get(i).getSchoolCode() + ", date of birth: " + studentList1.get(i).getDob());
//            }
            // update
            insertOrUpdateStudents(studentListUpdate);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        PreparedStatement scInsrt = connection.prepareStatement(
//                "insert into schools_lengocan (name, school_code, address, created_at, updated_at) values (?, ?, ?, ?, ?)"
//        );
//
//        PreparedStatement stInsrt = connection.prepareStatement(
//                "insert into students_lengocan (first_name, last_name, code, gender, school_code, dob, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?)"
//        );
    }

    @SneakyThrows
    public static List<School> readSchools(String filename) {
        List<School> records = new ArrayList<>();
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            records.add(new School(nextRecord[1], nextRecord[2], nextRecord[3], LocalDateTime.now(), LocalDateTime.now()));
        }
        return records;
    }

    @SneakyThrows
    public static List<Student> readStudents(String filename) {
        List<Student> records = new ArrayList<>();
        FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(nextRecord[6], dateTimeFormatter);
            records.add(new Student(nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5], date, LocalDateTime.now(), LocalDateTime.now()));
        }
        return records;
    }

    public static void insertSchools(List<School> schools) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        PreparedStatement scInsrt = connection.prepareStatement(
                "insert into schools_lengocan (name, school_code, address, created_at, updated_at) values (?, ?, ?, ?, ?)"
        );
        connection.setAutoCommit(false);
        for (School school : schools) {
            scInsrt.setString(1, school.getName());
            scInsrt.setString(2, school.getCode());
            scInsrt.setString(3, school.getAddress());
            scInsrt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            scInsrt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            scInsrt.addBatch();
        }
        int[] count = scInsrt.executeBatch();

        connection.commit();

        scInsrt.close();
        connection.close();
    }

    public static void insertStudents(List<Student> students) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        PreparedStatement stInsrt = connection.prepareStatement(
                "insert into students_lengocan (first_name, last_name, code, gender, school_code, dob, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?)"
        );
        connection.setAutoCommit(false);
        for (Student student : students) {
            stInsrt.setString(1, student.getFirstName());
            stInsrt.setString(2, student.getLastName());
            stInsrt.setString(3, student.getCode());
            stInsrt.setString(4, student.getGender());
            stInsrt.setString(5, student.getSchoolCode());
            stInsrt.setDate(6, Date.valueOf(student.getDob()));
            stInsrt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            stInsrt.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            stInsrt.addBatch();
        }
        int[] count = stInsrt.executeBatch();

        connection.commit();

        stInsrt.close();
        connection.close();
    }

    public static void updateStudents(List<Student> students) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        PreparedStatement stUpdte = connection.prepareStatement(
                "update students_lengocan set first_name=?, last_name=?, gender=?, school_code=?, dob=?, updated_at=? where code=?"
        );
        connection.setAutoCommit(false);
        for (Student student : students) {
            stUpdte.setString(1, student.getFirstName());
            stUpdte.setString(2, student.getLastName());
            stUpdte.setString(3, student.getGender());
            stUpdte.setString(4, student.getSchoolCode());
            stUpdte.setDate(5, Date.valueOf(student.getDob()));
            stUpdte.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            stUpdte.setString(7, student.getCode());
            stUpdte.addBatch();
        }
        int[] count = stUpdte.executeBatch();

        connection.commit();

        stUpdte.close();
        connection.close();
    }

    public static List<Student> studentOver18(List<Student> students) {
        List<Student> studentOver18 = new ArrayList<>();
        for (Student student : students) {
            if (calculateAge(student.getDob()) >= 18) {
                studentOver18.add(student);
            }
        }
        return studentOver18;
    }

    //the method calculates the age
    public static int calculateAge(LocalDate dob) {
//creating an instance of the LocalDate class and invoking the now() method
//now() method obtains the current date from the system clock in the default time zone
        LocalDate curDate = LocalDate.now();
//calculates the amount of time between two dates and returns the years
        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }


    public static void insertOrUpdateStudents(List<Student> students) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
        PreparedStatement stUpdte = connection.prepareStatement(
                "insert into students_lengocan (first_name, last_name, code, gender, school_code, dob, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?) on conflict on constraint students_lengocan_pk do update set first_name=?, last_name=?, gender=?, school_code=?, dob=?, updated_at=?"
        );
        connection.setAutoCommit(false);
        for (Student student : students) {
            stUpdte.setString(1, student.getFirstName());
            stUpdte.setString(2, student.getLastName());
            stUpdte.setString(3, student.getCode());
            stUpdte.setString(4, student.getGender());
            stUpdte.setString(5, student.getSchoolCode());
            stUpdte.setDate(6, Date.valueOf(student.getDob()));
            stUpdte.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            stUpdte.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            stUpdte.setString(9, student.getFirstName());
            stUpdte.setString(10, student.getLastName());
            stUpdte.setString(11, student.getGender());
            stUpdte.setString(12, student.getSchoolCode());
            stUpdte.setDate(13, Date.valueOf(student.getDob()));
            stUpdte.setTimestamp(14, Timestamp.valueOf(LocalDateTime.now()));
        }
        int[] count = stUpdte.executeBatch();

        connection.commit();

        stUpdte.close();
        connection.close();
    }
}
