package com.example.retrofitjsonex.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.retrofitjsonex.databinding.ActivityMainBinding;
import com.example.retrofitjsonex.viewmodel.DataViewModel;
import com.example.retrofitjsonex.R;

public class MainActivity extends AppCompatActivity {
    DataViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        // Request Book list to server
        mViewModel.reqBookList();

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewModel(mViewModel);
        // Init RecyclerView adapter & Request School list to server
        initList(binding);
    }

    // Init RecyclerView adapter & Request School list to server
    protected void initList(ActivityMainBinding binding) {
        // Init RecyclerView adapter
        BookRVAdapter rvAdapter = new BookRVAdapter(mViewModel, this);
        binding.rvBook.setAdapter( rvAdapter );
        binding.rvBook.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        // Show Item Divider on RecyclerView
        binding.rvBook.addItemDecoration(new DividerItemDecoration(this, 1));
    }

}
