package org.example.homework.database;

import java.time.ZonedDateTime;

public class School extends Record {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public School(Integer id, ZonedDateTime createdAt, ZonedDateTime updatedAt, String name, String address) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + getId() +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
