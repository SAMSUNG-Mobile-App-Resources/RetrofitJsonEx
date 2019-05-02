package com.example.retrofitjsonex.view;

import android.arch.lifecycle.Observer;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.retrofitjsonex.R;
import com.example.retrofitjsonex.databinding.BookListItemBinding;
import com.example.retrofitjsonex.model.Book;
import com.example.retrofitjsonex.viewmodel.DataViewModel;
import java.util.List;

public class BookRVAdapter extends RecyclerView.Adapter<BookRVAdapter.BookVH> {
    private DataViewModel mViewModel;
    AppCompatActivity mParent;
    RecyclerView.Adapter<BookVH> mAdapter;

    // Constructor
    public BookRVAdapter(DataViewModel viewModel, AppCompatActivity parent) {
        this.mViewModel = viewModel;
        this.mParent = parent;
        mAdapter = this;

        // make School simple data list Observer object
        final Observer<List<Book>> booksObserver = new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable final List<Book> schools) {
                // When School simple data list is changed update RecyclerView
                mAdapter.notifyDataSetChanged();
            }
        };
        // Send Observer object to ViewModel
        viewModel.getListBooks().observe(this.mParent, booksObserver);
    }

    // Return list items count
    @Override
    public int getItemCount() {
        // Get the school simple data items count
        List<Book> books = mViewModel.getListBooks().getValue();
        // When the data object is not exist return 0
        if( books == null )
            return 0;
        return books.size();
    }

    // Make ViewHolder & View binding object
    @Override
    public BookVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Get the view binding object of custom list item layout
        LayoutInflater inflater = LayoutInflater.from(mParent);
        BookListItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.book_list_item, viewGroup, false);
        // Set the Lifecycle Owner of View binding to fragment
        binding.setLifecycleOwner(mParent);
        // Set ViewModel object to binding object as a variable
        binding.setViewModel(mViewModel);

        // Make ViewHolder object
        return new BookVH(binding);
    }

    // When ViewHolder is binded set data to binding object
    @Override
    public void onBindViewHolder(BookVH viewHolder, int position) {
        // Set item index number to binding object
        viewHolder.bine(position);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(view);
    }

    // Reuse views
    public static class BookVH extends RecyclerView.ViewHolder {
        public BookListItemBinding binding;

        //public ViewHolder(View itemView) {
        public BookVH(BookListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bine(int index) {
            binding.setIndex(index);
            binding.executePendingBindings();
        }
    }
}
