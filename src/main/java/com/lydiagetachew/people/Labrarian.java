package com.lydiagetachew.people;

public class Labrarian extends Person {
    private String username;
    private String password;

    public Labrarian(String name, String id, String email, String phone) {
        super(name, id, email, phone);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
