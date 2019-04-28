package com.example.retrofitjsonex.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.retrofitjsonex.model.Api;
import com.example.retrofitjsonex.model.Book;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {

    protected MutableLiveData<List<Book>> mListBooks;

    @Inject
    Api mApi;

    // Constructor - Inject Retrofit API object
    public DataViewModel() {
        ApiComponent component = DaggerApiComponent.builder().build();
        component.inject(this);
    }

    // Return Book data list
    public MutableLiveData<List<Book>> getListBooks() {
        if (mListBooks == null) {
            mListBooks = new MutableLiveData<List<Book>>();
        }
        return mListBooks;
    }

    //===============================================

    // Request Book data list to server
    public void reqBookList() {
        Call<List<Book>> call = mApi.getBooks();
        call.enqueue(new Callback<List<Book>>() {

            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                // When completed, get data & save
                List<Book> listBooks = response.body();
                getListBooks().setValue(listBooks);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                String message = t.getMessage();
            }
        });
    }

}
