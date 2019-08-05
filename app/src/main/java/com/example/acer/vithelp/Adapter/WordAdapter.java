package com.example.acer.vithelp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.vithelp.R;
import com.example.acer.vithelp.Model.Word;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }

        Word currentWord = getItem(position);
        TextView text = (TextView) listItemView.findViewById(R.id.textview);
        text.setText(currentWord.getName());

        ImageView pro = (ImageView) listItemView.findViewById(R.id.profile_image);
        pro.setImageResource(currentWord.getImageResource());
         return listItemView;
    }


}
