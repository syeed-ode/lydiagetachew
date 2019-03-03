package com.lydiagetachew.people;

public class Lecture extends Academic {
    private String title;
    private int maxBook;

    public Lecture(String name, String id, String email, String phone) {
        super(name, id, email, phone);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxBook() {
        return maxBook;
    }

    public void setMaxBook(int maxBook) {
        this.maxBook = maxBook;
    }
}
