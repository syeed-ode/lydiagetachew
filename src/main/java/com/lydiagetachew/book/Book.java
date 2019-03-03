package com.lydiagetachew.book;

public class Book {
    protected String title,id,name,publisher, publishedDate,author;
    protected int numberOfPages;
    public Book(String title, String id, String name, int numberOfPages, String publisher, String publishedDate, String author)
    {
        this.title=title;
        this.id=id;
        this.name=name;
        this.numberOfPages = numberOfPages;
        this.publisher=publisher;
        this.publishedDate = publishedDate;
        this.author=author;

    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return " ||Book name= " + name + "\t|| Book id " + id + "|| No_of pages "+ numberOfPages+"|| Author "+ author +"  || pubisher= " + publisher + "  || Published date "+publishedDate+  "]\n";
    }
}
