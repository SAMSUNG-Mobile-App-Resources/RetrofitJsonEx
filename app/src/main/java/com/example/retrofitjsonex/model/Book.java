package com.example.retrofitjsonex.model;

public class Book {
    protected String title;
    protected String author;
    protected String imageURL;

    public Book(String title, String author, String imageURL) {
        this.title = title;
        this.author = author;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageURL() {
        return imageURL;
    }
}
