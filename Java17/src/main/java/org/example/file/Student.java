package org.example.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
    private Integer number;
    private String name;
    private Integer age;
    private Gender gender;
//    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getSchool() {
//        return school;
//    }
//
//    public void setSchool(String school) {
//        this.school = school;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
//                ", school='" + school + '\'' +
                '}';
    }
}
