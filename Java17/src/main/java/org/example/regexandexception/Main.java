package org.example.regexandexception;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(String name, String gender, LocalDate dob){
        try {
            Student student = new Student(name, gender, dob);
            students.add(student);
            System.out.println("Successfully added " + student.getName() + ", gender: " + student.getGender() + ", date of birth: " + student.getDob() + " to the student list.");
        }
        catch (CommonException e){
            System.out.println("An error occurred:");
            System.out.println("Error: " + e.getErrorCode() + ", more info: " + e.getExtraInfo());
        }
    }

    public static void main(String[] args) {
        addStudent("Nguyen 36", "male", LocalDate.of(2012, 3, 6));
        addStudent("Nguyen Duc Anh", "male", LocalDate.of(2008, 9, 9));
        addStudent("Le Hai Dang", "female", LocalDate.of(2009, 1, 23));
        addStudent("Phuong Thi &(@*(&@^)", "female", LocalDate.of(2014, 4, 1));
        addStudent("Le Thi An", "male", LocalDate.of(2004, 1, 9));
        if (!students.isEmpty()){
            System.out.println(students.size() + " students added:");
            for (int i = 0; i < students.size(); i++)
                System.out.println("Student " + students.get(i).getName() + ", gender: " + students.get(i).getGender() + ", date of birth: " + students.get(i).getDob());
        }
        else {
            System.out.println("No students added.");
        }
    }
}
