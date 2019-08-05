package com.example.acer.vithelp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.acer.vithelp.Model.FeedbackWord;
import com.example.acer.vithelp.R;

import java.util.ArrayList;

public class FeedStudentAdapter extends ArrayAdapter<FeedbackWord> {


    public FeedStudentAdapter(Context context, ArrayList<FeedbackWord> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.feedbackstudentlist, parent, false);
        }

        FeedbackWord cword = getItem(position);
        TextView date = (TextView) listItemView.findViewById(R.id.sdate);
        date.setText(cword.getDate());
        TextView time = (TextView) listItemView.findViewById(R.id.stime);
        time.setText(cword.getTime());
        TextView type = (TextView) listItemView.findViewById(R.id.stype);
        type.setText(cword.getType());
        TextView to = (TextView) listItemView.findViewById(R.id.sproblem);
        to.setText(cword.getProb());
        TextView cc = (TextView) listItemView.findViewById(R.id.sbtype);
        cc.setText(cword.getBlocktype());
        TextView sub = (TextView) listItemView.findViewById(R.id.sblock);
        sub.setText(cword.getBlock());

        TextView des = (TextView) listItemView.findViewById(R.id.sdesp);
        des.setText(cword.getDesp());
        TextView pr = (TextView) listItemView.findViewById(R.id.sprogress);
        String progress = cword.getProgress();
        pr.setText(progress);
        View v = (View) listItemView.findViewById(R.id.root);
        if (progress.equals("On Process")) {
            v.setBackgroundColor(Color.parseColor("#F4D03F"));
        } else if (progress.equals("Reject")) {
            v.setBackgroundColor(Color.parseColor("#EC7063"));
        }else if (progress.equals("Completed")) {
            v.setBackgroundColor(Color.parseColor("#EC7063"));
        }

        return listItemView;
    }
}

