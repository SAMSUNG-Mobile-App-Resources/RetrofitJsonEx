package com.example.retrofitjsonex.model;

import com.example.retrofitjsonex.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Api {

    // Make Retrofit object
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build();

    // Hero Full URL : https://simplifiedcoding.net/demos/marvel/
    // BookStore Full URL : http://de-coding-test.s3.amazonaws.com/books.json
    String BASE_URL = "http://de-coding-test.s3.amazonaws.com/";

    //@GET("marvel")
    //Call<List<Hero>> getHeroes();

    @GET("books.json")
    Call<List<Book>> getBooks();

}
