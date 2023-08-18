package org.example.regexandexception2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String gender;
    private LocalDate dob;
    Pattern lettersOnly = Pattern.compile("^[A-Za-z\\s]*$");

    public Student(String name, String gender, LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        List<ValidationError> errors = new ArrayList<>();
        if (!name.matches(lettersOnly.toString())){
            errors.add(new ValidationError(100, "Name " + name + " is not valid"));
        }
        if (dob.getYear() < 2006 || dob.getYear() > 2017){
            errors.add(new ValidationError(200, "Year " + dob.getYear() + " is not valid"));
        }
        if (!errors.isEmpty()){
            throw new CommonException(errors);
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
