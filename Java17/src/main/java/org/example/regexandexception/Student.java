package org.example.regexandexception;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String gender;
    private LocalDate dob;
    Pattern lettersOnly = Pattern.compile("^[A-Za-z\\s]*$");

    public Student(String name, String gender, LocalDate dob) {
        this.name = name;
        if (!name.matches(lettersOnly.toString())){
            throw new InvalidNameException(name);
        }
        this.gender = gender;
        this.dob = dob;
        if (dob.getYear() < 2006 || dob.getYear() > 2017){
            throw new InvalidDobException(dob);
        }
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }
}
