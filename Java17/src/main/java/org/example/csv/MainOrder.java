package org.example.csv;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainOrder {
    @SneakyThrows
    public static Connection connect() {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://4.194.217.58:5432/t2301e",
                "t2301e",
                "t2301e"
        );
    }

    public static void main(String[] args) throws IOException, SQLException {
        try {
            List<Order> orders = new ArrayList<>(readCSV("src/main/java/org/example/csv/orders.csv"));
//        System.out.println(orders);
//            for (Order order : orders) {
//                System.out.println(order);
//            }

            insertOrders(orders);
            System.out.println("Done.");
        } catch (Exception e) {
            System.err.println("Exception: ");
            e.printStackTrace();
            System.err.println("Try running it again or contact the software publisher.");
        }
    }

    public static List<User> getUsers() throws SQLException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users_lengocan");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String gender = resultSet.getString("gender");
            users.add(new User(id, firstName, lastName, email, gender));
        }
        statement.close();
        connection.close();
        return users;
    }

    // read orders
    public static Order readRow(CSVRecord row) {
        Integer id = readInteger(row, "id");
        Integer userId = readInteger(row, "user id");
        String product = readString(row, "product");
        Integer quantity = readInteger(row, "quantity");
        Order order = new Order(id, userId, product, quantity);
        checkNullOrder(order);
        return order;
    }

    public static void checkNullOrder(Order order) {
        Integer id = order.getId();
        Integer userId = order.getUserId();
        String product = order.getProduct();
        Integer quantity = order.getQuantity();
        if (id == null || userId == null || product.isEmpty() || quantity == null)
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

    public static List<Order> readCSV(String filePath) throws IOException {
//        String[] HEADERS = {"id", "first_name", "last_name", "email", "gender"};
        List<Order> reader = new ArrayList<>();
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

    public static void insertOrders(List<Order> orders) throws SQLException {
        Connection connection = connect();
        PreparedStatement orderInsrt = connection.prepareStatement(
                "insert into order_lengocan (id, user_id, product, quantity) values (?, ?, ?, ?)"
        );
        connection.setAutoCommit(false);

        List<User> users = new ArrayList<>(getUsers());

        List<Integer> userIds = users.stream()
                .map(u -> u.getId()).collect(Collectors.toList());

        List<Order> filteredOrders = orders.stream()
                .filter(o -> userIds.contains(o.getUserId()))
                .collect(Collectors.toList());

        for (Order filteredOrder : filteredOrders) {
            try {
                orderInsrt.setInt(1, filteredOrder.getId());
                orderInsrt.setInt(2, filteredOrder.getUserId());
                orderInsrt.setString(3, filteredOrder.getProduct());
                orderInsrt.setInt(4, filteredOrder.getQuantity());
                orderInsrt.addBatch();
            } catch (Exception e) {
                System.err.println("Exception occurred while adding 'id=" + filteredOrder.getId() + ", user id=" + filteredOrder.getUserId() + ", product=" + filteredOrder.getProduct() + ", quantity=" + filteredOrder.getQuantity() + "': See below.");
                e.printStackTrace();
            }
        }

        int[] count = orderInsrt.executeBatch();

        connection.commit();

        orderInsrt.close();
        connection.close();
    }
}
