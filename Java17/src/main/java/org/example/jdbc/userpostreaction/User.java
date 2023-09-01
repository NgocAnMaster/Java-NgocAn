package org.example.jdbc.userpostreaction;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
