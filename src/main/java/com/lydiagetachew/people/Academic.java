package com.lydiagetachew.people;

public class Academic extends Person {
    private String dept;

    public Academic(String name, String id, String email, String phone) {
        super(name, id, email, phone);
    }

    @Override
    public String toString() {
        return ("Person Name="+getName()+"Id"+getId()+"E-mail "+getEmail()+","+"Phone "+getPhone()+"department="+dept);
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
