package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );

        Statement statement = connection.createStatement();

//        statement.executeUpdate(
//                "create table lengocan\n" +
//                        "(\n" +
//                        "    id   serial\n" +
//                        "        constraint khoivn_pk\n" +
//                        "            primary key,\n" +
//                        "    name varchar,\n" +
//                        "    dob  date\n" +
//                        ");\n" +
//                        "\n"
//        );

//        ResultSet resultSet = statement.executeQuery("select * from lengocan");

//        List<Student> students = new ArrayList<>();
//
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            Date dob = resultSet.getDate("dob");
//
////            System.out.println(id + " " + name + " " + dob);
//
//            students.add(new Student(id, name, dob));
//        }
//
//        System.out.println(students);
        connection.setAutoCommit(false);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
//            statement.executeUpdate(
//                    "insert into lengocan (id, name, dob) values (" + (i + 1) + ", 'test', '1999-10-12')"
//            );
            statement.addBatch(
                    "insert into lengocan (id, name, dob) values (" + (i + 1) + ", 'test', '1999-10-12')"
            );
        }

        int[] count = statement.executeBatch();

        connection.commit();

        statement.close();
        connection.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
