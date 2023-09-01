package org.example.jdbc.userpostreaction;

import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            System.out.println(listUsers());
            System.out.println(listPosts(4));
            System.out.println(listReactions(2, null));
            System.out.println(listReactedUsers(2));
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred. Details:");
            e.printStackTrace();
            System.err.println("Try running this file again, or contact a software developer.");
        }
    }

    public static List<User> listUsers() throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users_lengocan");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            users.add(new User(id, firstName, lastName, dob));
        }
        statement.close();
        connection.close();
        return users;
    }

    public static List<Post> listPosts(int userId) throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from posts_lengocan where user_id=" + userId);
        List<Post> posts = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int targetUserId = resultSet.getInt("user_id");
            LocalDateTime publishedAt = resultSet.getTimestamp("published_at").toLocalDateTime();
            String content = resultSet.getString("content");
            posts.add(new Post(id, targetUserId, publishedAt, content));
        }
        statement.close();
        connection.close();
        return posts;
    }

    public static List<Reaction> listReactions(int postId, Type type) throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        if (type == null) {
            resultSet = statement.executeQuery("select * from reactions_lengocan where post_id=" + postId);
        } else {
            resultSet = statement.executeQuery("select * from reactions_lengocan where post_id=" + postId + " and type='" + type + "'");
        }
        List<Reaction> reactions = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int targetPostId = resultSet.getInt("post_id");
            int userId = resultSet.getInt("user_id");
            String reactType = resultSet.getString("type");
            ReactType targetType = ReactType.valueOf(reactType.toUpperCase());
//            System.out.println(targetType);
            reactions.add(new Reaction(id, targetPostId, userId, targetType));
        }
        statement.close();
        connection.close();
        return reactions;
    }

    public static List<User> listReactedUsers(int userId) throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users_lengocan where id=(select user_id from reactions_lengocan where post_id=(select id from posts_lengocan where user_id=" + userId + "))");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            users.add(new User(id, firstName, lastName, dob));
        }
        statement.close();
        connection.close();
        return users;
    }
}
