package org.example.file;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("Nam"), FEMALE("Nu");
    private final String value;

    public static Gender convert(String value) {
//if (value.equals(MALE.getValue())){
        if (MALE.getValue().equals(value)){
            return MALE;
        } else if (value.equals(FEMALE.getValue())){
            return FEMALE;
        }
        return null;
    }
}
