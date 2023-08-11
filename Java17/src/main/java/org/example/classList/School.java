package org.example.classList;

import java.util.ArrayList;

public class School {
    private String name;
    private ArrayList<TClass> classes = new ArrayList<>();
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TClass> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<TClass> classes) {
        this.classes = classes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addClass (TClass cl){
        classes.add(cl);
    }
}
