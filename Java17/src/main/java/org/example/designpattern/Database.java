package org.example.designpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    private static final String url = "";
    private static final String user = "";
    private static final String password = "";
    private static final String driver = "";

    //Singleton
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
