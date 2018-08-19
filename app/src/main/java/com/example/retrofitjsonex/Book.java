package com.example.retrofitjsonex;

import android.graphics.Bitmap;

public class Book {
    private String title = null;
    private String author = null;
    private String imageURL = null;
    public Bitmap bmpImage = null;

    public Book(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

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
