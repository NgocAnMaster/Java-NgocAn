package org.example.csv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataWarning {
    private Integer id;
    private String fieldName;

    @Override
    public String toString() {
        return "DataWarning{" +
                "id=" + id +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
