package org.example.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void checkNullUser(User user) {
        Integer id = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String gender = user.getGender();
        if (firstName.isEmpty())
            throw new WarningException(new DataWarning(id, "first_name"));
        if (lastName.isEmpty())
            throw new WarningException(new DataWarning(id, "last_name"));
        if (email.isEmpty())
            throw new WarningException(new DataWarning(id, "email"));
        if (gender.isEmpty())
            throw new WarningException(new DataWarning(id, "gender"));
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
//        List<User> users1 = new ArrayList<>(readCSV("src/main/java/org/example/csv/users_new.csv"));
        List<DataWarning> dataWarnings = new ArrayList<>(dataWarningList("src/main/java/org/example/csv/users_new.csv"));
        for (DataWarning dataWarning : dataWarnings) {
            System.out.println(dataWarning);
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
        List<DataWarning> warnings = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord record : csvParser) {
            try {
                reader.add(readRow(record));
            } catch (WarningException e) {
                warnings.add(e.getWarning());
            } catch (Exception e) {
                System.err.println("Error encountered while processing:");
                e.printStackTrace();
                System.err.println("Record skipped.");
            }
        }
        csvParser.close();
        System.out.println(warnings);
        return reader;
    }

    public static List<DataWarning> dataWarningList(String filePath) throws IOException {
        List<DataWarning> warnings = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord record : csvParser) {
            try {
                Integer id = readInteger(record, "id");
                if (id == null) {
                    warnings.add(new DataWarning(null, "id"));
                }
                String firstName = readString(record, "first_name");
                if (firstName.isEmpty()) {
                    warnings.add(new DataWarning(id, "first_name"));
                    continue;
                }
                String lastName = readString(record, "last_name");
                if (lastName.isEmpty()) {
                    warnings.add(new DataWarning(id, "last_name"));
                    continue;
                }
                String email = readString(record, "email");
                if (email.isEmpty()) {
                    warnings.add(new DataWarning(id, "email"));
                    continue;
                }
                String gender = readString(record, "gender");
                if (gender.isEmpty()) {
                    warnings.add(new DataWarning(id, "gender"));
                }
            } catch (Exception e) {
                System.err.println("Error encountered while processing:");
                e.printStackTrace();
                System.err.println("Record skipped.");
            }
        }
        return warnings;
    }
}
