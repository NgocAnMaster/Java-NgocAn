package org.example.classList;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@SuperBuilder
public class Student {
    private String name;
    private LocalDate dob;
    private String gender;
    private HashMap<TSubject, Double> scores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HashMap<TSubject, Double> getScores() {
        return scores;
    }

    public void setScores(HashMap<TSubject, Double> scores) {
        this.scores = scores;
    }

    public Student(String name, LocalDate dob, String gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }
}
