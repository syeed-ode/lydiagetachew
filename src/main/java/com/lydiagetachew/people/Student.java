package com.lydiagetachew.people;

public class Student extends Academic {

    private String year;

    public Student(String name, String id, String email, String phone) {
        super(name, id, email, phone);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
