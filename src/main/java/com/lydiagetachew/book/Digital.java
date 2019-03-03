package com.lydiagetachew.book;

public class Digital extends Book {
    private float size;

    public Digital(String title, String id, String name, int numberOfPages, String publisher, String publishedDate, String author) {
        super(title, id, name, numberOfPages, publisher, publishedDate, author);
    }

    public Digital() {
        super();
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
