package org.example;

import java.util.List;

public class Group {
    private Integer age;
    private List<Student> students;

    public Group(Integer age, List<Student> students) {
        this.age = age;
        this.students = students;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "age=" + age +
                ", students=" + students +
                '}';
    }
}
