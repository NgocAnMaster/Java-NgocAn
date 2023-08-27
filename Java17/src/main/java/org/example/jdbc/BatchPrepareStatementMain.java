package org.example.jdbc;

import java.sql.*;

public class BatchPrepareStatementMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );

//        Statement statement = connection.createStatement();
//        statement.executeUpdate("insert into lengocan (id, name, dob) values (1, 'khoi', '2023-08-08')");

        PreparedStatement statement = connection.prepareStatement(
                "insert into lengocan (id, name, dob) values (?, ?, ?)"
        );
        connection.setAutoCommit(false);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
//            statement.executeUpdate(
//                    "insert into lengocan (id, name, dob) values (" + (i + 1) + ", 'test', '1999-10-12')"
//            );
            statement.setInt(1, 103 + i);
            statement.setString(2, "khoi");
//        statement.setDate(3, new Date(LocalDate.now().toEpochDay()));
            statement.setDate(3, new Date(1692798953));
            statement.addBatch();
        }


        int[] count = statement.executeBatch();

        connection.commit();

        statement.close();
        connection.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
