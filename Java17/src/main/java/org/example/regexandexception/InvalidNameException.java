package org.example.regexandexception;

public class InvalidNameException extends CommonException {
    private String name;

    public InvalidNameException(String name) {
        super(100, "Name \"" + name + "\" is not valid");
        this.name = name;
    }
}
