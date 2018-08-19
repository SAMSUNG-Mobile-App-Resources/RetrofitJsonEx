package com.example.retrofitjsonex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDG on 2018-06-08.
 */

// Adaptor class which connect ListView with data Array
public class BookItemAdaptor extends BaseAdapter {
    Context mMaincon;
    LayoutInflater mInflater;
    //ArrayList<Book> mArSrc;
    List<Book> mArSrc;
    int layout;

    // Init member variable
    BookItemAdaptor(Context context, int alayout, List<Book> aarSrc) {
        mMaincon = context;
        mInflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mArSrc = aarSrc;
        layout = alayout;
    }

    // return of Items count
    public int getCount() {
        return mArSrc.size();
    }

    // return special item's text data
    public String getItem(int position) {
        return mArSrc.get(position).getTitle();
    }

    // return special item's ID
    public long getItemId(int position) {
        return position;
    }

    // input data to ListView item's each widget
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        if (convertView == null) {
            convertView = mInflater.inflate(layout, parent, false);
        }

        // Enter data to TextView
        TextView textView1 = (TextView)convertView.findViewById(R.id.textTitle);
        textView1.setText(mArSrc.get(position).getTitle());

        // Set resource image to ImageView
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        if( mArSrc.get(position).bmpImage != null ) {
            img.setImageBitmap(mArSrc.get(position).bmpImage);
        }
        else {
            img.setImageResource(R.drawable.empty);
        }

        return convertView;
    }

}