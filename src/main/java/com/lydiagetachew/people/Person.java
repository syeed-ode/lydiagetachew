package com.lydiagetachew.people;

public class Person {
    private String name;
    private String id;
    private String email;
    private String phone;


    public Person(String name,String id, String email,String phone)
    {
        this.name=name;
        this.id=id;
        this.email=email;
        this.phone=phone;
    }

    @Override
    public String toString()
    {

        return ("Person Name="+name+"Id"+id+"E-mail "+email+","+"Phone "+phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
