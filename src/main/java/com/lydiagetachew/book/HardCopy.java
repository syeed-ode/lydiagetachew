package com.lydiagetachew.book;

public class HardCopy extends Book {

    private String numberofbooks;

    public HardCopy(String title, String id, String name, int numberOfPages, String publisher, String publishedDate, String author) {
        super(title, id, name, numberOfPages, publisher, publishedDate, author);
    }

    public HardCopy() {

    }

    public String getNumberofbooks() {
        return numberofbooks;
    }

    public void setNumberofbooks(String numberofbooks) {
        this.numberofbooks = numberofbooks;
    }
}
