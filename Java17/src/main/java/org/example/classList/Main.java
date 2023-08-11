package org.example.classList;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // init school and class
        School fpt = new School("FPT Aptech", "8 Ton That Thuyet");
        MathsClass class6a = new MathsClass("6A", "6");
        // add class to school
        fpt.addClass(class6a);
        // init students info
        Student student1 = Student.builder()
                .name("Nguyen Binh")
                .gender("Male")
                .dob(LocalDate.of(2012, 2, 1))
                .build();
        Student student2 = Student.builder()
                .name("Vu Chien")
                .gender("Male")
                .dob(LocalDate.of(2012, 6, 5))
                .build();
        Student student3 = Student.builder()
                .name("Tran Dung")
                .gender("Female")
                .dob(LocalDate.of(2012, 4, 3))
                .build();
        Student student4 = Student.builder()
                .name("Hoang Dat")
                .gender("Male")
                .dob(LocalDate.of(2012, 9, 2))
                .build();
        Student student5 = Student.builder()
                .name("Dang Trang")
                .gender("Female")
                .dob(LocalDate.of(2012, 12, 11))
                .build();
        // declare enums
        TSubject math = TSubject.MATHS;
        TSubject physics = TSubject.PHYSICS;
        TSubject geography = TSubject.GEOGRAPHY;
        TSubject history = TSubject.HISTORY;
        TSubject biology = TSubject.BIOLOGY;

        // init studentScores using enum and hashmap
        HashMap<TSubject, Double> s1scores = new HashMap<>();
        HashMap<TSubject, Double> s2scores = new HashMap<>();
        HashMap<TSubject, Double> s3scores = new HashMap<>();
        HashMap<TSubject, Double> s4scores = new HashMap<>();
        HashMap<TSubject, Double> s5scores = new HashMap<>();
        // put s1 scores
        s1scores.put(math, 9.5);
        s1scores.put(physics, 8.1);
        s1scores.put(geography, 7.4);
        s1scores.put(history, 8.2);
        s1scores.put(biology, 6.5);
        // put s2 scores
        s2scores.put(math, 8.3);
        s2scores.put(physics, 7.1);
        s2scores.put(geography, 9.4);
        s2scores.put(history, 9.1);
        s2scores.put(biology, 9.6);
        // put s3 scores
        s3scores.put(math, 9.8);
        s3scores.put(physics, 7.2);
        s3scores.put(geography, 9.1);
        s3scores.put(history, 7.2);
        s3scores.put(biology, 7.5);
        // put s4 scores
        s4scores.put(math, 9.1);
        s4scores.put(physics, 9.0);
        s4scores.put(geography, 6.4);
        s4scores.put(history, 6.8);
        s4scores.put(biology, 7.9);
        // put s5 scores
        s5scores.put(math, 6.3);
        s5scores.put(physics, 9.5);
        s5scores.put(geography, 8.0);
        s5scores.put(history, 8.2);
        s5scores.put(biology, 8.3);

        // set score for students
        student1.setScores(s1scores);
        student2.setScores(s2scores);
        student3.setScores(s3scores);
        student4.setScores(s4scores);
        student5.setScores(s5scores);

        // add students to class
        class6a.addStudent(student1);
        class6a.addStudent(student2);
        class6a.addStudent(student3);
        class6a.addStudent(student4);
        class6a.addStudent(student5);

        // calculate student average scores
        System.out.println("Điểm trung bình của lớp 6A: " + class6a.averageScore() + " (approx.).");
    }
}
