package org.example.regexandexception;

import java.time.LocalDate;

public class InvalidDobException extends CommonException {
    private LocalDate dob;

    public InvalidDobException(LocalDate dob) {
        super(200, "Year of birth \"" + dob.getYear() + "\" is not valid");
        this.dob = dob;
    }
}
