package org.example.classList;

import java.util.ArrayList;

public abstract class TClass {
    private String name;
    private String grade;
    private ArrayList<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public TClass(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public void addStudent (Student st){
        students.add(st);
    }

    public abstract Double averageScore();
}
