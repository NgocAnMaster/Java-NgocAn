package org.example.file;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.net.http.common.Log.HEADERS;

public class ReadFile {
    public static void main(String[] args) throws IOException {
//        File file = new File("src/main/java/org/example/file/test1.hello");
//
//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] bytes = fileInputStream.readAllBytes();
//
//        String s = new String(bytes);
//        System.out.println(s);

//        Path path = Paths.get("src/main/java/org/example/file/test1.hello");
////        String strings = Files.readString(path);
//        List<String> strings1 = Files.readAllLines(path);
//
//        System.out.println(strings1);


//        Student student = new Student();
//        student.setName("khoi");
//        student.setSchool("fpt");
//
//        byte[] data = SerializationUtils.serialize(student);
//
//        Files.write(Paths.get("src/main/java/org/example/file/student.txt"), data);

//        byte[] bytes = Files.readAllBytes(Paths.get("src/main/java/org/example/file/student.txt"));
//        Student student = SerializationUtils.deserialize(bytes);
//        System.out.println(student);

        Reader in = new FileReader("src/main/java/org/example/file/student.csv");
        String[] HEADERS = {"Number", "Name", "Age", "Gender"};

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);
        List<Student> students = new ArrayList<>();
        for (CSVRecord record : records) {
            Integer number = Integer.parseInt(record.get("Number"));
            String name = record.get("Name");
            Integer age = Integer.parseInt(record.get("Age"));
            Gender gender = Gender.convert(record.get("Gender"));

            Student student = Student.builder()
                    .number(number)
                    .name(name)
                    .age(age)
                    .gender(gender)
                    .build();

            students.add(student);
        }
    }

    public static Object test(){
        return null;
    }
}
