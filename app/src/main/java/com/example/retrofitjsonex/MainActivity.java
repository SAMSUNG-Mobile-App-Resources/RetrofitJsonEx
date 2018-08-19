package com.example.retrofitjsonex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit = null;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewHeroes);

        initListView();

        //calling the method to display the heroes
        getHeroes();
    }

    protected void initListView() {
        // make  Book ArrayList Object
        //mArBook = new ArrayList<Book>();
        // make Adapter object & set to ListView
        //BookItemAdaptor bookListAdapter = new BookItemAdaptor(this, R.layout.book_list_item, mArBook);
        //mListBook = (ListView)findViewById(R.id.listBooks);
        //mListBook.setAdapter(bookListAdapter);
    }

    private void createRetrofit() {
        if( retrofit != null ) return;

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
    }

    private void getHeroes() {
        createRetrofit();
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();*/

        Api api = retrofit.create(Api.class);

        //Call<List<Hero>> call = api.getHeroes();
        Call<List<Book>> call = api.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                List<Book> bookList = response.body();
                BookItemAdaptor bookListAdapter = new BookItemAdaptor(getApplicationContext(), R.layout.book_list_item, bookList);
                listView.setAdapter(bookListAdapter);

                /*//Creating an String array for the ListView
                String[] boks = new String[bookList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < bookList.size(); i++) {
                    heroes[i] = bookList.get(i).getName();
                }*/

                //displaying the string array into listview
                //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
