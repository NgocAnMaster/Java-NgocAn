package org.example.regexandexception2;

import java.util.List;

public class CommonException extends RuntimeException{
    private List<ValidationError> errors;

    public CommonException(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }
}
