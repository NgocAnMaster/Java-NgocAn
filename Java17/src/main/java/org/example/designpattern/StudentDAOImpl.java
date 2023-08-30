package org.example.designpattern;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @SneakyThrows
    @Override
    public List<Student> findAllStudents() {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            students.add(Student.builder().name(name).build());
        }
        return students;
    }

    @Override
    public void insert(List<Student> students) {

    }

    @Override
    public List<Student> findStudentsByDobLessThan(LocalDate date) {
        return null;
    }
}
