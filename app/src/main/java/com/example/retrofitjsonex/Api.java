package com.example.retrofitjsonex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    // Hero Full URL : https://simplifiedcoding.net/demos/marvel/
    // BookStore Full URL : http://de-coding-test.s3.amazonaws.com/books.json
    //String BASE_URL = "https://simplifiedcoding.net/demos/";
    String BASE_URL = "http://de-coding-test.s3.amazonaws.com/";

    //@GET("marvel")
    //Call<List<Hero>> getHeroes();

    @GET("books.json")
    Call<List<Book>> getBooks();

}
