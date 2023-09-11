JAVA 2 PRACTICE EXAM

Given the list of users as in the attached CSV file. Fulfill the following requirements:

1. Import Apache’s commons-csv library
2. Create a User class that describes the data in the CSV file
3. Create class Main
4. Create a method named readRow in Main to read data from a row in the CSV file and return the corresponding User
   object:
   private static User readRow(org.apache.commons.csv.CSVRecord record)Check if the data in each column exists and throw
   an Exception if any data is missing

5. Create a readCsv method in Main that uses the commons-csv library to read the given CSV file and call the readRow
   method declared above then return a list of User:
   private static List<User> readCsv(String filePath)Note that you need to remove rows with missing data in the returned
   results

6. Create table users_<yourname> in the given PostgreSQL database with <yourname> in the format: first_name +
   last_name (abbreviation) + middle_name (abbreviation). For example:
   Nguyen Van Chien -> users_chiennv

7. Create an insertUsers method in Main that uses JDBC to insert a list of Users into the table created above:
   private static void insertUsers(List<User> users)
8. In the method main(), call the predefined method readCsv() and insertUsers() to read and insert data into the
   database. After that print out the total number of users inserted.

Connection information:
Host: 4.194.217.58
Port: 5432
User: t2301e
Password: t2301e
Database: t2301e